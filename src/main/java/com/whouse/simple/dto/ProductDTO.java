package com.whouse.simple.dto;

import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class ProductDTO {
    @NotBlank
    @Min(0)
    private long id;

    @Size(min = 4, max = 200)
    private String name;

    @Size(max = 20)
    private String article;

    @NotBlank
    private String units;

    @DecimalMin("0.0")
    private double coast;
}
