package com.whouse.simple.service;

import com.whouse.simple.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getProductList();
    Optional<Product> getProductById(Long id);
    List<Product> getProductByName(String name);

    Product creatProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(Product product);
}
