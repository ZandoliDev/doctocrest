package fr.zandolidev;

public class Personne implements Utilisateur {

    protected String nom;

    public Personne() {
    }

    public Personne(String nom) {
        this.nom = nom;
    }

    @Override
    public String getNom() {
        return nom;
    }
}
