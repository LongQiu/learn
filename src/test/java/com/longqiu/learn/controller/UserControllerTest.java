package com.longqiu.learn.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by QIUJ003 on 2017/12/15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
    private MockMvc mvc;
    @Before
    public void setup(){
        this.mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }
    @Test
    public void contextLoads() throws Exception{
        RequestBuilder request = get("/user");
        mvc.perform(request).andExpect(status().isOk()).andExpect(content().string("hello world!"));
        request = get("/user/get/qxl");
        mvc.perform(request).andExpect(status().isOk()).andExpect(content().string("welcome,qxl"));
        request = get("/user/login").param("username","qxl").param("pwd","123456");
        mvc.perform(request).andExpect(status().isOk()).andExpect(content().string("user:qxl,password:123456"));
    }
}