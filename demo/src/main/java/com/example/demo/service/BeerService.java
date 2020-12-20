package com.example.demo.service;

import com.example.demo.model.Beer;
import com.example.demo.repo.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeerService {

    @Autowired
    private BeerRepository beerRepository;

    public Beer saveBeer(Beer beer){
        return beerRepository.save(beer);
    }

    public List<Beer> saveBeers(List<Beer> beers){
        return beerRepository.saveAll(beers);
    }

    public Beer getBeer(Beer b) throws Exception {
        Beer returnedBeer = beerRepository.findById(b.getId()).orElseThrow((() -> new Exception("Bad Beer ID")));

        return returnedBeer;
    }

    public List<Beer> getAllBeers() throws Exception {
        return beerRepository.findAll();
    }



}
