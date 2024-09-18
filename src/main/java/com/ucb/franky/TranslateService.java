package com.ucb.franky;

import org.springframework.stereotype.Service;

@Service
public class TranslateService {

    //el constructor de aqui abajo no debe ser autowired ya que se trata de un servicio
    //y de memoria hace la inyeccion de dependencia  por constructor ya que testearemos con
    //mock este servicio y no sabe para que sirve el autowired que es de spring
    ApiTranslate apiTranslate;//esta usando la de google ya que el tiene el @Controller

    TranslateService(ApiTranslate apiTranslate){
        this.apiTranslate=apiTranslate;
    }

    public String translate(TranslateRequestDto translateRequestDto){
        //no se como sera mi implementacion asi que usare interfaces
        //en java usamos las interfaces para abstraer conecptos antes de implementar
        return apiTranslate.translate(translateRequestDto.message(),translateRequestDto.source().toString(),translateRequestDto.target().toString());//se esta usando el de google, ademas vemos una forma de obtener valores de enum usando toString
    }
}
