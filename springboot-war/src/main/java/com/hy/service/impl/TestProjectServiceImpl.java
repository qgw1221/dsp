package com.hy.service.impl;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Service;

import  com.hy.model.FieldComparisonFailure;
import com.hy.service.TestProjectService;

@Service
public class TestProjectServiceImpl implements TestProjectService {
    
    @Override
    public String compare(String expect, String actual) {
    	 
        return expect;
    }

}