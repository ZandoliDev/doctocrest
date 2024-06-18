package fr.zandolidev;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Praticien extends Personne {

    private final Specialite specialite;

    public Praticien(String nom, Specialite specialite) {
        super(nom);
        this.specialite = specialite;
    }

    @JsonIgnore
    public double getPrix() {
        return this.specialite.getPrix();
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public boolean exerceSpecialite(Specialite specialiteChoisie) {
        return specialiteChoisie == this.specialite;
    }

}
