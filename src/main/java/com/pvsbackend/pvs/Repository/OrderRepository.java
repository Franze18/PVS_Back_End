package com.pvsbackend.pvs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pvsbackend.pvs.Model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
