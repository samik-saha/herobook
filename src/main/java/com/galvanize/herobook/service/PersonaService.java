package com.galvanize.herobook.service;

import com.galvanize.herobook.model.PersonaDTO;
import com.galvanize.herobook.model.PersonaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class PersonaService {
    private final PersonaRepository visitorRepository;

    @Autowired
    public PersonaService(PersonaRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }


    public void create(PersonaDTO visitorDTO) {
        this.visitorRepository.save(new PersonaEntity(
                visitorDTO.getName(), visitorDTO.getRole()
        ));
    }

    public PersonaDTO fetchPersona(String name) {
        return this.visitorRepository.findAll()
                .stream()
                .filter(visitorEntity ->
                        visitorEntity.getName().equals(name)
                ).map(visitorEntity -> {
                    return new PersonaDTO(visitorEntity.getName(), visitorEntity.getRole());
                })
                .collect(Collectors.toList()).stream().findFirst().orElse(null);
    }
}
