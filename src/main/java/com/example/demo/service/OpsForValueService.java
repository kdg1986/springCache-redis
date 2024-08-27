package com.example.demo.service;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OpsForValueService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    
    public void opsForValueSet(String key,ObjectNode jsonNode){
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        Long existingTtl = redisTemplate.getExpire(key);
        String getData = ops.get(key);
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode existingNode = null;

        try {
            if (getData != null) {
                existingNode = (ObjectNode) mapper.readTree(getData);
            } else {
                existingNode = mapper.createObjectNode(); 
            }
        } catch (Exception e) {
            e.printStackTrace();
            existingNode = mapper.createObjectNode(); 
        }
    
        // existingNode와 jsonNode 병합
        existingNode.setAll(jsonNode);

        if(getData == null){
            ops.set(key, existingNode.toString(),Duration.ofMinutes(30));
        }else{
            ops.set(key, existingNode.toString(),Duration.ofSeconds(existingTtl));
        }

    }

    public String opsForValueGet(String key){
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        return ops.get(key);
    }
}
