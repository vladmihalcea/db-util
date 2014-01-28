package com.vladmihalcea.sql.exception;

/**
 * SQLStatementCountMismatchException - Thrown whenever there is a mismatch between expected statements count and
 * the ones being executed.
 *
 * @author Vlad Mihalcea
 */
public abstract class SQLStatementCountMismatchException extends RuntimeException {

    private final int expected;
    private final int recorded;

    protected SQLStatementCountMismatchException(int expected, int recorded) {
        super("Expected " + expected + " statements but recorded " + recorded + " instead!");
        this.expected = expected;
        this.recorded = recorded;
    }

    public int getExpected() {
        return expected;
    }

    public int getRecorded() {
        return recorded;
    }
}
