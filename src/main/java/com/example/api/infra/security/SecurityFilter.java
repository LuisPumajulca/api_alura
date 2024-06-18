package com.example.api.infra.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Obtener le token desde los headers
        var token = request.getHeader("Authorization");
        if (token == null || token.isBlank()) {
            throw new RuntimeException("Token no encontrado");
        }
        token = token.replace("Bearer ", "");
        System.out.println("Token: " + token);
        System.out.println("Subject: " + tokenService.getSubject(token));  // Este usuario tienee session?
        filterChain.doFilter(request, response);
    }
}
