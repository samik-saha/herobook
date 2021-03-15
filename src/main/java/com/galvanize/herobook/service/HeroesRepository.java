package com.galvanize.herobook.service;

import com.galvanize.herobook.model.HeroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroesRepository extends JpaRepository<HeroEntity, Long> {
}
