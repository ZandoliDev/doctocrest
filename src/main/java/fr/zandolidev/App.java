package fr.zandolidev;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class App {

    private static final Logger LOGGER = LogManager.getLogger(App.class);

    static final List<Praticien> PRATICIENS = List.of(
            new Praticien("Dr. Alice Martin", Specialite.CARDIOLOGUE),
            new Praticien("Dr. Li Wei", Specialite.DERMATOLOGUE),
            new Praticien("Dr. Maria Gonzalez", Specialite.PEDIATRE),
            new Praticien("Dr. John Smith", Specialite.NEUROLOGUE),
            new Praticien("Dr. Adebayo Adeyemi", Specialite.GYNECOLOGUE),
            new Praticien("Dr. Hiroshi Yamamoto", Specialite.GENERALISTE),
            new Praticien("Dr. Elena Ivanova", Specialite.ORTHOPEDISTE)
    );

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            Personne personne = new Personne("John Doe");
            personne.afficherInformations();
            Patient patient = renseignerInformationsPatient(scanner);
            patient.afficherInformations();
            Praticien praticien = choisirPraticien(scanner);
            praticien.afficherInformations();
            RendezVousMedical rendezVousMedical = new RendezVousMedical(praticien, patient);

            rendezVousMedical.afficherRecapitulatif();
        }
    }

    private static Patient renseignerInformationsPatient(Scanner scanner) {
        afficherMessage("Veuillez renseigner le nom du patient :");
        String nom = scanner.nextLine();
        return new Patient(nom);
    }

    private static Praticien choisirPraticien(Scanner scanner) {
        afficherMessage("Saisir le numéro de la spécialité du praticien :");
        Specialite[] specialites = Specialite.values();
        IntStream.range(0, specialites.length)
                .mapToObj(i -> "%d - %s".formatted(i, specialites[i]))
                .forEach(App::afficherMessage);
        int indexSpecialite = scanner.nextInt();
        Specialite specialiteChoisie = specialites[indexSpecialite];
        return chercherPraticienDeSpecialite(specialiteChoisie);
    }

    private static Praticien chercherPraticienDeSpecialite(Specialite specialiteChoisie) {
        return PRATICIENS.stream()
                .filter(praticien -> praticien.exerceSpecialite(specialiteChoisie))
                .findFirst()
                .orElseThrow();
    }

    public static void afficherMessage(String message) {
        LOGGER.info(message);
    }

}
