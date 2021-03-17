package com.galvanize.herobook.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class VillainEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String archRival;
    String imagePath;
    String realName;
    String heroName;
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

    public VillainEntity(String archRival, String imagePath, String realName, String heroName, float height, float weight, String specialPower, String intelligence, String strength, String power, String speed, String agility, String description, String story) {
        this.archRival = archRival;
        this.imagePath = imagePath;
        this.realName = realName;
        this.heroName = heroName;
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
