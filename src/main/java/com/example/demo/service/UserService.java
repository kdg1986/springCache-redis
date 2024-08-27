package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.example.demo.dto.UserDTO;
import com.example.demo.mapper.UserMapper;

import lombok.extern.slf4j.Slf4j;

// @Service
@Component
@Slf4j
public class UserService {
    
    @Autowired
    private UserMapper userMapper;

    @Cacheable("my")
    public List<UserDTO> getTestUser(){
        log.info("UserService.getTestUser");
        return userMapper.selectTestUser();
    }
}
