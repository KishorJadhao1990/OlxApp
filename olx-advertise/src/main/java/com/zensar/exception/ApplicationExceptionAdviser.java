package com.zensar.exception;

import com.zensar.util.ErrorUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class ApplicationExceptionAdviser extends ResponseEntityExceptionHandler {

    @Autowired
    private ErrorUtil errorUtil;

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(BadRequestException exception, WebRequest webRequest) {
        ErrorResponse errorResponse = errorUtil.buildErrorResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST, webRequest.getLocale());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpClientErrorException.Forbidden.class)
    public ResponseEntity<ErrorResponse> handleHeaderMissing(WebRequest webRequest) {
        String errorCode = "invalid.authenticationToken";
        ErrorResponse errorResponse = errorUtil.buildErrorResponseEntity(errorCode, HttpStatus.FORBIDDEN, webRequest.getLocale());
        return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<ErrorResponse> handleHeaderAccessDenied(MissingRequestHeaderException exception, WebRequest webRequest) {
        Object[] params = new Object[10];
        params[0] = exception.getHeaderName();
        String errorCode = "error.requestHeaderMissing";
        ErrorResponse errorResponse = errorUtil.buildErrorResponseEntity(errorCode, HttpStatus.BAD_REQUEST, webRequest.getLocale(), params);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({HttpServerErrorException.ServiceUnavailable.class, ServiceUnavailableException.class})
    protected ResponseEntity<Object> handleServiceUnavailable(WebRequest request) {
        String errorCode = "error.serviceUnavailable";
        ErrorResponse errorResponse = errorUtil.buildErrorResponseEntity(errorCode, HttpStatus.SERVICE_UNAVAILABLE, request.getLocale());
        return new ResponseEntity<>(errorResponse, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        final List<ValidationError> errors = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(new ValidationError(error.getField(), error.getDefaultMessage()));
        }
        ErrorResponse errorResponse = errorUtil.buildErrorResponseEntity(status);
        errorResponse.setErrorCode("error.fieldValidation");
        errorResponse.setErrorMessage(errors);
        return new ResponseEntity<>(errorResponse, status);
    }

}
