package com.example.demo.service;

import com.example.demo.model.Beer;
import com.example.demo.utils.LoggingInterceptor;
import com.example.demo.utils.PunkHttpInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class PunkService {

    @Value("${punkapi.default.url}")
    private String baseURL;
    @Value("${punkapi.default.perpage}")
    private String perPage;

    @Autowired
    RestTemplate restTemplate;

    public List<Beer> getBeers(Integer page){

        restTemplate.getInterceptors().add(new PunkHttpInterceptor());
        UriComponentsBuilder uriComponentsBuilder  = UriComponentsBuilder.fromHttpUrl(baseURL)
                .queryParam("page",page)
                .queryParam("per_page",perPage);

        ResponseEntity<Beer[]> result = restTemplate.getForEntity(uriComponentsBuilder.toUriString(),Beer[].class);

        return Arrays.asList(result.getBody());


    }




}
