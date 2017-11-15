package com.vladmihalcea.sql.exception;

/**
 * SQLSelectCountMismatchException - Thrown whenever there is a mismatch between expected select statements count and
 * the ones being executed.
 *
 * @author Vlad Mihalcea
 */
public class SQLSelectCountMismatchAssertionError extends SQLStatementCountMismatchAssertionError {

    public SQLSelectCountMismatchAssertionError(long expected, long recorded) {
        super(expected, recorded);
    }
}
