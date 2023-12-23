package com.example.Cookies.service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
public class CookiesService {
    public String createOrGetCookies(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (Objects.nonNull(cookies)) {
            String cookieName = "userId";

            // Iterate through the cookies and check if the desired cookie is present
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName())) {
                    // Cookie found, you can access its value
                    String cookieValue = cookie.getValue();
                    return "Cookie Value: " + cookieValue;
                }
            }
        }
        Cookie cookie = new Cookie("userId", UUID.randomUUID().toString());
        cookie.setPath("/");
        cookie.setMaxAge(30 * 24 * 60 * 60); // 30 days in seconds, after closing the
        //browser it still works before manually deleting the cookies
        response.addCookie(cookie);
        return "Cookie Value: " + response;
    }
}
