package com.whouse.simple.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private long id;

    @Column(length = 200)
    @Length(min = 4, max = 200)
    @NotEmpty(message = "Введите имя")
    private String name;


    @Column(length = 20)
    private String article;

    @Column(length = 10)
    private String units;
    private double coast;

    @OneToMany(mappedBy = "product")
    private List<Order> orders;

    public Product() {
    }

    public Product(String name, String article, String units, double coast) {
        this.name = name;
        this.article = article;
        this.units = units;
        this.coast = coast;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public double getCoast() {
        return coast;
    }

    public void setCoast(double coast) {
        this.coast = coast;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
