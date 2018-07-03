package org.zerhusen.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by adrebert on 26.06.2018.
 */
public abstract class RestException extends RuntimeException {

    public RestException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    private HttpStatus httpStatus;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
