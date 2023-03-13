package com.example.cours_groupe2.model.entities;

public class Calcul extends BaseEntity{
    private Integer premierElement;
    private Integer deuxiemeElement;
    private Integer resultat;
    private String symbole;

    public Calcul(Integer premierElement, Integer deuxiemeElement, Integer resultat, String symbole) {
        this.premierElement = premierElement;
        this.deuxiemeElement = deuxiemeElement;
        this.resultat = resultat;
        this.symbole = symbole;
    }

    public Calcul() {
    }

    public Integer getPremierElement() {
        return premierElement;
    }

    public void setPremierElement(Integer premierElement) {
        this.premierElement = premierElement;
    }

    public Integer getDeuxiemeElement() {
        return deuxiemeElement;
    }

    public void setDeuxiemeElement(Integer deuxiemeElement) {
        this.deuxiemeElement = deuxiemeElement;
    }

    public Integer getResultat() {
        return resultat;
    }

    public void setResultat(Integer resultat) {
        this.resultat = resultat;
    }

    public String getSymbole() {
        return symbole;
    }

    public void setSymbole(String symbole) {
        this.symbole = symbole;
    }
}
