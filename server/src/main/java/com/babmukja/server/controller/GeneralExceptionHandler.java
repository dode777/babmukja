package com.babmukja.server.controller;

import com.babmukja.server.error.NotFoundException;
import com.babmukja.server.error.ServiceRuntimeException;
import com.babmukja.server.error.UnauthorizedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
@Slf4j
public class GeneralExceptionHandler {

    private ResponseEntity<Error> response(String errorMessage, HttpStatus httpStatus) {
        return new ResponseEntity<>(new Error(errorMessage), httpStatus);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Error> handleNotFoundException(Exception e) {
        return response(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({
            IllegalStateException.class, IllegalArgumentException.class,
            TypeMismatchException.class, HttpMessageNotReadableException.class,
            MissingServletRequestParameterException.class, MultipartException.class,
    })
    public ResponseEntity<Error> handleBadRequestException(Exception e) {
        log.debug("Bad request exception occurred: {}", e.getMessage(), e);
        return response(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMediaTypeException.class)
    public ResponseEntity<Error> handleHttpMediaTypeException(Exception e) {
        return response(e.getMessage(), HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Error> handleMethodNotAllowedException(Exception e) {
        return response(e.getMessage(), HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(ServiceRuntimeException.class)
    public ResponseEntity<Error> handleServiceRuntimeException(ServiceRuntimeException e) {
        if (e instanceof NotFoundException)
            return response(e.getMessage(), HttpStatus.NOT_FOUND);
        if (e instanceof UnauthorizedException)
            return response(e.getMessage(), HttpStatus.UNAUTHORIZED);

        log.warn("Unexpected service exception occurred: {}", e.getMessage(), e);
        return response(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({Exception.class, RuntimeException.class})
    public ResponseEntity<Error> handleException(Exception e) {
        log.error("Unexpected exception occurred: {}", e.getMessage(), e);
        return response(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
