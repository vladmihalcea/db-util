package com.vladmihalcea.sql.exception;

/**
 * SQLInsertCountMismatchException - Thrown whenever there is a mismatch between expected insert statements count and
 * the ones being executed.
 *
 * @author Vlad Mihalcea
 */
public class SQLInsertCountMismatchException extends SQLStatementCountMismatchException {

    public SQLInsertCountMismatchException(int expected, int recorded) {
        super(expected, recorded);
    }
}
