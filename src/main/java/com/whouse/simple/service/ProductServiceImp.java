package com.whouse.simple.service;


import com.whouse.simple.entity.Product;
import com.whouse.simple.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    private ProductRepository repository;

    @Autowired
    public ProductServiceImp(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> getProductList() {
        return repository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return repository.findById(id).orElse(new Product());
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
