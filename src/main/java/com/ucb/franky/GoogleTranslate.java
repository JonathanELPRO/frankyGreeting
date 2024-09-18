package com.ucb.franky;

import org.springframework.stereotype.Component;

//si una clase implementa cierta interfaz necesariamente deberia tener todos los metodos de la interfaz
@Component   //aqui pone esto de component porque cuando se llama a la interfaz desde TranslateService
//si yo no le pongo el component se confundira antre google y duolingo, ya con esto sabra que se trata de google
public class GoogleTranslate implements ApiTranslate{
    @Override
    public String translate(String message, String source, String target) {
        return "";
    }
}
