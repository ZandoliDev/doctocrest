package fr.zandolidev;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App
{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try {
            afficherMessageDeBienvenue();

            String nomPatient = renseignerNomPatient(scanner);
            int agePatient = renseignerAgePatient(nomPatient, scanner);
            afficherMessage("Le patient souhaite-il prendre un rendez-vous ? (true/false)");
            boolean aRendezVous = scanner.nextBoolean();
            scanner.nextLine(); // pour consommer le retour à la ligne généré par le bouton "Entrée"

            if (aRendezVous) {
                afficherMessage("Quelle est la spécialité du médecin à consulter ? (Cardiologue, Dermatologue, Pédiatre)");
                String nomMedecin = "Dr. Chen Wong";
                int dureeRendezVous = 45; // en minutes
                String specialite = scanner.nextLine();

                double coutRendezVous = definirCoutDuRendezVous(specialite);
                afficherMessage("Le patient souhaite prendre un rendez-vous avec un %s.".formatted(specialite));

                afficherInformationsDuPatient(nomPatient, agePatient);
                afficherRendezVousDuPatient(aRendezVous, nomMedecin, specialite, dureeRendezVous, coutRendezVous);

            } else {
                afficherInformationsDuPatient(nomPatient, agePatient);
                afficherMessage("Le patient ne souhaite pas prendre de rendez-vous.");
            }
        } catch (Exception e) {
            afficherMessage("Une erreur inattendue est survenue. Veuillez réessayer.");
        } finally {
            scanner.close();
        }

    }

    private static int renseignerAgePatient(String nomPatient, Scanner scanner) {
        afficherMessage("Entrez l'âge de %s".formatted(nomPatient));
        try {
            int agePatient = scanner.nextInt();
            if(agePatient <= 0) {
                throw new InputMismatchException();
            }
            return agePatient;
        } catch (InputMismatchException e) {
            scanner.nextLine();
            afficherMessage("L'âge doit être plus grand que 0.");
            return renseignerAgePatient(nomPatient, scanner);
        }
    }

    private static String renseignerNomPatient(Scanner scanner) {
        afficherMessage("Entrez le nom du patient");
        return scanner.nextLine();
    }

    private static void afficherRendezVousDuPatient(boolean aRendezVous, String nomMedecin, String specialite, int dureeRendezVous, double coutRendezVous) {
        if (aRendezVous) {
            afficherMessage(String.format("Le patient a un rendez-vous avec le %s", specialite));
        } else {
            afficherMessage("Le patient n'a pas de rendez-vous.");
        }
        afficherMessage(String.format("Médecin : %s (%s)", nomMedecin, specialite));
        afficherMessage(String.format("Durée du rendez-vous : %d minutes", dureeRendezVous));
        afficherMessage(String.format("Coût du rendez-vous : %.2f euros", coutRendezVous));
    }

    private static void afficherInformationsDuPatient(String nomPatient, int agePatient) {
        afficherMessage(String.format("Patient : %s", nomPatient));
        afficherMessage(String.format("Âge : %d ans", agePatient));
        afficherTypeDePatient(agePatient);
    }

    private static double definirCoutDuRendezVous(String specialite) {
        switch (specialite) {
            case "Cardiologue":
                return 100.0;
            case "Dermatologue":
                return 80.0;
            case "Pédiatre":
                return 90.0;
            default:
                return 70.0;
        }
    }

    private static void afficherTypeDePatient(int agePatient) {
        if (agePatient >= 65) {
            afficherMessage("Le patient est un senior.");
        } else if (agePatient >= 18) {
            afficherMessage("Le patient est un adulte.");
        } else {
            afficherMessage("Le patient est un mineur.");
        }
    }

    private static void afficherMessageDeBienvenue() {
        afficherMessage("Bienvenue sur DoctoCrest !");
    }

    private static void afficherMessage(String message) {
        System.out.println(message);
    }
    
}
