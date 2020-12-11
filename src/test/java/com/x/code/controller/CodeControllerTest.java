package com.x.code.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
class CodeControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;

    @BeforeEach
    public void setUp(){
        this.mvc = MockMvcBuilders.webAppContextSetup(wac).build(); //初始化MockMvc对象
    }

    /**
     * 正常获取
     * @throws Exception
     */
    @Test
    void detailOk() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/code/detail")
                .param("id","1"))   //传入一个正常的id
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.success").value(true))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(200))
                .andDo(MockMvcResultHandlers.print());
    }

    /**
     * 请求一个被软删除的数据
     * @throws Exception
     */
    @Test
    void detailIsDel() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/code/detail")
                .param("id","2"))   //传入一个被软删除的id
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.success").value(false))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(400))
                .andDo(MockMvcResultHandlers.print());
    }

    /**
     * 请求一个不存在的数据
     * @throws Exception
     */
    @Test
    void detailNotExist() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/code/detail")
                .param("id","3"))   //传入一个不存在的id
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.success").value(false))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(400))
                .andDo(MockMvcResultHandlers.print());
    }

}