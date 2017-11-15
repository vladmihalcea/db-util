package com.vladmihalcea.sql.exception;

/**
 * SQLUpdateCountMismatchException - Thrown whenever there is a mismatch between expected update statements count and
 * the ones being executed.
 *
 * @author Vlad Mihalcea
 */
public class SQLUpdateCountMismatchAssertionError extends SQLStatementCountMismatchAssertionError {

    public SQLUpdateCountMismatchAssertionError(long expected, long recorded) {
        super(expected, recorded);
    }
}
