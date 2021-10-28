package com.whouse.simple.service;

import com.whouse.simple.dto.OrderJpaDTO;
import com.whouse.simple.entity.Order;
import com.whouse.simple.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImp implements OrderService{

    private final OrderRepository repository;

    public OrderServiceImp(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Order> getAllOrderByProductId(long id) {
        return repository.findByProductId(id);
    }

    @Override
    public List<OrderJpaDTO> getOrdersById(long id) {
        return repository.getOrdersById(id);
    }


}
