package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.OpsForValueService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RedisOpsForValueController {

    @Autowired
    private OpsForValueService opsForValueService;

    
    @RequestMapping(value="/api/opsForValue/set/{key}",method = RequestMethod.POST)
    void set(@PathVariable(required = true) String key, @RequestBody HashMap<String,Object> map) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode jsonNode = mapper.valueToTree(map);
        opsForValueService.opsForValueSet(key,jsonNode);
    }

    @RequestMapping(value="/api/opsForValue/get/{key}")
    String get(@PathVariable(required = true) String key) {
        return opsForValueService.opsForValueGet(key);
    }

}
