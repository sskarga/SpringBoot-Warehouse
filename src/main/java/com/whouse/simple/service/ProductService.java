package com.whouse.simple.service;

import com.whouse.simple.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProductList();
    Product getProductById(Long id);

    Product creatProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(Product product);
}
