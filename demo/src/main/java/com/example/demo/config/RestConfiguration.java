package com.example.demo.config;

import com.example.demo.utils.CustomRestTemplateCustomizer;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;


@Configuration
public class RestConfiguration {


    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder ){
        return restTemplateBuilder.build();
    }

    @Bean
    public CustomRestTemplateCustomizer customRestTemplateCustomizer() {
        return new CustomRestTemplateCustomizer();
    }
}
