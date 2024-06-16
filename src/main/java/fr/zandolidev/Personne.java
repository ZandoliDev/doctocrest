package fr.zandolidev;

import static fr.zandolidev.App.afficherMessage;

public class Personne implements Utilisateur {

    protected final String nom;

    public Personne(String nom) {
        this.nom = nom;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public void afficherInformations() {
        afficherMessage("Personne %s".formatted(nom));
    }
}
