package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DynamicDataSource;
import com.example.demo.DynamicDataSource2;
import com.example.demo.service.DummyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class DummyController {
    // 1. dynamic self-define datasource
    @Autowired
    private DummyService dummyService;
    @GetMapping("/select")
    public Object select() {
        // DynamicDataSource.currentDataSource.set("r");
        DynamicDataSource2.currentDataSource.set("r");
        return dummyService.get(null);
    }
    @GetMapping("/insert")
    public void ins(@RequestParam String param) {
        // DynamicDataSource.currentDataSource.set("w");
        DynamicDataSource2.currentDataSource.set("w");
        dummyService.save(param);
        return;
    }
    
    
}
