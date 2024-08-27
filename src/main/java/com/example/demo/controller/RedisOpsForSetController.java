package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.OpsForSetService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RedisOpsForSetController {

    @Autowired
    private OpsForSetService opsForSetService;

    
    @RequestMapping(value="/api/opsForSet/add",method = RequestMethod.POST )
    void get(@RequestBody UserDTO user) {
        opsForSetService.opsForSetAdd(user);
    }

    @RequestMapping(value="/api/opsForSet/pop")
    void pop() {
        opsForSetService.opsForSetPop();
    }
    @RequestMapping(value="/api/opsForSet/pop/count")
    void popCount() {
        opsForSetService.opsForSetPopCount();
    }
}
