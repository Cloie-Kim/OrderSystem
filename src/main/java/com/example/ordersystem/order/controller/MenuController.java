package com.example.ordersystem.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

    @GetMapping("/menu")
    public String show() {
        return "menu";
    }
}