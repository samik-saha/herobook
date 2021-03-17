package com.galvanize.herobook.service;

import com.galvanize.herobook.model.HeroDTO;
import com.galvanize.herobook.model.VisitorDTO;
import com.galvanize.herobook.model.VisitorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class VisitorService {
    private final VisitorRepository visitorRepository;

    @Autowired

    public VisitorService(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }


    public void create(VisitorDTO visitorDTO) {
        this.visitorRepository.save(new VisitorEntity(
                visitorDTO.getName()
        ));
    }

    public VisitorDTO fetchVisitor(String name) {
        return this.visitorRepository.findAll()
                .stream()
                .filter(visitorEntity ->
                        visitorEntity.getName() == name
                ).map(visitorEntity -> {
                    return new VisitorDTO(visitorEntity.getName());
                })
                .collect(Collectors.toList()).stream().findFirst().orElse(null);
    }
}
