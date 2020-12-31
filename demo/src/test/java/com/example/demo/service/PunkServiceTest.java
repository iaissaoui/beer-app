package com.example.demo.service;

import com.example.demo.model.Beer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
class PunkServiceTest {

    @Autowired
    private PunkService punkService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getBeerPage_badURL() {


        Exception thrown = Assertions.assertThrows(RestClientResponseException.class,
                () -> {
                    List<Beer> beers =  punkService.getBeerPage(1);
                    }
                );
        //Assert something about the exception thrown for example

    }
}