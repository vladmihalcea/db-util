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

import com.vladmihalcea.concurrent.exception.OptimisticLockingException;
import com.vladmihalcea.concurrent.service.CustomerService;
import com.vladmihalcea.concurrent.service.ItemService;
import com.vladmihalcea.concurrent.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.IllegalTransactionStateException;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import static junit.framework.Assert.assertEquals;

/**
 * OptimisticConcurrencyControlAspectTest - OptimisticConcurrencyControlAspect Test
 *
 * @author Vlad Mihalcea
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class OptimisticConcurrencyControlAspectTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ItemService itemService;

    @Test
    public void testRetryOnInterface() {
        assertEquals(0, productService.getRegisteredCalls());
        try {
            productService.saveProduct();
        } catch (OptimisticLockingException expected) {
        }
        //assertEquals(3, productService.getRegisteredCalls());
        //http://stackoverflow.com/questions/2847640/spring-aop-pointcut-that-matches-annotation-on-interface
        assertEquals(1, productService.getRegisteredCalls());
    }

    @Test
    public void testRetryOnImplementation() {
        assertEquals(0, customerService.getRegisteredCalls());
        try {
            customerService.saveCustomer();
        } catch (OptimisticLockingException expected) {
        }
        assertEquals(3, customerService.getRegisteredCalls());
    }

    @Test(expected = IllegalTransactionStateException.class)
    public void testRetryFailsOnTransaction() {
        try {
            TransactionSynchronizationManager.setActualTransactionActive(true);
            itemService.saveItem();
        } finally {
            TransactionSynchronizationManager.setActualTransactionActive(false);
        }
    }

    @Test
    public void testRetryRunsOnTransaction() {
        try {
            TransactionSynchronizationManager.setActualTransactionActive(true);
            assertEquals(0, itemService.getRegisteredCalls());
            try {
                itemService.saveItems();
            } catch (OptimisticLockingException expected) {
            }
            assertEquals(3, itemService.getRegisteredCalls());
        } finally {
            TransactionSynchronizationManager.setActualTransactionActive(false);
        }
    }
}
