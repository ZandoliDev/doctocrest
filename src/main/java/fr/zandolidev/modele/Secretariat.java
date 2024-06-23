package fr.zandolidev.modele;

import fr.zandolidev.controller.RequetePriseDeRendezVous;
import fr.zandolidev.infrastructure.PatientRepository;
import fr.zandolidev.modele.personne.Patient;
import fr.zandolidev.modele.personne.Praticien;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Secretariat {

    private static final Logger LOGGER = LogManager.getLogger(Secretariat.class);

    private final PatientRepository patientRepository;

    public Secretariat(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public RendezVousMedical prendreRendezVous(RequetePriseDeRendezVous requete) {
        LOGGER.info("Prise de rendez-vous");
        LOGGER.debug("Patient : {} _ Specialite : {}", requete.getPatient(), requete.getSpecialite());
        Patient patient = requete.getPatient();
        patientRepository.findByNom("TOm");
        Specialite specialite = requete.getSpecialite();
        Praticien praticien = chercherPraticienDeSpecialite(specialite);
        return new RendezVousMedical(praticien, patient);
    }

    static final List<Praticien> PRATICIENS = List.of(
            new Praticien("Dr. Alice Martin", Specialite.CARDIOLOGUE),
            new Praticien("Dr. Li Wei", Specialite.DERMATOLOGUE),
            new Praticien("Dr. Maria Gonzalez", Specialite.PEDIATRE),
            new Praticien("Dr. John Smith", Specialite.NEUROLOGUE),
            new Praticien("Dr. Adebayo Adeyemi", Specialite.GYNECOLOGUE),
            new Praticien("Dr. Hiroshi Yamamoto", Specialite.GENERALISTE),
            new Praticien("Dr. Elena Ivanova", Specialite.ORTHOPEDISTE)
    );

    private Praticien chercherPraticienDeSpecialite(Specialite specialiteChoisie) {
        return PRATICIENS.stream()
                .filter(praticien -> praticien.exerceSpecialite(specialiteChoisie))
                .findFirst()
                .orElseThrow();
    }
}
