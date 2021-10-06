package com.whouse.simple.error;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class ValidationErrorResponse {

    private Date timestamp = new Date();
    private int status;
    private String error;
    private String message;
    private List<Error> errors = new ArrayList<>();

    public ValidationErrorResponse(int status, String error) {
        this.status = status;
        this.error = error;
        this.message = error;
    }

    public ValidationErrorResponse(int status, String error, String message) {
        this.status = status;
        this.error = error;
        this.message = message;
    }
}
