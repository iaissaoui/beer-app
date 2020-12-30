package com.example.demo.service;

import com.example.demo.core.errors.handlers.PunkApiErrorHandler;
import com.example.demo.model.Beer;
import com.example.demo.core.interceptors.PunkHttpInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@Service
public class PunkService {

    @Value("${punkapi.default.url}")
    private String baseURL;
    @Value("${punkapi.default.perpage}")
    private String perPage;

    @Autowired
    RestTemplate restTemplate;

    public List<Beer> getBeerPage(Integer page) {

        restTemplate.setErrorHandler(new PunkApiErrorHandler());
        restTemplate.getInterceptors().add(new PunkHttpInterceptor());
        UriComponentsBuilder uriComponentsBuilder  = UriComponentsBuilder.fromHttpUrl(baseURL)
                .queryParam("page",page)
                .queryParam("per_page",perPage);

        ResponseEntity<Beer[]> result = restTemplate.getForEntity(uriComponentsBuilder.toUriString(),Beer[].class);

        return Arrays.asList(result.getBody());


    }




}
