package com.whouse.simple.dto;

import lombok.Data;

import java.util.Date;

public class OrderJpaDTO {
    private long id;
    private int count;
    private double coast;
    private Date createdAt;
    private long personId;
    private String personName;

    public OrderJpaDTO() {
    }

    public OrderJpaDTO(long id, int count, double coast, Date createdAt, long personId, String personName) {
        this.id = id;
        this.count = count;
        this.coast = coast;
        this.createdAt = createdAt;
        this.personId = personId;
        this.personName = personName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getCoast() {
        return coast;
    }

    public void setCoast(double coast) {
        this.coast = coast;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @Override
    public String toString() {
        return "OrderJpaDTO{" +
                "id=" + id +
                ", count=" + count +
                ", coast=" + coast +
                ", createdAt=" + createdAt +
                ", personId=" + personId +
                '}';
    }
}
