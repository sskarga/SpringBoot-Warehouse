package com.whouse.simple.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private long id;
    private String name;
    private String article;
    private String units;
    private double coast;
}
