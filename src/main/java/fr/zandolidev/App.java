package fr.zandolidev;

import java.util.List;
import java.util.Scanner;

public class App {

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
        for (int i = 0; i < specialites.length; i++) {
            afficherMessage("%d - %s".formatted(i, specialites[i]));
        }
        int indexSpecialite = scanner.nextInt();
        Specialite specialiteChoisie = specialites[indexSpecialite];
        return chercherPraticienDeSpecialite(specialiteChoisie);
    }

    private static Praticien chercherPraticienDeSpecialite(Specialite specialiteChoisie) {
        for (Praticien praticien : PRATICIENS) {
            if (praticien.exerceSpecialite(specialiteChoisie)) {
                return praticien;
            }
        }
        return null;
    }

    public static void afficherMessage(String message) {
        System.out.println(message);
    }

}
