package com.whouse.simple.repository;

import com.whouse.simple.dto.OrderJpaDTO;
import com.whouse.simple.entity.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    @Query("select " +
            "new com.whouse.simple.dto.OrderJpaDTO(o.id, o.count, o.coast, o.createdAt, p.id, p.name) " +
            "from Order o JOIN Person p ON o.person.id = p.id " +
            "where o.product.id = ?1")
    List<OrderJpaDTO> getOrdersById(long id);

    List<Order> findByProductId(long id);


    List<Order> findByPersonId(long id);

    @Query("SELECT SUM(o.count) FROM Order o WHERE o.product.id = ?1")
    double countByProductId(long id);

    @Override
    List<Order> findAll();
}
