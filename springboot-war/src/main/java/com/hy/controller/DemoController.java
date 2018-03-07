package com.hy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hy.service.TestProjectService;

@Controller
@RequestMapping("/")
public class DemoController {

    @Autowired
    private TestProjectService testProjectService;

    @RequestMapping(value = "jsonCompare", method = RequestMethod.POST)
    @ResponseBody
    public String jsonCompare(@RequestParam("expect") String expect, @RequestParam("actual") String actual, ModelMap model,
            HttpSession session,HttpServletRequest request, HttpServletResponse response) {
    	response.setContentType("application/json;charset=UTF-8");
        String list = testProjectService.compare(expect, actual);
         actual = "{\"orderNumber\": \"4955\",\"orderVersion\": \"1\"}";
         expect = "{\"orderNumber\": \"4956\",\"orderVersion\": \"1\"}";
        return expect;
    }

}