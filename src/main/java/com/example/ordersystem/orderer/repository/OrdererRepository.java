package com.example.ordersystem.orderer.repository;

import com.example.ordersystem.orderer.entity.Orderer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdererRepository extends JpaRepository<Orderer, Long> {
}
