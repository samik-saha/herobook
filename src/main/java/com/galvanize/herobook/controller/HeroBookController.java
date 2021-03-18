package com.galvanize.herobook.controller;

import com.galvanize.herobook.model.HeroDTO;
import com.galvanize.herobook.model.PersonaDTO;
import com.galvanize.herobook.model.VillainDTO;
import com.galvanize.herobook.service.HeroesService;
import com.galvanize.herobook.service.PersonaService;
import com.galvanize.herobook.service.VillainsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/herobook")
public class HeroBookController {
    HeroesService heroesService;
    PersonaService visitorService;
    VillainsService villainServices;


    public HeroBookController(HeroesService heroesService, PersonaService visitorService,VillainsService villainService){
        this.heroesService=heroesService;
        this.visitorService=visitorService;
        this.villainServices=villainService;
    }

    @PostMapping("/hero")
    @ResponseStatus(HttpStatus.CREATED)
    public void postHero(@RequestBody HeroDTO heroDTO){
        heroesService.create(heroDTO);
    }

//    @GetMapping("/hero")
//    @ResponseStatus(HttpStatus.OK)
//    public List<HeroDTO> getHero() {
//
//        return heroesService.fetchAll();
//    }

    @GetMapping("/hero")
    @ResponseStatus(HttpStatus.OK)
    public List<HeroDTO> getHero(@RequestParam String persona) {



        return heroesService.fetchAll();
    }

    @PostMapping("/villain")
    @ResponseStatus(HttpStatus.CREATED)
    public void postVillain(@RequestBody VillainDTO villainDTO){
        villainServices.create(villainDTO);
    }

    @GetMapping("/villain")
    @ResponseStatus(HttpStatus.OK)
    public List<VillainDTO> getVillain() {

        return villainServices.fetchAll();
    }



    @PostMapping("/visitor")
    @ResponseStatus(HttpStatus.CREATED)
    public void postHero(@RequestBody PersonaDTO visitorDTO){
        visitorService.create(visitorDTO);
    }
}
