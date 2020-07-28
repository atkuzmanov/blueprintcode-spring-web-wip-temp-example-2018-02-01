package com.example.exception;

/**
 * Represents an Unchecked exception which might have been encoutnered when interacting with third parties.
 */
public class CommunicationException extends RuntimeException {
    public CommunicationException(String exceptionMessage, Throwable exceptionCause) {
        super(exceptionMessage, exceptionCause);
    }
}
