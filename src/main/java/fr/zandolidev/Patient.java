package fr.zandolidev;

import static fr.zandolidev.App.afficherMessage;

public class Patient implements Utilisateur {
    private final String nom;

    public Patient(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public void afficherInformations() {
        afficherMessage("Patient %s".formatted(nom));
    }
}
