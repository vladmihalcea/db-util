package com.vladmihalcea.sql.exception;

/**
 * SQLInsertCountMismatchException - Thrown whenever there is a mismatch between expected insert statements count and
 * the ones being executed.
 *
 * @author Vlad Mihalcea
 */
public class SQLInsertCountMismatchAssertionError extends SQLStatementCountMismatchAssertionError {

    public SQLInsertCountMismatchAssertionError(long expected, long recorded) {
        super(expected, recorded);
    }
}
