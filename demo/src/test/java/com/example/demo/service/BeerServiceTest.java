package com.example.demo.service;

import com.example.demo.model.Beer;
import com.example.demo.repo.BeerRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;


@ExtendWith(MockitoExtension.class)
class BeerServiceTest {

    @InjectMocks
    BeerService beerService;

    @Mock
    BeerRepository beerRepository;

    @BeforeAll
    public static void init() {

    }

    @BeforeEach
    void setUp() {
        Mockito.lenient().when(beerRepository.save(Mockito.any(Beer.class))).then(AdditionalAnswers.returnsFirstArg());
        Mockito.lenient().when(beerRepository.saveAll(Mockito.anyList())).then(AdditionalAnswers.returnsFirstArg());
    }

    @Test
    void saveBeer() {
        Beer beerArg = new Beer();
        beerArg.setId(1L);
        Beer beerReturn = beerService.saveBeer(beerArg);
        Assertions.assertEquals(beerReturn, beerArg);
    }

    @Test
    void saveBeers() {
        Beer beerArg = new Beer();
        beerArg.setId(1L);
        List<Beer> listBeers = Arrays.asList(beerArg);
        List<Beer> beerReturn = beerService.saveBeers(listBeers);
        Assertions.assertEquals(beerReturn, listBeers);
    }

    @Test
    void getBeer() {
    }

    @Test
    void getAllBeers() {
    }
}