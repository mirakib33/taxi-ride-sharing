package com.passenger.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
public class ConfigCORS implements WebMvcConfigurer {

    @Autowired
    private CorsRegistry corsRegistry;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Specify allowed paths
                .allowedOrigins("http://localhost:4200") // Replace with allowed origins
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Specify allowed methods
                .allowedHeaders("*") // Adjust allowed headers as needed
                .exposedHeaders("Authorization", "Content-Type"); // Expose specific headers if needed
    }

}
