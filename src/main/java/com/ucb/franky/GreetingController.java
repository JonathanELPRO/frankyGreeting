package com.ucb.franky;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class GreetingController {
    @Autowired
    GreetingService greetingService;

    @GetMapping
    public String greeting() {
        return greetingService.getGreeting();
    }

    @GetMapping("special")
    public String greetingWithName(@RequestBody GreetingRequestDto greetingRequestDto) {
        //tenia la opcion de simplemente usar mi servicio que recibia el nombre y creaba el saludo  enviandole solo el parametro de nombre del request
        // peroo prefiero guardar el saludo en una estructura mas compleja como lo es un response ya que
        //en esa estructura compleja puedo ir guardando otros parametros aunque sean algo obvio como el nombre de a quien se envia el saludo
        //el idioma al cual fue traducido el saludo y asi, o bien puedo tener un vector de es esta estructura compleja de saludos y de ahi la justificacion del GreetingResponse
        // creo que es pertinente guardar el saludo, observacion: pese a tener una estructura relativamente compleja como GreetingResponseDto igual nomas solo retornare el saludo y no
        //toda la estructura como se hizo en Franky 3 con ResponseEntity.ok(response)

        String name=greetingRequestDto.name();
        String greeting = greetingService.getGreetingWithName(name);
        GreetingResponseDto greetingResponseDto= new GreetingResponseDto(name,"ESP",greeting);

        return greetingResponseDto.greeting();
    }

    @GetMapping("translated")
    public String translatedGreetingWithName(@RequestBody GreetingRequestDto greetingRequestDto) {
        String targetLanguage=greetingRequestDto.targetLanguage();
        String name = greetingRequestDto.name();
        String translatedGreeting = greetingService.getTranslatedGreetingWithName(name, targetLanguage);
        GreetingResponseDto greetingResponseDto = new GreetingResponseDto(name,targetLanguage,translatedGreeting);
        return greetingResponseDto.greeting();
    }
}
