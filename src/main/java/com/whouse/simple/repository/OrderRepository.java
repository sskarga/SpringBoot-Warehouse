package com.whouse.simple.repository;

import com.whouse.simple.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
