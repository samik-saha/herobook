package com.galvanize.herobook.model;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class HeroDTO {
    String name;
    public HeroDTO(String name) {
        this.name=name;
    }
}
