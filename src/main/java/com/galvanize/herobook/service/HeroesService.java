package com.galvanize.herobook.service;

import com.galvanize.herobook.model.HeroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Service
public class HeroesService {
    private final HeroesRepository heroesRepository;

    @Autowired
    public HeroesService(HeroesRepository heroesRepository) {
        this.heroesRepository = heroesRepository;
    }

    public List<HeroDTO> fetchAll() {
        return heroesRepository.findAll()
                .stream()
                .map(heroEntity -> {
                    return new HeroDTO(heroEntity.getName());
                })
                .collect(Collectors.toList());
    }

    public HeroDTO fetchwithname(String name) {

        String name1 = name;
        return heroesRepository.findAll()
                .stream()
                .filter(heroEntity ->
                   heroEntity.getName() == name
    ).map(heroEntity -> {
                    return new HeroDTO(heroEntity.getName());
                })
                .collect(Collectors.toList()).stream().findFirst().orElse(null);



    }
}
