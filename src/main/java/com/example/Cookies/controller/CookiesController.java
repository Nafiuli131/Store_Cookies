package com.example.Cookies.controller;

import com.example.Cookies.service.CookiesService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Objects;
import java.util.UUID;

@RestController
public class CookiesController {

    @Autowired
    CookiesService cookiesService;
    @GetMapping("")
    public String createOrGetCookies(HttpServletRequest request, HttpServletResponse response) {
       return cookiesService.createOrGetCookies(request,response);
    }
}
