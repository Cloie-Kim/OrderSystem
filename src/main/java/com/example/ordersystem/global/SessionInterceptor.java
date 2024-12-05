package com.example.ordersystem.global;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;


public class SessionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);

        String[] publicAvailablePaths = {"/home", "/login", "/signup", "/signupSuccess", "/loginSuccess"};
        String requestURI = request.getRequestURI();

        for (String path : publicAvailablePaths) {
            if (requestURI.startsWith(path)) {
                return true;
            }
        }

        if (session == null || session.getAttribute("loggedInUser") == null) {
            response.sendRedirect("/login");
            return false;
        }

        return true;
    }
}
