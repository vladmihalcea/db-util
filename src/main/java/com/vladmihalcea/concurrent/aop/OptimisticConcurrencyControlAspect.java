/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.vladmihalcea.concurrent.aop;

import com.vladmihalcea.concurrent.Retry;
import com.vladmihalcea.util.ReflectionUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.IllegalTransactionStateException;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.util.Assert;

import java.util.Arrays;

/**
 * OptimisticConcurrencyControlAspect - Aspect to retry optimistic locking attempts.
 *
 * @author Vlad Mihalcea
 */
@Aspect
public class OptimisticConcurrencyControlAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(OptimisticConcurrencyControlAspect.class);

    @Around("@annotation(com.vladmihalcea.concurrent.Retry)")
    public Object retry(ProceedingJoinPoint pjp) throws Throwable {
        Retry retryAnnotation = ReflectionUtils.getAnnotation(pjp, Retry.class);
        return (retryAnnotation != null) ? proceed(pjp, retryAnnotation) : proceed(pjp);
    }

    private Object proceed(ProceedingJoinPoint pjp) throws Throwable {
        return pjp.proceed();
    }

    private Object proceed(ProceedingJoinPoint pjp, Retry retryAnnotation) throws Throwable {
        int times = retryAnnotation.times();
        Class<? extends Throwable>[] retryOn = retryAnnotation.on();
        Assert.isTrue(times > 0, "@Retry{times} should be greater than 0!");
        Assert.isTrue(retryOn.length > 0, "@Retry{on} should have at least one Throwable!");
        if (retryAnnotation.failInTransaction() && TransactionSynchronizationManager.isActualTransactionActive()) {
            throw new IllegalTransactionStateException(
                    "You shouldn't retry an operation from withing an existing Transaction." +
                            "This is because we can't retry if the current Transaction was already rollbacked!");
        }
        LOGGER.info("Proceed with {} retries on {}", times, Arrays.toString(retryOn));
        return tryProceeding(pjp, times, retryOn);
    }

    private Object tryProceeding(ProceedingJoinPoint pjp, int times, Class<? extends Throwable>[] retryOn) throws Throwable {
        try {
            return proceed(pjp);
        } catch (Throwable throwable) {
            if (isRetryThrowable(throwable, retryOn) && times-- > 0) {
                LOGGER.info("Optimistic locking detected, {} remaining retries on {}", times, Arrays.toString(retryOn));
                return tryProceeding(pjp, times, retryOn);
            }
            throw throwable;
        }
    }

    private boolean isRetryThrowable(Throwable throwable, Class<? extends Throwable>[] retryOn) {
        Throwable[] causes = ExceptionUtils.getThrowables(throwable);
        for (Throwable cause : causes) {
            for (Class<? extends Throwable> retryThrowable : retryOn) {
                if (retryThrowable.isAssignableFrom(cause.getClass())) {
                    return true;
                }
            }
        }
        return false;
    }
}
