package com.hy.controller;
 
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hy.service.StudentService;
 
@RestController
@RequestMapping("/stu")
public class StudentController {
 
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
 
    @Autowired
    private StudentService studentService;
 
    @RequestMapping("/list")
    public List getStus(){
        logger.info("从数据库读取Student集合");
        return studentService.getList();
    }
}