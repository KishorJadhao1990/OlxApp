package com.zensar.exception;

import com.zensar.util.ErrorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@RestControllerAdvice
public class ApplicationExceptionAdvisor extends ResponseEntityExceptionHandler {

    @Autowired
    private ErrorUtil errorUtil;

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(BadRequestException e) {
        ErrorResponse errorResponse = errorUtil.buildErrorResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorResponse> handleBadCredentialsException(BadCredentialsException e, WebRequest webRequest) {
        ErrorResponse errorResponse = errorUtil.buildErrorResponseEntity(e.getMessage(), HttpStatus.UNAUTHORIZED, Locale.US);
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        final List<ValidationError> errors = new ArrayList<>();
        for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(new ValidationError(error.getField(), error.getDefaultMessage()));
        }
        ErrorResponse errorResponse = errorUtil.buildErrorResponseEntity(status);
        errorResponse.setErrorMessage(errors);
        errorResponse.setErrorCode("error.fieldValidation");
        return new ResponseEntity<>(errorResponse, status);
    }


}

