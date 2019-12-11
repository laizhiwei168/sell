package com.cimc.controller.common;

import com.cimc.entity.Result;
import com.cimc.utils.RedisUtil;
import com.cimc.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/set")
    public Result set(String key, String value){
        redisUtil.set(key,value);
        String val= (String)redisUtil.get(key);
        redisUtil.expire(key,1000);
        long l= redisUtil.getExpire(key);
        return ResultUtil.SUCCESS(key+val+"  "+l);
    }
}
