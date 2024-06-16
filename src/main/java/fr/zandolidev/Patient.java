package fr.zandolidev;

import static fr.zandolidev.App.afficherMessage;

public class Patient extends Personne {

    public Patient(String nom) {
        super(nom);
    }

    @Override
    public void afficherInformations() {
        afficherMessage("Patient %s".formatted(nom));
    }
}
