package com.whouse.simple.repository;

import com.whouse.simple.entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    List<Product> findByNameContainsIgnoreCase(String name);
    Optional<Product> findById(long id);

    @Override
    List<Product> findAll();
}
