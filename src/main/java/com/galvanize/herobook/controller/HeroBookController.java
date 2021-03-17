package com.galvanize.herobook.controller;

import com.galvanize.herobook.model.HeroDTO;
import com.galvanize.herobook.model.VisitorDTO;
import com.galvanize.herobook.service.HeroesService;
import com.galvanize.herobook.service.VisitorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HeroBookController {
    HeroesService heroesService;
    VisitorService visitorService;

    public HeroBookController(HeroesService heroesService, VisitorService visitorService){
        this.heroesService=heroesService;
        this.visitorService=visitorService;
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

    @PostMapping("/visitor")
    @ResponseStatus(HttpStatus.CREATED)
    public void postHero(@RequestBody VisitorDTO visitorDTO){
        visitorService.create(visitorDTO);
    }
}
