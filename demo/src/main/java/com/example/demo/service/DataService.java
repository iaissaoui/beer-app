package com.example.demo.service;

import com.example.demo.model.Beer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class DataService
{

    @Autowired
    private BeerService beerService;
    @Autowired
    private PunkService punkService;

    @Async
    public void importBeers(){

        Integer page = 1;
        List<Beer> beers;



        while(! (beers = punkService.getBeerPage(page)).isEmpty() ){
            beerService.saveBeers(beers);
            page++;
        }


    }

//    @Async
//    public CompletableFuture<List<Beer>> getBeerPage(Integer page){
//        punkService.getBeerPage(page);
//
//    }



}
