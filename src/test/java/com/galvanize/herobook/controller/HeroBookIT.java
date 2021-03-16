package com.galvanize.herobook.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.herobook.model.HeroDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HeroBookIT
{

    @Autowired
    MockMvc mockmvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void postHero() throws Exception {
        HeroDTO heroDTO = new HeroDTO("Batman","","Amir",155,60,"FIT",
                "80","Y","80","70","30","ARTIST","COMEDY");

        mockmvc.perform(post("/herobook")
                .content(objectMapper.writeValueAsString(heroDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        mockmvc.perform(get("/herobook")).andExpect(status().isOk())
                .andExpect(jsonPath("[0].heroName").value("Batman"))
                .andExpect(jsonPath("[0].realName").value("Amir"));
    }

}