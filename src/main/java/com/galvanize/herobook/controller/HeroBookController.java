package com.galvanize.herobook.controller;

import com.galvanize.herobook.model.CustomMessage;
import com.galvanize.herobook.model.HeroDTO;
import com.galvanize.herobook.model.PersonaDTO;
import com.galvanize.herobook.model.VillainDTO;
import com.galvanize.herobook.service.HeroesService;
import com.galvanize.herobook.service.PersonaService;
import com.galvanize.herobook.service.VillainsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/herobook")
public class HeroBookController {
    HeroesService heroesService;
    PersonaService personaService;
    VillainsService villainsService;


    public HeroBookController(HeroesService heroesService, PersonaService personaService, VillainsService villainService) {
        this.heroesService = heroesService;
        this.personaService = personaService;
        this.villainsService = villainService;
    }

    @PostMapping("/heroes")
    @ResponseStatus(HttpStatus.CREATED)
    public void postHero(@RequestBody HeroDTO heroDTO) {
        heroesService.create(heroDTO);
    }


    @GetMapping("/heroes")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getHero(@RequestParam(required = false) String persona) {
        if (persona == null) {
            return new ResponseEntity<>(heroesService.fetchAll(), HttpStatus.OK);
        } else {
            PersonaDTO personaDTO = personaService.fetchPersona(persona);
            if (personaDTO != null && personaDTO.getRole().equals("Visitor")) {
                return new ResponseEntity<>(heroesService.fetchAll(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new CustomMessage("User not authorized"), HttpStatus.OK);
            }
        }
    }

    @GetMapping("heroes/{name}")
    public ResponseEntity<?> getHeroByName(@PathVariable(required = false) String name) {
        HeroDTO heroDTO = heroesService.findByName(name);
        System.out.println(heroDTO);
        if (heroDTO != null) {
            return new ResponseEntity<>(heroDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new CustomMessage("Hero not found"),
                    HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/villain")
    @ResponseStatus(HttpStatus.CREATED)
    public void postVillain(@RequestBody VillainDTO villainDTO) {
        villainsService.create(villainDTO);
    }

    @GetMapping("/villains")
    @ResponseStatus(HttpStatus.OK)
    public List<VillainDTO> getVillain() {
        return villainsService.fetchAll();
    }

    @GetMapping("/villain")
    @ResponseStatus(HttpStatus.OK)
    public VillainDTO getVillain(@RequestParam String name, @RequestParam String persona) {

        PersonaDTO personaDTO = personaService.fetchPersona(persona);
        if (personaDTO != null && personaDTO.getRole().equals("Visitor")) {
            VillainDTO villainDTO = villainsService.fetchwithname(name);
            System.out.println(villainDTO);
            if (villainDTO != null) {
                return villainDTO;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }


    @PostMapping("/visitor")
    @ResponseStatus(HttpStatus.CREATED)
    public void postHero(@RequestBody PersonaDTO visitorDTO) {
        personaService.create(visitorDTO);
    }
}
