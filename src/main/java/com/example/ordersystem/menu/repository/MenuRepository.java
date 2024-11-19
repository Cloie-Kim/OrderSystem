package com.example.ordersystem.menu.repository;

import com.example.ordersystem.menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
