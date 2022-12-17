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

package com.vladmihalcea.concurrent;

import java.lang.annotation.*;

/**
 * Retry - mark a given method for retrying.
 *
 * @author Vlad Mihalcea
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface Retry {

    /**
     * Declare the exception types the retry will be issued on.
     *
     * @return exception types causing a retry
     */
    Class<? extends Exception>[] on();

    /**
     * The number of retry attempts
     *
     * @return retry attempts
     */
    int times() default 1;

    /**
     * Fail if the current thread is enlisted in a running transaction.
     *
     * @return fail in case of a running transaction
     */
    boolean failInTransaction() default true;

    /**
     * Retry after delay in milliseconds
     *
     * @return delay for next attempt
     */
    int delay() default 0;

    /**
     * Increase delay for the next attempt. If delay is 50 for the first 
     * attempt then for the second will be 100, for third 150.
     *
     * @return increase delay for the next attempt
     */
    boolean progressiveDelay() default false;
}
