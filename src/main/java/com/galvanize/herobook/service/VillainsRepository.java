package com.galvanize.herobook.service;

import com.galvanize.herobook.model.VillainEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VillainsRepository extends JpaRepository<VillainEntity, Long> {
}
