package fr.zandolidev;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Personne implements Utilisateur {

    private static final Logger LOGGER = LogManager.getLogger(Personne.class);

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
        LOGGER.info("Personne {}", nom);
    }
}
