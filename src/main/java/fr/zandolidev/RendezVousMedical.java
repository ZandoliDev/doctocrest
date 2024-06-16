package fr.zandolidev;

import static fr.zandolidev.App.afficherMessage;

public class RendezVousMedical {
    private final Praticien praticien;
    private final Patient patient;

    public RendezVousMedical(Praticien praticien, Patient patient) {
        this.praticien = praticien;
        this.patient = patient;
    }

    public void afficherRecapitulatif() {
        afficherMessage(
                "%s a rendez-vous avec %s pour un montant de %.2f €".formatted(
                        patient.getNom(),
                        praticien.getNom(),
                        getPrix()
                )
        );
    }

    public double getPrix() {
        return praticien.getPrix();
    }
}
