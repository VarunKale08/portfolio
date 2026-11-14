package com.varun.portfolio.contact;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.varun.portfolio.common.TooManyRequestsException;

@Component
public class ContactRateLimitInterceptor implements HandlerInterceptor {

    private final RateLimiter rateLimiter;

    public ContactRateLimitInterceptor(RateLimiter rateLimiter) {
        this.rateLimiter = rateLimiter;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // Only count real submissions, not the browser's CORS preflight (OPTIONS).
        if ("POST".equals(request.getMethod()) && !rateLimiter.tryAcquire(request.getRemoteAddr())) {
            throw new TooManyRequestsException("Too many messages. Please try again later.");
        }
        return true;
    }
}