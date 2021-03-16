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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HeroesServiceTest {

    @Mock
    HeroesRepository mockHeroesRepository;

    @InjectMocks
    private HeroesService subject;

    @Test
    public void create(){
        HeroDTO HeroDTO = new HeroDTO("Batman","","Amir",155,60,"FIT",
                "80","Y","80","70","30","ARTIST","COMEDY");
        subject.create(HeroDTO);
        verify(mockHeroesRepository).save(
                new HeroEntity("Batman","","Amir",155,60,"FIT",
                        "80","Y","80","70","30","ARTIST","COMEDY")
        );
    }

    @Test
    public void fetchAll(){
        //Setup
        //AnimalEntity animalEntity = new AnimalEntity("Tiger", "walking", "unhappy");

        //String heroName,String imagePath,String realName,float height,float weight,String specialPower,
        //  // String intelligence,String strength,String power,String speed,String agility,
        //  String description,String story
        when(mockHeroesRepository.findAll()).thenReturn(
                List.of(
                        new HeroEntity("Batman","","Amir",155,60,"FIT",
                                "80","Y","80","70","30","ARTIST","COMEDY"),
                        new HeroEntity("Superman","","Akshay",175,50,"FAT",
                "90","N","80","70","60","GOOD ARTIST","ACTION"))


        );

        //Exercise
        List<HeroDTO> actual = subject.fetchAll();

        //Assert
        assertThat(actual).isEqualTo(
                List.of(
                        new HeroDTO("Batman","","Amir",155,60,"FIT",
                                "80","Y","80","70","30","ARTIST","COMEDY"),
                        new HeroDTO("Superman","","Akshay",175,50,"FAT",
                                "90","N","80","70","60","GOOD ARTIST","ACTION")
                )
        );
    }

    @Test
    public void fetchwithname(){
        //Setup
        //AnimalEntity animalEntity = new AnimalEntity("Tiger", "walking", "unhappy");
        when(mockHeroesRepository.findAll()).thenReturn(
                List.of(
                        new HeroEntity("Batman","","Amir",155,60,"FIT",
                                "80","Y","80","70","30","ARTIST","COMEDY"),
                        new HeroEntity("Superman","","Akshay",175,50,"FAT",
                                "90","N","80","70","60","GOOD ARTIST","ACTION"))


        );

        //Exercise
        HeroDTO actual = subject.fetchwithname("Superman");

        //Assert
        assertThat(actual).isEqualTo(
                (
                        new HeroDTO("Superman","","Akshay",175,50,"FAT",
                                "90","N","80","70","60","GOOD ARTIST","ACTION")
                       // new HeroDTO("Superman")
                )
        );
    }
}
