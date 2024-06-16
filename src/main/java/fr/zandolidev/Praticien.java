package fr.zandolidev;

import static fr.zandolidev.App.afficherMessage;

public class Praticien implements Utilisateur {
    private final String nom;
    private final Specialite specialite;

    public Praticien(String nom, Specialite specialite) {
        this.nom = nom;
        this.specialite = specialite;
    }

    public double getPrix() {
        return this.specialite.getPrix();
    }

    public boolean exerceSpecialite(Specialite specialiteChoisie) {
        return specialiteChoisie == this.specialite;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public void afficherInformations() {
        afficherMessage("Praticien %s spécialisé en %s".formatted(nom, specialite));
    }
}
