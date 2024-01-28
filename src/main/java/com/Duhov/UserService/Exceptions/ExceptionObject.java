package com.Duhov.UserService.Exceptions;

import lombok.Data;

import java.util.Date;

@Data
public class ExceptionObject {
    private int statusCode;
    private String mesage;
    private Date timestamp;

}
