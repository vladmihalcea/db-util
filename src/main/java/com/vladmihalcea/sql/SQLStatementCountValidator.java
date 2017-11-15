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

import com.vladmihalcea.sql.exception.SQLDeleteCountMismatchAssertionError;
import com.vladmihalcea.sql.exception.SQLInsertCountMismatchAssertionError;
import com.vladmihalcea.sql.exception.SQLSelectCountMismatchAssertionError;
import com.vladmihalcea.sql.exception.SQLUpdateCountMismatchAssertionError;
import net.ttddyy.dsproxy.QueryCount;
import net.ttddyy.dsproxy.QueryCountHolder;

/**
 * SQLStatementCountValidator - Validates recorded statements count.
 *
 * First you execute some operations against your database and then you check how many statements were executed.
 * This is a useful tool against the "N+1" problem or suboptimal DML statements.
 *
 * @author Vlad Mihalcea
 */
public class SQLStatementCountValidator {

    private SQLStatementCountValidator() {
    }

    /**
     * Reset the statement recorder
     */
    public static void reset() {
        QueryCountHolder.clear();
    }

    /**
     * Assert select statement count
     *
     * @param expectedSelectCount expected select statement count
     */
    public static void assertSelectCount(long expectedSelectCount) {
        QueryCount queryCount = QueryCountHolder.getGrandTotal();
        long recordedSelectCount = queryCount.getSelect();
        if (expectedSelectCount != recordedSelectCount) {
            throw new SQLSelectCountMismatchAssertionError(expectedSelectCount, recordedSelectCount);
        }
    }

    /**
     * Assert insert statement count
     *
     * @param expectedInsertCount expected insert statement count
     */
    public static void assertInsertCount(long expectedInsertCount) {
        QueryCount queryCount = QueryCountHolder.getGrandTotal();
        long recordedInsertCount = queryCount.getInsert();
        if (expectedInsertCount != recordedInsertCount) {
            throw new SQLInsertCountMismatchAssertionError(expectedInsertCount, recordedInsertCount);
        }
    }

    /**
     * Assert update statement count
     *
     * @param expectedUpdateCount expected update statement count
     */
    public static void assertUpdateCount(long expectedUpdateCount) {
        QueryCount queryCount = QueryCountHolder.getGrandTotal();
        long recordedUpdateCount = queryCount.getUpdate();
        if (expectedUpdateCount != recordedUpdateCount) {
            throw new SQLUpdateCountMismatchAssertionError(expectedUpdateCount, recordedUpdateCount);
        }
    }

    /**
     * Assert delete statement count
     *
     * @param expectedDeleteCount expected delete statement count
     */
    public static void assertDeleteCount(long expectedDeleteCount) {
        QueryCount queryCount = QueryCountHolder.getGrandTotal();
        long recordedDeleteCount = queryCount.getDelete();
        if (expectedDeleteCount != recordedDeleteCount) {
            throw new SQLDeleteCountMismatchAssertionError(expectedDeleteCount, recordedDeleteCount);
        }
    }
}
