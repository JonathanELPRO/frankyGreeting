package com.ucb.franky;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

//Cuando usas @SpringBootTest, estás creando un entorno de prueba
// en el que el contexto completo de Spring Boot se carga.
// Esto significa que todos los beans (componentes, servicios, repositorios, etc.)
// definidos en tu aplicación se inicializan y se ponen a disposición para tus pruebas.

@SpringBootTest
class GreetingServiceTest {

    @Autowired
    private GreetingService greetingService;

    @Test
    @DisplayName("Test for simple greeting")
    void getGreeting() {


        //GreetingService greetingService = new GreetingService(); //con esto de aqui surge problema porque
        //sus inyecciones de valores por medio de @Value que sale del .yml no se realiza cuando creas una instancia manual de GreetingService en el test y esto es una instancia manual:GreetingService greetingService = new GreetingService();
        //solo se inyectan en beans administrados por el contenedor de Spring.
        // y tu clase Service es un bean ya que le pusiste @Service

        assertEquals("Preguntate si lo que estas haciendo hoy te acerca al lugar en el que quieres estar maniana",greetingService.getGreeting());
    }

    @Test
    @DisplayName("Test for greeting name")
    void getGreetingWithName() {
//        GreetingRequestDto es un simple objeto de transferencia de datos (DTO)
//        sin logica interna ni dependencias externas, usarlo directamente
//        en las pruebas es suficiente porque sino deberiamos usar el @Mock o @InyectMocks
        GreetingRequestDto greetingRequestDto=new GreetingRequestDto("pepito","ESP");
        String greetingReal=greetingService.getGreetingWithName(greetingRequestDto.name());
        String greetingExpected="pepito. "+"Preguntate si lo que estas haciendo hoy te acerca al lugar en el que quieres estar maniana";
        assertEquals(greetingExpected,greetingReal);

    }

    @Test
    @DisplayName("Test for translated greeting name")
    void getTranslatedGreetingWithName() {
//        GreetingRequestDto es un simple objeto de transferencia de datos (DTO)
//        sin logica interna ni dependencias externas, usarlo directamente
//        en las pruebas es suficiente porque sino deberiamos usar el @Mock o @InyectMocks
        GreetingRequestDto greetingRequestDto=new GreetingRequestDto("pepito","ENG");
        String greetingReal=greetingService.getTranslatedGreetingWithName(greetingRequestDto.name(),greetingRequestDto.targetLanguage());
        String greetingExpected="pepito. "+"Ask yourself if what you are doing today brings you closer to the place you want to be tomorrow";
        assertEquals(greetingExpected,greetingReal);

    }


}