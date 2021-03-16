package com.galvanize.herobook.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class HeroEntity {
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

    //public HeroEntity(String name) {
    //    this.name=name;
   // }
}
