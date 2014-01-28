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

package com.vladmihalcea.sql;

import com.vladmihalcea.sql.exception.SQLDeleteCountMismatchException;
import com.vladmihalcea.sql.exception.SQLInsertCountMismatchException;
import com.vladmihalcea.sql.exception.SQLSelectCountMismatchException;
import com.vladmihalcea.sql.exception.SQLUpdateCountMismatchException;
import com.vladmihalcea.sql.service.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.vladmihalcea.sql.SQLStatementCountValidator.*;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

/**
 * SQLStatementCountValidatorTest - SQLStatementCountAspect Test
 *
 * @author Vlad Mihalcea
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class SQLStatementCountValidatorTest {

    @Autowired
    private CustomerService customerService;

    @Before
    public void init() {
        SQLStatementCountValidator.reset();
    }

    @Test
    public void testCountSuccess() {
        customerService.saveCustomerSuccess();
        assertSelectCount(5);
        assertInsertCount(4);
        assertUpdateCount(3);
        assertDeleteCount(2);
    }

    @Test
    public void testCountSelectFailure() {
        try {
            customerService.saveCustomerSelectFailure();
            assertSelectCount(2);
            fail("Should have thrown SQLSelectCountMismatchException!");
        } catch (SQLSelectCountMismatchException e) {
            assertEquals(3, e.getRecorded());
            assertEquals(2, e.getExpected());
        }
    }

    @Test
    public void testCountInsertFailure() {
        try {
            customerService.saveCustomerInsertFailure();
            assertInsertCount(2);
            fail("Should have thrown SQLInsertCountMismatchException!");
        } catch (SQLInsertCountMismatchException e) {
            assertEquals(3, e.getRecorded());
            assertEquals(2, e.getExpected());
        }
    }

    @Test
    public void testCountUpdateFailure() {
        try {
            customerService.saveCustomerUpdateFailure();
            assertUpdateCount(2);
            fail("Should have thrown SQLUpdateCountMismatchException!");
        } catch (SQLUpdateCountMismatchException e) {
            assertEquals(3, e.getRecorded());
            assertEquals(2, e.getExpected());
        }
    }

    @Test
    public void testCountDeleteFailure() {
        try {
            customerService.saveCustomerDeleteFailure();
            assertDeleteCount(2);
            fail("Should have thrown SQLDeleteCountMismatchException!");
        } catch (SQLDeleteCountMismatchException e) {
            assertEquals(3, e.getRecorded());
            assertEquals(2, e.getExpected());
        }
    }
}
