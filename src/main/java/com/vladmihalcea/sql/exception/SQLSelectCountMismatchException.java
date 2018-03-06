package com.vladmihalcea.sql.exception;

/**
 * SQLSelectCountMismatchException - Thrown whenever there is a mismatch between expected select statements count and
 * the ones being executed.
 *
 * @author Vlad Mihalcea
 */
public class SQLSelectCountMismatchException extends SQLStatementCountMismatchException {

    public SQLSelectCountMismatchException(long expected, long recorded) {
        super(expected, recorded);
    }

    public SQLSelectCountMismatchException(String message, long expected, long recorded) {
        super(message, expected, recorded);
    }
}
