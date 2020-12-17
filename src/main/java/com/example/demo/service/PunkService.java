package com.example.demo.service;

import com.example.demo.model.Beer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
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


    public List<Beer> getBeers(Integer page){

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        httpHeaders.add(HttpHeaders.USER_AGENT, "demo/1.0");

        UriComponentsBuilder uriComponentsBuilder  = UriComponentsBuilder.fromHttpUrl(baseURL)
                .queryParam("page",page)
                .queryParam("per_page",perPage);

        ResponseEntity<Beer[]> result = restTemplate.exchange(uriComponentsBuilder.toUriString(), HttpMethod.GET,new HttpEntity<>(httpHeaders), Beer[].class);

        return Arrays.asList(result.getBody());


    }




}
