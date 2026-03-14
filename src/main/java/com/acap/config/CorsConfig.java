package com.acap.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Apply this to EVERY endpoint in our app
                .allowedOriginPatterns("*") // Allow Vue to connect from any local port (5173, 5174, etc.)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // The "OPTIONS" part fixes your preflight error!
                .allowedHeaders("*")
                .allowCredentials(false);
    }
}