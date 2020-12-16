package com.example.demo.service;

import com.example.demo.model.Beer;
import com.example.demo.repo.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeerService {

    @Autowired
    private BeerRepository beerRepository;

    public Beer saveBeer(Beer b){
        return beerRepository.save(b);
    }


}
