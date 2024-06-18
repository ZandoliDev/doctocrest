package fr.zandolidev;

public class RequetePriseDeRendezVous {

    private final Patient patient;
    private final Specialite specialite;

    public RequetePriseDeRendezVous(Patient patient, Specialite specialite) {
        this.patient = patient;
        this.specialite = specialite;
    }

    public Patient getPatient() {
        return patient;
    }

    public Specialite getSpecialite() {
        return specialite;
    }
}
