package com.crudOperaions.demo;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.lang.ref.Cleaner;
import java.util.Objects;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = DemoApplication.class)
@ExtendWith(SpringExtension.class)
public class ClientTest {
    @Autowired
    WebApplicationContext webApplicationContext;
    private MockMvc mvc;

    @BeforeEach
    public void setUp() {
        System.out.println(mvc);
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testClientController() throws Exception {
        Client c = new Client();
        c.setName("khalil");
        c.setAge(22);
        mvc.perform(post("/client").contentType(MediaType.APPLICATION_JSON).content(Objects.requireNonNull(toJSON(c)))).andExpect(status().isOk());
        mvc.perform(get("/client/1",1)).andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
        //mvc.perform(delete("/client/1")).andExpect(status().isOk());
        c.setName("Arbi");
        mvc.perform(patch("/client/1").contentType(MediaType.APPLICATION_JSON).content(Objects.requireNonNull(toJSON(c)))).andExpect(status().isOk());
    }
    private String toJSON(Object object) {
        try {
            String s = new ObjectMapper().writeValueAsString(object);
            System.out.println("this is " +  s);
            return s;
        } catch (JsonProcessingException e) {
            return null;

        }
    }
}
