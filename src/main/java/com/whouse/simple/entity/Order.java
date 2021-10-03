package com.whouse.simple.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue
    private long id;

    private int count;
    private double coast;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt  = new Date();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    public Order() {
    }

    public Order(int count, double coast, Product product, Person person) {
        this.count = count;
        this.coast = coast;
        this.product = product;
        this.person = person;
    }

    public long getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Order{" +
                "count=" + count +
                ", coast=" + coast +
                ", createdAt=" + createdAt +
                '}';
    }

}
