package com.longqiu.learn.component;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by QIUJ003 on 2017/12/25.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisComponentTest {
    @Autowired
    private RedisComponent redisComponent;

    @Test
    public void set() {
        redisComponent.set("longqiu.test", "hello world");
    }

    @Test
    public void get() {
        System.out.println(redisComponent.get("longqiu.test"));
    }

    @Test
    public void del() {
        redisComponent.del("longqiu.test");
    }
}