package com.galvanize.herobook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@EqualsAndHashCode
@Data
@NoArgsConstructor
public class PersonaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String role;

    public PersonaEntity(String name, String role) {
        this.name = name;
        this.role = role;
    }
}
