package org.zerhusen.exception.dto;

import org.springframework.http.HttpStatus;

/**
 * Created by adrebert on 13.06.2018.
 */
public class ErrorDTO {
    private HttpStatus httpStatus;
    private String errorMessage;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
