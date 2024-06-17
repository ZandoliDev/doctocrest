package fr.zandolidev;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RendezVousMedical {

    private static final Logger LOGGER = LogManager.getLogger(RendezVousMedical.class);

    private final Praticien praticien;
    private final Patient patient;

    public RendezVousMedical(Praticien praticien, Patient patient) {
        this.praticien = praticien;
        this.patient = patient;
    }

    public void afficherRecapitulatif() {
        LOGGER.info(
                "{} a rendez-vous avec {} pour un montant de {} €",
                patient.getNom(),
                praticien.getNom(),
                "%.2f".formatted(getPrix())
        );
    }

    public double getPrix() {
        return praticien.getPrix();
    }
}
