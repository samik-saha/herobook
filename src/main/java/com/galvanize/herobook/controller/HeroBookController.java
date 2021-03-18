package com.galvanize.herobook.controller;

import com.galvanize.herobook.model.HeroDTO;
import com.galvanize.herobook.model.PersonaDTO;
import com.galvanize.herobook.model.VillainDTO;
import com.galvanize.herobook.service.HeroesService;
import com.galvanize.herobook.service.PersonaService;
import com.galvanize.herobook.service.VillainsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/herobook")
public class HeroBookController {
    HeroesService heroesService;
    PersonaService personaService;
    VillainsService villainServices;


    public HeroBookController(HeroesService heroesService, PersonaService personaService, VillainsService villainService){
        this.heroesService=heroesService;
        this.personaService = personaService;
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
        PersonaDTO personaDTO = personaService.fetchPersona(persona);
        if (personaDTO!=null && personaDTO.getRole().equals("Visitor")){
            return heroesService.fetchAll();
        }
        else{
            return new ArrayList<>();
        }
    }

    @PostMapping("/villain")
    @ResponseStatus(HttpStatus.CREATED)
    public void postVillain(@RequestBody VillainDTO villainDTO){
        villainServices.create(villainDTO);
    }

    @GetMapping("/villains")
    @ResponseStatus(HttpStatus.OK)
    public List<VillainDTO> getVillain() {
            return villainServices.fetchAll();
    }

    @GetMapping("/villain")
    @ResponseStatus(HttpStatus.OK)
    public VillainDTO getVillain(@RequestParam String name, @RequestParam String persona) {

        PersonaDTO personaDTO = personaService.fetchPersona(persona);
        if (personaDTO!=null && personaDTO.getRole().equals("Visitor")){
            VillainDTO villainDTO = villainServices.fetchwithname(name);
            System.out.println(villainDTO);
            if (villainDTO != null){
                return  villainDTO;
            }else{
                return null;
            }
        }
        else{
            return null;
        }
    }



    @PostMapping("/visitor")
    @ResponseStatus(HttpStatus.CREATED)
    public void postHero(@RequestBody PersonaDTO visitorDTO){
        personaService.create(visitorDTO);
    }
}
