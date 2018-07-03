package org.zerhusen.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by adrebert on 12.06.2018.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ValidationException extends RestException {

    public ValidationException(String msg) {
        super(msg, ValidationException.class.getAnnotationsByType(ResponseStatus.class)[0].value());
    }
}
