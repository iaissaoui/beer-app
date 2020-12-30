package com.example.demo.service;

import com.example.demo.model.ErrorLog;
import com.example.demo.repo.ErrorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ErrorLogService {

    @Autowired
    private ErrorRepository errorRepository;

    public void saveErrorLog(ErrorLog e){
            errorRepository.save(e);
    }
    public void saveException(Exception e){
            errorRepository.save(new ErrorLog(e));

    }
}
