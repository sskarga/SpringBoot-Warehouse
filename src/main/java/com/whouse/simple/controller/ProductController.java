package com.whouse.simple.controller;

import com.whouse.simple.dto.ProductDTO;
import com.whouse.simple.entity.Product;
import com.whouse.simple.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
        this.modelMapper = new ModelMapper();
    }

    @GetMapping
    @ResponseBody
    List<ProductDTO> getProduct() {
        return productService.getProductList()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

    }

    @GetMapping(value = "/{id}")
    public ProductDTO findById(@PathVariable("id") Long id) {
        return convertToDto(productService.getProductById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ProductDTO productDTO) {
        productService.creatProduct(convertToEntity(productDTO));
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable( "id" ) Long id, @RequestBody ProductDTO productDTO) {
        if (productService.getProductById(id) != null) {
            productService.updateProduct(convertToEntity(productDTO));
        }
    }

    @DeleteMapping(value = "/{id}")
    //@ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            productService.deleteProduct(product);
            new ResponseEntity<String>(HttpStatus.OK);
        }
        else {
            new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }

    private ProductDTO convertToDto(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }

    private Product convertToEntity(ProductDTO productDTO) {
        return modelMapper.map(productDTO, Product.class);
    }
}
