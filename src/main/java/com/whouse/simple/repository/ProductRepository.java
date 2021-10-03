package com.whouse.simple.repository;

import com.whouse.simple.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByName(String name);
    List<Product> findByNameContains(String name);
    Product findById(long id);

    @Override
    List<Product> findAll();
}
