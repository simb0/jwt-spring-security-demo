package org.zerhusen.exception.handling;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.zerhusen.exception.RestException;
import org.zerhusen.exception.dto.ErrorDTO;

/**
 * Created by adrebert on 12.06.2018.
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { RestException.class })
    @ResponseBody
    public ResponseEntity<ErrorDTO> handleRestException(RestException ex) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setErrorMessage(ex.getMessage());
        errorDTO.setHttpStatus(ex.getHttpStatus());

        return new ResponseEntity<>(errorDTO, errorDTO.getHttpStatus());
    }
}
