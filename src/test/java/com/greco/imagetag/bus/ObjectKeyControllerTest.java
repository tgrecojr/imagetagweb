package com.greco.imagetag.bus;

import com.amazonaws.services.organizations.model.Account;
import com.greco.imagetag.ImagetagwebApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;


import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ImagetagwebApplication.class)
//@ComponentScan(basePackages = {"com.greco.imagetag.model","com.greco.imagetag.repo"})
@WebAppConfiguration
public class ObjectKeyControllerTest {

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;


    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();

    }

    @Test
    public void fingObjectKeysForLabel() throws Exception {

        mockMvc.perform(get("/objectkey")

                .param("label", "furniture")

        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }



}