package com.varun.portfolio.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.varun.portfolio.contact.ContactRateLimitInterceptor;

@Configuration
public class RateLimitConfig implements WebMvcConfigurer {

    private final ContactRateLimitInterceptor interceptor;

    public RateLimitConfig(ContactRateLimitInterceptor interceptor) {
        this.interceptor = interceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor).addPathPatterns("/api/contact");
    }
}