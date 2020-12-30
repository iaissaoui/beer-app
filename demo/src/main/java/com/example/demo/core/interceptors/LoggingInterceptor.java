package com.example.demo.core.interceptors;

import com.example.demo.core.utils.JSONUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class LoggingInterceptor implements ClientHttpRequestInterceptor {

    private final static Logger LOGGER = LoggerFactory.getLogger(LoggingInterceptor.class);

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] requestBody, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        LOGGER.debug("Request body: {}", new String(requestBody, StandardCharsets.UTF_8));

        ClientHttpResponse response = clientHttpRequestExecution.execute(httpRequest, requestBody);
        InputStreamReader isr = new InputStreamReader(
                response.getBody(), StandardCharsets.UTF_8);

        String body = new BufferedReader(isr).lines()
                .collect(Collectors.joining("\n"));

        if(JSONUtils.isValidJsonString(body)){
            body = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(body);
        }

        LOGGER.debug("Response body: {}", body);

        return response;
    }
}
