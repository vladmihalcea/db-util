package com.vladmihalcea.sql.exception;

/**
 * SQLSelectCountMismatchException - Thrown whenever there is a mismatch between expected select statements count and
 * the ones being executed.
 *
 * @author Vlad Mihalcea
 */
public class SQLSelectCountMismatchException extends SQLStatementCountMismatchException {

    public SQLSelectCountMismatchException(int expected, int recorded) {
        super(expected, recorded);
    }
}
