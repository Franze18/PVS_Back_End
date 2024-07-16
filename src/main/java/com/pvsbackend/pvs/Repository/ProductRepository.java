package com.pvsbackend.pvs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pvsbackend.pvs.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}