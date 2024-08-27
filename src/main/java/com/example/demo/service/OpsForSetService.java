package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDTO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OpsForSetService {

    @Autowired
    @Qualifier("redisUserTemplate")
    private RedisTemplate<String,UserDTO> redisTemplate;
    
    /**
     * Set 알고리즘
     */
    public void opsForSetAdd(UserDTO user){
        SetOperations<String, UserDTO> ops = redisTemplate.opsForSet();
        ops.add("log",user);
    }

    public void opsForSetPop(){
        SetOperations<String, UserDTO> ops = redisTemplate.opsForSet();
        ops.pop("log");
    }

    public void opsForSetPopCount(){
        SetOperations<String, UserDTO> ops = redisTemplate.opsForSet();
        ops.pop("log", 2);
    }
    
}
