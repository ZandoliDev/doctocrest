package fr.zandolidev;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Patient extends Personne {

    private static final Logger LOGGER = LogManager.getLogger(Patient.class);

    public Patient(String nom) {
        super(nom);
    }

    @Override
    public void afficherInformations() {
        LOGGER.info("Patient {}", nom);
    }
}
