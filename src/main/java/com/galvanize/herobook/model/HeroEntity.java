package com.galvanize.herobook.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class HeroEntity {
    String name;

    public HeroEntity(String name) {
        this.name=name;
    }
}
