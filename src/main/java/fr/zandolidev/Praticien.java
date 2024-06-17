package fr.zandolidev;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Praticien extends Personne {

    private static final Logger LOGGER = LogManager.getLogger(Praticien.class);

    private final Specialite specialite;

    public Praticien(String nom, Specialite specialite) {
        super(nom);
        this.specialite = specialite;
    }

    public double getPrix() {
        return this.specialite.getPrix();
    }

    public boolean exerceSpecialite(Specialite specialiteChoisie) {
        return specialiteChoisie == this.specialite;
    }

    @Override
    public void afficherInformations() {
        LOGGER.info("Praticien {} spécialisé en {}", nom, specialite);
    }
}
