package com.example.demo.api;

import com.example.demo.model.Beer;
import com.example.demo.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BeersAPI {

    private final String URL = "https://api.punkapi.com/v2/beers";
    private final String URL_TEST = "https://httpbin.org/ip";

    @Autowired
    private BeerService beerService;


    @GetMapping("/test")
    public String test(){
        RestTemplate rt = new RestTemplate();
        HttpHeaders hh = new HttpHeaders();
        hh.setContentType(MediaType.APPLICATION_JSON);
        hh.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        hh.add(HttpHeaders.USER_AGENT, "demo/1.0");

        ResponseEntity<String> result = rt.exchange(URL, HttpMethod.GET,new HttpEntity<Object>(hh),String.class);

        System.out.println(result.getBody());

        return result.getBody();
    }

    @GetMapping("/allold")
    public Beer[] getAllOld(){
        RestTemplate rt = new RestTemplate();
        HttpHeaders hh = new HttpHeaders();
        hh.setContentType(MediaType.APPLICATION_JSON);
        hh.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        hh.add(HttpHeaders.USER_AGENT, "demo/1.0");


        ResponseEntity<Beer[]> result = rt.exchange(URL, HttpMethod.GET,new HttpEntity<Object>(hh), Beer[].class);

        new ArrayList<>(Arrays.asList(result.getBody())).forEach(System.out::println);

        return result.getBody();
    }

    @GetMapping("/all")
    public List<Beer> getAll() throws Exception {

        return beerService.getAllBeers();
    }

    @GetMapping("/{id:^[0-9]{1,3}$}")
    public Beer getSingle(@PathVariable Long id) throws Exception {

        return beerService.getBeer(id);
    }

    @GetMapping("/random")
    public Beer getRandom() throws Exception {

        return beerService.getRandomBeer();
    }


}
