package com.ucb.franky;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    @Value("${saludoESP}")
    private String greetESP;  //la anotación @Value en Spring se utiliza para la
    // inyección de valores de propiedades en los campos de una clase, y puede
    // considerarse una forma de inyección de dependencia

    //String greet = "Preguntate si lo que estas haciendo hoy te acerca al lugar en el que quieres estar mañana";

    @Value("${saludoENG}")
    private String greetENG;

    public String getGreeting() {
        return greetESP;
    }

    public String getGreetingWithName(String name){
        return name+". "+greetESP;
    }

    public String getTranslatedGreetingWithName(String name, String targetLanguage) {
        String translatedGreeting;
        if ("ESP".equals(targetLanguage)) {
            translatedGreeting = greetESP;
        } else if ("ENG".equals(targetLanguage)) {
            translatedGreeting = greetENG;
        } else {
            translatedGreeting = "";
        }

        return name + ". " + translatedGreeting;
    }


}
