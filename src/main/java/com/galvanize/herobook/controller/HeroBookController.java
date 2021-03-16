package com.galvanize.herobook.controller;

import com.galvanize.herobook.model.HeroDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class HeroBookController {

    ArrayList<HeroDTO> herobooklist;

    public HeroBookController(){
        herobooklist = new ArrayList<HeroDTO>();
    }

    @PostMapping("/herobook")
    @ResponseStatus(HttpStatus.CREATED)
    public void postHero(@RequestBody HeroDTO heroDTO){
        herobooklist.add(heroDTO);
    }

    @GetMapping("/herobook")
    @ResponseStatus(HttpStatus.OK)
    public ArrayList<HeroDTO> getHero() {
        return herobooklist;
    }

}
