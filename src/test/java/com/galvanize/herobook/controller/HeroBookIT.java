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
import org.springframework.test.annotation.DirtiesContext;
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
        HeroDTO heroDTO = new HeroDTO("Batman","","Bruce Wayne",155,60,
                "fly","80","Y","80","70","30","abc","xyz");

        mockmvc.perform(post("/herobook/heroes")
                .content(objectMapper.writeValueAsString(heroDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        mockmvc.perform(get("/herobook/heroes")).andExpect(status().isOk())
                .andExpect(jsonPath("[0].heroName").value("Batman"))
                .andExpect(jsonPath("[0].realName").value("Bruce Wayne"));
    }

    @Test
    @DirtiesContext
    public void getHero() throws Exception {
        PersonaDTO visitorDTO=new PersonaDTO("Sunita","Visitor");
        HeroDTO heroDTO = new HeroDTO("Batman","","Bruce",155,60,
                "tech","80","Y","80","70","30","abc","xyz");

        mockmvc.perform(post("/herobook/heroes")
                .content(objectMapper.writeValueAsString(heroDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        mockmvc.perform(post("/herobook/visitor")
                .content(objectMapper.writeValueAsString(visitorDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        mockmvc.perform(get("/herobook/heroes?persona=Sunita")).andExpect(status().isOk())
                .andExpect(jsonPath("[0].heroName")
                        .value("Batman"))
                .andExpect(jsonPath("[0].realName")
                        .value("Bruce"));

        mockmvc.perform(get("/herobook/heroes?persona=Samik"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message")
                        .value("User not authorized"));

    }

    @Test
    @DirtiesContext
    public void getAllHeros() throws Exception{
        HeroDTO heroDTO1=new HeroDTO("Superman", "Clark Kent");
        HeroDTO heroDTO2 = new HeroDTO("Batman", "Bruce Wayne");

        mockmvc.perform(post("/herobook/heroes")
        .content(objectMapper.writeValueAsString(heroDTO1))
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        mockmvc.perform(post("/herobook/heroes")
                .content(objectMapper.writeValueAsString(heroDTO2))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        mockmvc.perform(get("/herobook/heroes"))
                .andExpect(jsonPath("$.length()").value(2));

    }

    @Test
    @DirtiesContext
    public void getHeroByName() throws Exception{
        HeroDTO heroDTO = new HeroDTO("Hulk","","Max Ferguson",155,60,"",
                "80","Y","80","70","30","","");

        mockmvc.perform(post("/herobook/heroes")
                .content(objectMapper.writeValueAsString(heroDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        mockmvc.perform(get("/herobook/heroes/Antman"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Hero not found"));

        mockmvc.perform(get("/herobook/heroes/Hulk"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.realName").value("Max Ferguson"));
    }

    @Test
    public void postVillain() throws Exception {
        VillainDTO villainDTO = new VillainDTO("xyz","","Villain2","vv2",155,60,"FIT",
                "80","Y","80","70","30","ARTIST","COMEDY");

        mockmvc.perform(post("/herobook/villain")
                .content(objectMapper.writeValueAsString(villainDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        mockmvc.perform(get("/herobook/villains")).andExpect(status().isOk())
                .andExpect(jsonPath("[0].heroName").value("vv2"))
                .andExpect(jsonPath("[0].realName").value("Villain2"));
    }

    @Test
    public void getVillainByName() throws Exception {
        PersonaDTO visitorDTO=new PersonaDTO("Sunita","Visitor");

        VillainDTO villainDTO = new VillainDTO("xyz","","Villain2","vv2",155,60,"FIT",
                "80","Y","80","70","30","ARTIST","COMEDY");

        mockmvc.perform(post("/herobook/villain")
                .content(objectMapper.writeValueAsString(villainDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        mockmvc.perform(post("/herobook/visitor")
                .content(objectMapper.writeValueAsString(visitorDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        mockmvc.perform(get("/herobook/villain?name=vv2&persona=Sunita")).andExpect(status().isOk())
                .andExpect(jsonPath("$.heroName").value("vv2"))
                .andExpect(jsonPath("$.realName").value("Villain2"));

//        mockmvc.perform(get("/herobook/villain?name=vv3&persona=Sunita")).andExpect(status().isOk())
//                .andExpect(jsonPath("$.error").value("Villain does not exist"));

    }

    @Test
    public void postVisitor() throws Exception{
        PersonaDTO visitorDTO=new PersonaDTO("Sunita","Visitor");
        mockmvc.perform(post("/herobook/visitor")
                .content(objectMapper.writeValueAsString(visitorDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

    }

}
