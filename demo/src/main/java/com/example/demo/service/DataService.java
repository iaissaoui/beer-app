package com.example.demo.service;

import com.example.demo.model.Beer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService
{

    @Autowired
    private BeerService beerService;
    @Autowired
    private PunkService punkService;

    @Async
    public List<Beer> importBeers(Integer page){
        return punkService.getBeers(page);
    }
    @Async
    public void importBeers(){

        Integer page = 1;
        List<Beer> beers;

        while(! (beers = punkService.getBeers(page)).isEmpty() ){
            beerService.saveBeers(beers);
            page++;
        }

    }



}
