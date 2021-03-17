package com.galvanize.herobook.service;

import com.galvanize.herobook.model.VisitorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitorRepository  extends JpaRepository<VisitorEntity, Long> {
}
