package com.ucb.franky;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TranslateServiceTest {

    //Hay un objeto adicional al llamar al  translateService.translate ya que se llama al translate de una de mis interfaces asi que sera un mock
    //otro justificativo es que no hay implementacion del apitranslate por eso se usa mockito
    @Mock
    ApiTranslate apiTranslate;

    @InjectMocks
    TranslateService translateService;


    @Test
    void translate() {

        when(apiTranslate.translate("Hola", Language.ES.toString(), Language.EN.toString())).thenReturn("Hello");
        TranslateRequestDto translateRequestDto=new TranslateRequestDto("Hola",Language.ES,Language.EN);//manera de usar el constructor del enum
        assertEquals("Hello", translateService.translate(translateRequestDto));
    }
}