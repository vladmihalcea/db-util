package com.vladmihalcea.sql.exception;

/**
 * SQLUpdateCountMismatchException - Thrown whenever there is a mismatch between expected update statements count and
 * the ones being executed.
 *
 * @author Vlad Mihalcea
 */
public class SQLUpdateCountMismatchException extends SQLStatementCountMismatchException {

    public SQLUpdateCountMismatchException(long expected, long recorded) {
        super(expected, recorded);
    }

    public SQLUpdateCountMismatchException(String message, long expected, long recorded) {
        super(message, expected, recorded);
    }
}
