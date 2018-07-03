package org.zerhusen.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.zerhusen.exception.NotAuthorizedException;
import org.zerhusen.exception.handling.RestResponseEntityExceptionHandler;
import org.zerhusen.exception.dto.ErrorDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    @Autowired
    private RestResponseEntityExceptionHandler exceptionHandler;

    private static final long serialVersionUID = -8970718410437077606L;

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        // This is invoked when user tries to access a secured REST resource without supplying any credentials
        // We should just send a 401 Unauthorized response because there is no 'login page' to redirect to
        ResponseEntity<ErrorDTO> errorDTO = exceptionHandler.handleRestException(new NotAuthorizedException("Authorization header must be provided!"));
        //set the response object
        response.setStatus(errorDTO.getBody().getHttpStatus().value());
        response.setContentType( MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(objectMapper.writeValueAsString(errorDTO.getBody()));
    }
}
