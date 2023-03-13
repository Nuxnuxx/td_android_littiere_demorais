package com.example.cours_groupe2;

public enum TypeOperationEnum {
    ADD(" + "),
    SUBSTRACT(" - "),
    DIVIDE(" / "),
    MULTIPLY(" x ");

    TypeOperationEnum(String symbole) {
        this.symbole=symbole;
    }

    public String getSymbole() {
        return symbole;
    }

    private String symbole;
}
