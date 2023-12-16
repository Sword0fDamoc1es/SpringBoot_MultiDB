package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.annotation.WR;

@Service
public class DummyService {
    // @Autowired
    // DummyRepo dummyRepo;

    @WR("w")
    public void save(Object o){
        // the above we use Object,
        // this is a mock data, to accept entity or documents.
    }

    @WR("r")
    public Object get(Object o){
        // the above we use Object,
        // this is a mock data, to accept entity or documents.     
        return null;   
    }
}
