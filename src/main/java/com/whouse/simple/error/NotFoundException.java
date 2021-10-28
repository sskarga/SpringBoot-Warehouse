package com.whouse.simple.error;

import lombok.Data;

import java.util.function.Supplier;

@Data
public class NotFoundException extends Exception {
    private final String message;
}
