package com.example.demo.config.rest;

import com.example.demo.core.interceptors.LoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


@Configuration
public class RestTemplateConfiguration {

    private final static Logger LOGGER = LoggerFactory.getLogger(LoggingInterceptor.class);

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder ){
        return restTemplateBuilder.build();
    }

    @Bean
    public RestTemplateCustomizer restTemplateCustomizer() {

        return (restTemplate -> {
            if(LOGGER.isDebugEnabled()){
                restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
                restTemplate.getInterceptors().add(new LoggingInterceptor());

            }
        });
    }
}
