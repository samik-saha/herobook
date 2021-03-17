package com.galvanize.herobook.service;

import com.galvanize.herobook.model.VillainDTO;
import com.galvanize.herobook.model.VillainEntity;
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
public class VillainsServiceTest {

    @Mock
    VillainsRepository mockVillainsRepository;

    @InjectMocks
    private VillainsService subject;

    @Test
    public void create(){
        VillainDTO VillainDTO = new VillainDTO("XYZ","Batman","","Amir",155,60,"FIT",
                "80","Y","80","70","30","ARTIST","COMEDY");
        subject.create(VillainDTO);
        verify(mockVillainsRepository).save(
                new VillainEntity("XYZ","Batman","","Amir",155,60,"FIT",
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
        when(mockVillainsRepository.findAll()).thenReturn(
                List.of(
                        new VillainEntity("XYZ","Batman","","Amir",155,60,"FIT",
                                "80","Y","80","70","30","ARTIST","COMEDY"),
                        new VillainEntity("XYZ","Superman","","Akshay",175,50,"FAT",
                "90","N","80","70","60","GOOD ARTIST","ACTION"))


        );

        //Exercise
        List<VillainDTO> actual = subject.fetchAll();

        //Assert
        assertThat(actual).isEqualTo(
                List.of(
                        new VillainDTO("XYZ","Batman","","Amir",155,60,"FIT",
                                "80","Y","80","70","30","ARTIST","COMEDY"),
                        new VillainDTO("XYZ","Superman","","Akshay",175,50,"FAT",
                                "90","N","80","70","60","GOOD ARTIST","ACTION")
                )
        );
    }

    @Test
    public void fetchwithname(){
        //Setup
        when(mockVillainsRepository.findAll()).thenReturn(
                List.of(
                        new VillainEntity("XYZ","","ABC","Villain1",155,60,"FIT",
                                "80","Y","80","70","30","ARTIST","COMEDY"),
                        new VillainEntity("XYZ","Superman","","Villain2",175,50,"FAT",
                                "90","N","80","70","60","GOOD ARTIST","ACTION"))


        );

        //Exercise
        VillainDTO actual = subject.fetchwithname("Villain1");

        //Assert
        assertThat(actual).isEqualTo(
                (
                        new VillainDTO("XYZ","","ABC","Villain1",155,60,"FIT",
                                "80","Y","80","70","30","ARTIST","COMEDY")
                       // new VillainDTO("Superman")
                )
        );
    }
}
