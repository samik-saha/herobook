package com.galvanize.herobook.service;

import com.galvanize.herobook.model.PersonaDTO;
import com.galvanize.herobook.model.PersonaEntity;
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
public class PersonaServiceTest {
    @Mock
    PersonaRepository mockVisitorRepository;

    @InjectMocks
    private PersonaService subject;

    @Test
    public void create(){
        PersonaDTO visitorDTO = new PersonaDTO("Sunita","Visitor");
        subject.create(visitorDTO);
        verify(mockVisitorRepository).save(
                new PersonaEntity("Sunita","Visitor")
        );
    }

    @Test
    public void fetchVisitor(){
        when(mockVisitorRepository.findAll()).thenReturn(
                List.of(
                        new PersonaEntity("Samik","Fan"),
                        new PersonaEntity("Sunita","Visitor"))


        );

        //Exercise
        PersonaDTO actual = subject.fetchVisitor("Sunita");

        //Assert
        assertThat(actual).isEqualTo(
                (
                        new PersonaDTO("Sunita","Visitor")
                )
        );
    }
}
