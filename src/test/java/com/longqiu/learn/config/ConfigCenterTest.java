package com.longqiu.learn.config;

import org.aeonbits.owner.ConfigCache;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by QIUJ003 on 2017/12/15.
 */
public class ConfigCenterTest {
    @Test
    public void test() throws Exception{
        ConfigCenter cfg = ConfigFactory.create(ConfigCenter.class);
        System.out.println(cfg.getAuthor());

        ConfigCenter instance = ConfigCache.getOrCreate(ConfigCenter.class);
        System.out.println(instance.getTitle());

        Assert.assertEquals("long qiu", cfg.getAuthor());
        Assert.assertEquals("学习教程", instance.getTitle());
    }
}