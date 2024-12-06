package com.example.ordersystem.page.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

    @GetMapping("/signupSuccess")
    public String signupSuccessPage() {
        return "signupSuccess";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/loginSuccess")
    public String loginSuccessPage() {
        return "loginSuccess";
    }

    @GetMapping("/mypage")
    public String mypage() {
        return "myPage";
    }

}
