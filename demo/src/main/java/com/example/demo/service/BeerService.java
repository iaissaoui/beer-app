package com.example.demo.service;

import com.example.demo.model.Beer;
import com.example.demo.repo.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
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

    public Beer getBeer(Long id) {
        return beerRepository.findById(id).get();
    }

    public List<Beer> getAllBeers()  {
        return beerRepository.findAll();
    }


    public Beer getRandomBeer() {
        SecureRandom sr = new SecureRandom();
        Long randomId =  sr.longs(1,1,beerRepository.count()).findFirst().getAsLong();

        return beerRepository.findById(randomId).get();
    }
}
