package com.example.demo;

import com.example.demo.model.Beer;
import com.example.demo.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.demo.repo")
public class DemoApplication implements CommandLineRunner {
	@Value("${punkapi.baseurl.all}")
	private String punkApiAll;

	@Value("${punkapi.baseurl}")
	private String punkApiBase;

	@Autowired
	private BeerService beerService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		RestTemplate rt = new RestTemplate();
		HttpHeaders hh = new HttpHeaders();
		hh.setContentType(MediaType.APPLICATION_JSON);
		hh.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		hh.add(HttpHeaders.USER_AGENT, "demo/1.0");


		ResponseEntity<Beer[]> result = rt.exchange(punkApiAll, HttpMethod.GET,new HttpEntity<Object>(hh), Beer[].class);


		Arrays.asList(result.getBody()).forEach(
				beer -> {
					System.out.println(beer);
					beerService.saveBeer(beer);
				}

		);

	}





}
