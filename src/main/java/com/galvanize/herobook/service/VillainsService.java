package com.galvanize.herobook.service;

import com.galvanize.herobook.model.VillainDTO;
import com.galvanize.herobook.model.VillainEntity;
import com.galvanize.herobook.service.VillainsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class VillainsService {
    private final VillainsRepository villainsRepository;

    @Autowired
    public VillainsService(VillainsRepository villainsRepository) {
        this.villainsRepository = villainsRepository;
    }

    public List<VillainDTO> fetchAll() {
        return villainsRepository.findAll()
                .stream()
                .map(villainEntity -> {
                    return new VillainDTO(villainEntity.getArchRival(), villainEntity.getImagePath(),villainEntity.getRealName(),villainEntity.getHeroName(),
                            villainEntity.getHeight(), villainEntity.getWeight(), villainEntity.getSpecialPower(), villainEntity.getIntelligence(),
                            villainEntity.getStrength(), villainEntity.getPower(), villainEntity.getSpeed(), villainEntity.getAgility(),
                            villainEntity.getDescription(), villainEntity.getStory());
                })
                .collect(Collectors.toList());
    }

    //String villainName,String imagePath,String realName,float height,float weight,String specialPower,
    //  // String intelligence,String strength,String power,String speed,String agility,
    //  String description,String story

    public VillainDTO fetchwithname(String name) {

        String name1 = name;
        return villainsRepository.findAll()
                .stream()
                .filter(villainEntity ->
                        villainEntity.getHeroName() == name
                ).map(villainEntity -> {
                    return new VillainDTO(villainEntity.getArchRival(), villainEntity.getImagePath(),villainEntity.getRealName(),villainEntity.getHeroName(),
                            villainEntity.getHeight(), villainEntity.getWeight(), villainEntity.getSpecialPower(), villainEntity.getIntelligence(),
                            villainEntity.getStrength(), villainEntity.getPower(), villainEntity.getSpeed(), villainEntity.getAgility(),
                            villainEntity.getDescription(), villainEntity.getStory()
                    );
                })
                .collect(Collectors.toList()).stream().findFirst().orElse(null);


    }

    public void create(VillainDTO villainDTO) {
        villainsRepository.save(
                new VillainEntity(villainDTO.getArchRival(),villainDTO.getImagePath(),villainDTO.getRealName(),villainDTO.getHeroName(),
                        villainDTO.getHeight(), villainDTO.getWeight(), villainDTO.getSpecialPower(), villainDTO.getIntelligence(),
                        villainDTO.getStrength(), villainDTO.getPower(), villainDTO.getSpeed(), villainDTO.getAgility(),
                        villainDTO.getDescription(), villainDTO.getStory())
        );
    }
}
