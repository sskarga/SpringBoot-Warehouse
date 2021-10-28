package com.whouse.simple.service;

import com.whouse.simple.dto.OrderJpaDTO;
import com.whouse.simple.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrderByProductId(long id);

    List<OrderJpaDTO> getOrdersById(long id);
}
