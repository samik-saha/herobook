package com.galvanize.herobook.controller;

import com.galvanize.herobook.model.HeroDTO;
import com.galvanize.herobook.service.HeroesService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HeroBookController {
    HeroesService heroesService;

    public HeroBookController(HeroesService heroesService){
        this.heroesService=heroesService;
    }

    @PostMapping("/herobook")
    @ResponseStatus(HttpStatus.CREATED)
    public void postHero(@RequestBody HeroDTO heroDTO){
        heroesService.create(heroDTO);
    }

    @GetMapping("/herobook")
    @ResponseStatus(HttpStatus.OK)
    public List<HeroDTO> getHero() {

        return heroesService.fetchAll();
    }
}
