package com.galvanize.herobook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class HeroDTO {
    String heroName;
    String imagePath;
    String realName;
    float height;
    float weight;
    String specialPower;
    String intelligence;
    String strength;
    String power;
    String speed;
    String agility;
    String description;
    String story;

    public HeroDTO(String heroName, String realName) {
        this.heroName = heroName;
        this.realName = realName;
    }
}

