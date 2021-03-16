package com.galvanize.herobook.controller;

import com.galvanize.herobook.model.HeroDTO;
import com.galvanize.herobook.service.HeroesService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HeroBookController {

//    ArrayList<HeroDTO> herobooklist;
    HeroesService heroesService;

    public HeroBookController(HeroesService heroesService){
//        herobooklist = new ArrayList<HeroDTO>();
        this.heroesService=heroesService;
    }

    @PostMapping("/herobook")
    @ResponseStatus(HttpStatus.CREATED)
    public void postHero(@RequestBody HeroDTO heroDTO){

//        herobooklist.add(heroDTO);
        heroesService.create(heroDTO);
    }

    @GetMapping("/herobook")
    @ResponseStatus(HttpStatus.OK)
    public List<HeroDTO> getHero() {

//        return herobooklist;
        return heroesService.fetchAll();
    }

}
