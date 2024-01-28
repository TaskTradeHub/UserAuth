package com.Duhov.UserService.Exceptions;

import jdk.jshell.spi.ExecutionControl;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {UserNotFoundException.class})
    public ResponseEntity<ExceptionObject> handleUserNotFoundException(UserNotFoundException ex, WebRequest webRequest) {
        ExceptionObject exceptionObject = new ExceptionObject();

        exceptionObject.setStatusCode(HttpStatus.NOT_FOUND.value());
        exceptionObject.setMesage(exceptionObject.getMesage());
        exceptionObject.setTimestamp(new Date());

        return new ResponseEntity<ExceptionObject>(exceptionObject, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {CityNotFoundException.class})
    public ResponseEntity<ExceptionObject> handleCityNotFoundException(CityNotFoundException ex, WebRequest webRequest){
        ExceptionObject exceptionObject = new ExceptionObject();

        exceptionObject.setStatusCode(HttpStatus.NOT_FOUND.value());
        exceptionObject.setMesage(exceptionObject.getMesage());
        exceptionObject.setTimestamp(new Date());

        return new ResponseEntity<ExceptionObject>(exceptionObject, HttpStatus.NOT_FOUND);
    }
}

