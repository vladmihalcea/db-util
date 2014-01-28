package com.vladmihalcea.sql.exception;

/**
 * SQLUpdateCountMismatchException - Thrown whenever there is a mismatch between expected update statements count and
 * the ones being executed.
 *
 * @author Vlad Mihalcea
 */
public class SQLUpdateCountMismatchException extends SQLStatementCountMismatchException {

    public SQLUpdateCountMismatchException(int expected, int recorded) {
        super(expected, recorded);
    }
}
