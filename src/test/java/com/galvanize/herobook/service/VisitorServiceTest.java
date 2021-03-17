package com.galvanize.herobook.service;

import com.galvanize.herobook.model.HeroDTO;
import com.galvanize.herobook.model.VisitorDTO;
import com.galvanize.herobook.model.HeroEntity;
import com.galvanize.herobook.model.VisitorEntity;
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
public class VisitorServiceTest {
    @Mock
    VisitorRepository mockVisitorRepository;

    @InjectMocks
    private VisitorService subject;

    @Test
    public void create(){
        VisitorDTO visitorDTO = new VisitorDTO("Sunita");
        subject.create(visitorDTO);
        verify(mockVisitorRepository).save(
                new VisitorEntity("Sunita")
        );
    }

    @Test
    public void fetchVisitor(){
        when(mockVisitorRepository.findAll()).thenReturn(
                List.of(
                        new VisitorEntity("Samik"),
                        new VisitorEntity("Sunita"))


        );

        //Exercise
        VisitorDTO actual = subject.fetchVisitor("Sunita");

        //Assert
        assertThat(actual).isEqualTo(
                (
                        new VisitorDTO("Sunita")
                )
        );
    }
}
