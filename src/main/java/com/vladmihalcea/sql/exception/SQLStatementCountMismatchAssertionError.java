package com.vladmihalcea.sql.exception;

/**
 * SQLStatementCountMismatchException - Thrown whenever there is a mismatch between expected statements count and
 * the ones being executed.
 *
 * @author Vlad Mihalcea
 */
public abstract class SQLStatementCountMismatchAssertionError extends AssertionError {

    private final long expected;
    private final long recorded;

    protected SQLStatementCountMismatchAssertionError(long expected, long recorded) {
        super("Expected " + expected + " statements but recorded " + recorded + " instead!");
        this.expected = expected;
        this.recorded = recorded;
    }

    public long getExpected() {
        return expected;
    }

    public long getRecorded() {
        return recorded;
    }
}
