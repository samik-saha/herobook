package com.galvanize.herobook.service;

import com.galvanize.herobook.model.HeroDTO;
import com.galvanize.herobook.model.HeroEntity;
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
                    return new HeroDTO(heroEntity.getHeroName(), heroEntity.getImagePath(), heroEntity.getRealName(),
                            heroEntity.getHeight(), heroEntity.getWeight(), heroEntity.getSpecialPower(), heroEntity.getIntelligence(),
                            heroEntity.getStrength(), heroEntity.getPower(), heroEntity.getSpeed(), heroEntity.getAgility(),
                            heroEntity.getDescription(), heroEntity.getStory());
                })
                .collect(Collectors.toList());
    }

    public HeroDTO findByName(String name) {
        return heroesRepository.findAll()
                .stream()
                .filter(heroEntity ->
                        heroEntity.getHeroName().equals(name)
                ).map(heroEntity -> {
                    return new HeroDTO(heroEntity.getHeroName(), heroEntity.getImagePath(), heroEntity.getRealName(),
                            heroEntity.getHeight(), heroEntity.getWeight(), heroEntity.getSpecialPower(), heroEntity.getIntelligence(),
                            heroEntity.getStrength(), heroEntity.getPower(), heroEntity.getSpeed(), heroEntity.getAgility(),
                            heroEntity.getDescription(), heroEntity.getStory()
                    );
                })
                .collect(Collectors.toList()).stream().findFirst().orElse(null);
    }

    public void create(HeroDTO heroDTO) {
        heroesRepository.save(
                new HeroEntity(heroDTO.getHeroName(), heroDTO.getImagePath(), heroDTO.getRealName(),
                        heroDTO.getHeight(), heroDTO.getWeight(), heroDTO.getSpecialPower(), heroDTO.getIntelligence(),
                        heroDTO.getStrength(), heroDTO.getPower(), heroDTO.getSpeed(), heroDTO.getAgility(),
                        heroDTO.getDescription(), heroDTO.getStory())
        );
    }
}
