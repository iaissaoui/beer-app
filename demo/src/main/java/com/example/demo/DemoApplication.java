package com.example.demo;

import com.example.demo.model.Beer;
import com.example.demo.service.BeerService;
import com.example.demo.service.DataService;
import com.example.demo.service.PunkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.demo.repo")
@EnableAsync
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private DataService dataService;


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		dataService.importBeers();
	}






}
