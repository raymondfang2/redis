package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/get/{key}")
    public String getValue(@PathVariable String key) {
        System.out.println("=====>key = "+key);


       return redisTemplate.opsForValue().get(key).toString();
    }


    @GetMapping("put/{key}/{value}")
    public String putValue(@PathVariable String key, @PathVariable String value) {
        System.out.println("=====>"+key + " : "+ value);
        redisTemplate.opsForValue().set(key, value);
        return redisTemplate.opsForValue().get(key).toString();
    }

}
