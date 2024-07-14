package com.example.prueba.service;


import com.example.prueba.dto.EmailValidationResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

@Service
public class EmailValidationService {

    @Value("${emailvalidation.api.url}")
    private String apiUrl;

    public EmailValidationResponse validateEmail(String email) {
        RestTemplate restTemplate = new RestTemplate();
        String url = apiUrl + "&email=" + email;
        return restTemplate.getForObject(url, EmailValidationResponse.class);
    }
}
