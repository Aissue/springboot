package com.aissue.springboot;

import com.aissue.springboot.utils.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

    @Autowired
    private RedisUtils redisUtils;

    @Test
    public void contextLoads() {

//        redisUtils.sSet("RESOURCES_aissue",new String[]{"/lua/a","/lua/b","/lua/c","/lua/d","/lua/e"});
        String token = "1234567890";
        redisUtils.set("TOKEN_aissue",token);
    }

}
