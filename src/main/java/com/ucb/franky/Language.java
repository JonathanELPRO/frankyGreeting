package com.ucb.franky;

public enum Language {
    ES("ES"),
    EN("EN"),
    FN("FN"),
    PO("PO");
    private final String description;

    Language(String description){
        this.description=description;
    }

    public String toString(){
        return description;
    }
}
