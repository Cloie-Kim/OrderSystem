package com.example.ordersystem.menu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class menuController {
    @GetMapping("/menu")
    public String menuPage() {
        return "menu";
    }
}
