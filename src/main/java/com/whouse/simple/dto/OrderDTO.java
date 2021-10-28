package com.whouse.simple.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OrderDTO {
    private long id;
    private int count;
    private double coast;
    private Date createdAt;
    private long productId;
    private long personId;
}
