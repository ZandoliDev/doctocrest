package fr.zandolidev.infrastructure;

import fr.zandolidev.modele.personne.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByNom(String nom);
}
