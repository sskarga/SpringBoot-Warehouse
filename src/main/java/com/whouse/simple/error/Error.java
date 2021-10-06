package com.whouse.simple.error;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Error {

    private final String fieldName;
    private final String message;
}
