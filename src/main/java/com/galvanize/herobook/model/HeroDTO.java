package com.galvanize.herobook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@AllArgsConstructor
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

 //   public HeroDTO(String heroName,String imagePath,String realName,float height,float weight,String specialPower,
  //                 String intelligence,String strength,String power,String speed,String agility,String description,String story) {
   //     this.name=name;
    }

