package fr.zandolidev;

public class RendezVousMedical {

    private final Praticien praticien;
    private final Patient patient;

    public RendezVousMedical(Praticien praticien, Patient patient) {
        this.praticien = praticien;
        this.patient = patient;
    }

    public Patient getPatient() {
        return patient;
    }

    public Praticien getPraticien() {
        return praticien;
    }

    public double getPrix() {
        return praticien.getPrix();
    }
}
