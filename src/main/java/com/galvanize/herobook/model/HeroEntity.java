package com.galvanize.herobook.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class HeroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
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

    public HeroEntity(String heroName, String imagePath, String realName, float height, float weight, String specialPower, String intelligence, String strength, String power, String speed, String agility, String description, String story) {
        this.heroName = heroName;
        this.imagePath = imagePath;
        this.realName = realName;
        this.height = height;
        this.weight = weight;
        this.specialPower = specialPower;
        this.intelligence = intelligence;
        this.strength = strength;
        this.power = power;
        this.speed = speed;
        this.agility = agility;
        this.description = description;
        this.story = story;
    }
}
