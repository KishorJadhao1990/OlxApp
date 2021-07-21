package com.zensar.util;

import com.zensar.exception.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class ErrorUtil {

    @Autowired
    private MessageSource messageSource;

    public ErrorResponse buildErrorResponseEntity(HttpStatus status){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(status.value());
        errorResponse.setTimestamp(DateUtil.currentDateTime());
        return errorResponse;
    }

    public ErrorResponse buildErrorResponseEntity(String errorCode, HttpStatus status){
        String message = messageSource.getMessage(errorCode,null, Locale.US);
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(status.value());
        errorResponse.setErrorCode(errorCode);
        errorResponse.setErrorMessage(message);
        errorResponse.setTimestamp(DateUtil.currentDateTime());
        return errorResponse;
    }

    public ErrorResponse buildErrorResponseEntity(String errorCode, HttpStatus status, Locale locale) {
        String message = messageSource.getMessage(errorCode, null, locale);
        ErrorResponse errorResponse = buildErrorResponseEntity(errorCode, status);
        errorResponse.setErrorMessage(message);
        return errorResponse;
    }

}
