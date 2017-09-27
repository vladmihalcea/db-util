package com.vladmihalcea.sql.exception;

/**
 * SQLDeleteCountMismatchException - Thrown whenever there is a mismatch between expected delete statements count and
 * the ones being executed.
 *
 * @author Vlad Mihalcea
 */
public class SQLDeleteCountMismatchException extends SQLStatementCountMismatchException {

    public SQLDeleteCountMismatchException(long expected, long recorded) {
        super(expected, recorded);
    }
}
