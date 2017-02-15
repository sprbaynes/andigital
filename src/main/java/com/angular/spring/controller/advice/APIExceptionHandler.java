package com.angular.spring.controller.advice;

import com.angular.spring.util.HttpHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpStatusCodeException;

import java.io.IOException;

/**
 * Created by steven.baynes on 02/02/2016.
 */
@ControllerAdvice
public class APIExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(APIExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler({HttpStatusCodeException.class})//Client errors are 4xx Server errors are 5xx
    public ResponseEntity<String> exceptionHandler(HttpStatusCodeException exc) throws IOException {
        log.trace("In HttpClientErrorException handler");
        log.error("HttpStatusCodeException", exc);
        String responseBody = exc.getResponseBodyAsString();
        HttpStatus httpStatusCode = exc.getStatusCode();
        log.trace("exception handler status is {},  response body is: {}", httpStatusCode,responseBody);

        ResponseEntity<String> responseEntity = new ResponseEntity<String>(responseBody, HttpHelper.responseHeaders, httpStatusCode);
        return responseEntity;
    }

}
