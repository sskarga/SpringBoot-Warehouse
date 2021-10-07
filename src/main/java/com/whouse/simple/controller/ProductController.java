package com.whouse.simple.controller;

import com.whouse.simple.dto.CreateProductDTO;
import com.whouse.simple.dto.ProductDTO;
import com.whouse.simple.entity.Product;
import com.whouse.simple.error.NotFoundException;
import com.whouse.simple.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;
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

    @GetMapping(value = "/search")
    @ResponseBody
    List<ProductDTO> getProductByName(@RequestParam(name="name") String searchByName) {
        return productService.getProductByName(searchByName)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

    }

    @GetMapping(value = "/{id}")
    public ProductDTO findById(@PathVariable("id") @Min(0) Long id) throws NotFoundException {
        return convertToDto(getProduct(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody CreateProductDTO productDTO) {
        productService.creatProduct(convertToEntity(productDTO));
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable( "id" ) @Min(0) Long id, @RequestBody @Valid ProductDTO productDTO) throws NotFoundException {
        getProduct(id);
        productService.updateProduct(convertToEntity(productDTO));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") @Min(0) Long id) throws NotFoundException {
        productService.deleteProduct(getProduct(id));
    }

    private Product getProduct(@PathVariable("id") @Min(0) Long id) throws NotFoundException {
        Optional<Product> product = productService.getProductById(id);
        if (product.isEmpty()) throw new NotFoundException("Not find by id" + id.toString());
        return product.get();
    }

    private ProductDTO convertToDto(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }

    private Product convertToEntity(ProductDTO productDTO) {
        return modelMapper.map(productDTO, Product.class);
    }

    private Product convertToEntity(CreateProductDTO productDTO) {
        return modelMapper.map(productDTO, Product.class);
    }
}
