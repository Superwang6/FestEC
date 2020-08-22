package com.yuan.fest.test;

import com.yuan.fest.controller.BookController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("pro")
public class TestMVC {

    @Autowired
    private BookController bookController;
    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void before(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @After
    public void after(){
        System.out.println("============结束============");
    }

    @Test
    public void test1() throws Exception{
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/book/test")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name","wow") )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }


}
