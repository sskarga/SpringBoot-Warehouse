package com.whouse.simple.dto;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class RequestPersonDTO {
    @Size(min = 4, max = 200)
    private String name;
}
