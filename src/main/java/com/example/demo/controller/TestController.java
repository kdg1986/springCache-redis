package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.component.Student;
import com.example.demo.component.StudentImpl2;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TestController {
    
    @Autowired
    private ArrayList<String> array;

    @Autowired
    // @Qualifier("hello-1")
    Student studentImpl;

    @Autowired
    @Qualifier("hello-2")
    StudentImpl2 sdt2;

    @Autowired
    private UserService userService;

    @RequestMapping("/api/test")
    List<UserDTO> test(HttpServletRequest req) {
        return userService.getTestUser();
    }
 
}
