package com.whouse.simple.controller;

import com.whouse.simple.dto.OrderDTO;
import com.whouse.simple.dto.OrderJpaDTO;
import com.whouse.simple.dto.ProductDTO;
import com.whouse.simple.entity.Order;
import com.whouse.simple.entity.Product;
import com.whouse.simple.error.NotFoundException;
import com.whouse.simple.service.OrderService;
import com.whouse.simple.service.PersonService;
import com.whouse.simple.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/products")
public class OrderController {
    private final ModelMapper modelMapper;
    private final OrderService orderService;
    private final ProductService productService;
    private final PersonService personService;

    @Autowired
    public OrderController(OrderService orderService, ProductService productService, PersonService personService) {
        this.orderService = orderService;
        this.productService = productService;
        this.personService = personService;
        this.modelMapper = new ModelMapper();
    }

    @GetMapping(value = "/{id}/orders")
    @ResponseBody
    List<OrderJpaDTO> getAllOrderBiProductId(@PathVariable("id") Long id) {
//        Optional<Product> product = productService.getProductById(id);
//        if(product.isEmpty()) new NotFoundException("Not find by id" + id.toString());
        List<OrderJpaDTO> orders = orderService.getOrdersById(id);
        return orders;
//        return orders.stream()
//                .map(this::convertToDto)
//                .collect(Collectors.toList());
    }

    private OrderDTO convertToDto(Order o) {
        return modelMapper.map(o, OrderDTO.class);
    }
}
