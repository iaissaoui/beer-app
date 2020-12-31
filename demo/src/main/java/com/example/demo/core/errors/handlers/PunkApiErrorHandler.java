package com.example.demo.core.errors.handlers;


import com.example.demo.service.ErrorLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestClientResponseException;

import java.io.IOException;

@Component
public class PunkApiErrorHandler extends DefaultResponseErrorHandler {

    @Autowired
    private ErrorLogService errorService;

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        try{
            super.handleError(response);
        }catch (RestClientResponseException e){
            errorService.saveException(e);
            throw e;
        }

    }
}
