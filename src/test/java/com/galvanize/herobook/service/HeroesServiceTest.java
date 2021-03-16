package com.galvanize.herobook.service;

import com.galvanize.herobook.model.HeroDTO;
import com.galvanize.herobook.model.HeroEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HeroesServiceTest {

    @Mock
    HeroesRepository mockHeroesRepository;

    @InjectMocks
    private HeroesService subject;

    @Test
    public void fetchAll(){
        //Setup
        //AnimalEntity animalEntity = new AnimalEntity("Tiger", "walking", "unhappy");
        when(mockHeroesRepository.findAll()).thenReturn(
                List.of(
                        new HeroEntity("Batman"),
                        new HeroEntity("Superman")
                )
        );

        //Exercise
        List<HeroDTO> actual = subject.fetchAll();

        //Assert
        assertThat(actual).isEqualTo(
                List.of(
                        new HeroDTO("Batman"),
                        new HeroDTO("Superman")
                )
        );
    }

    @Test
    public void fetchwithname(){
        //Setup
        //AnimalEntity animalEntity = new AnimalEntity("Tiger", "walking", "unhappy");
        when(mockHeroesRepository.findAll()).thenReturn(
                List.of(
                        new HeroEntity("Batman"),
                        new HeroEntity("Superman")
                )
        );

        //Exercise
        HeroDTO actual = subject.fetchwithname("Batman");

        //Assert
        assertThat(actual).isEqualTo(
                (
                        new HeroDTO("Batman")
                       // new HeroDTO("Superman")
                )
        );
    }
}
