package org.zerhusen.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by adrebert on 12.06.2018.
 */
@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class NotAuthorizedException extends RestException {

    public NotAuthorizedException(String msg) {
        super(msg, NotAuthorizedException.class.getAnnotationsByType(ResponseStatus.class)[0].value());
    }

}
