package com.ucb.franky;

//aqui asumire que me conectare a una api y que la api hara el trabajo que debo hacer,
//no necesito definir el metodo de implementacion solo el nombre del metodo
public interface ApiTranslate {
    public String translate(String message, String source, String target);
}
