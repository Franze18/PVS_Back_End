package com.pvsbackend.pvs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pvsbackend.pvs.Model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
