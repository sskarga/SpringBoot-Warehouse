package com.whouse.simple.error;

import lombok.Data;

@Data
public class NotFoundException extends Exception{
    private final String message;
}
