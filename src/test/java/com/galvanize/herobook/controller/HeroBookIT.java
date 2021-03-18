package com.galvanize.herobook.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.herobook.model.HeroDTO;
import com.galvanize.herobook.model.PersonaDTO;
import com.galvanize.herobook.model.VillainDTO;
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

        mockmvc.perform(post("/herobook/hero")
                .content(objectMapper.writeValueAsString(heroDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        mockmvc.perform(get("/herobook/hero")).andExpect(status().isOk())
                .andExpect(jsonPath("[0].heroName").value("Batman"))
                .andExpect(jsonPath("[0].realName").value("Amir"));
    }

    @Test
    public void getHero() throws Exception {
        PersonaDTO visitorDTO=new PersonaDTO("Sunita","Visitor");
        HeroDTO heroDTO = new HeroDTO("Batman","","Amir",155,60,"FIT",
                "80","Y","80","70","30","ARTIST","COMEDY");

        mockmvc.perform(post("/herobook/hero")
                .content(objectMapper.writeValueAsString(heroDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        mockmvc.perform(post("/herobook/visitor")
                .content(objectMapper.writeValueAsString(visitorDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        mockmvc.perform(get("/herobook/hero?persona=Sunita")).andExpect(status().isOk())
                .andExpect(jsonPath("[0].heroName").value("Batman"))
                .andExpect(jsonPath("[0].realName").value("Amir"));

        mockmvc.perform(get("/herobook/hero?persona=Samik")).andExpect(status().isOk())
                .andExpect(jsonPath("length()").value("0"));

    }

    @Test
    public void postVillain() throws Exception {
        VillainDTO villainDTO = new VillainDTO("xyz","","Villain2","vv2",155,60,"FIT",
                "80","Y","80","70","30","ARTIST","COMEDY");

        mockmvc.perform(post("/herobook/villain")
                .content(objectMapper.writeValueAsString(villainDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        mockmvc.perform(get("/herobook/villain")).andExpect(status().isOk())
                .andExpect(jsonPath("[0].heroName").value("vv2"))
                .andExpect(jsonPath("[0].realName").value("Villain2"));
    }

    @Test
    public void postVisitor() throws Exception{
        PersonaDTO visitorDTO=new PersonaDTO("Sunita","Visitor");
        mockmvc.perform(post("/visitor")
                .content(objectMapper.writeValueAsString(visitorDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

    }

}
