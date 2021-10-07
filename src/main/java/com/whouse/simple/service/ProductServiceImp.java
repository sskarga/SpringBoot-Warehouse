package com.whouse.simple.service;


import com.whouse.simple.entity.Product;
import com.whouse.simple.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductServiceImp(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> getProductList() {
        return repository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Product> getProductByName(String name) {
        return repository.findByNameContainsIgnoreCase(name);
    }

    @Override
    public Product creatProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public void deleteProduct(Product product) {
        repository.delete(product);
    }
}
