package fr.zandolidev;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        try(Scanner scanner = new Scanner(System.in)) {
            afficherMessageDeBienvenue();

            String[] nomsPraticiens = {"Dr. Alice Martin", "Dr. Li Wei", "Dr. Maria Gonzalez", "Dr. John Smith", "Dr. Adebayo Adeyemi", "Dr. Hiroshi Yamamoto"};
            String[] specialitesPraticiens = {"Cardiologue", "Dermatologue", "Pédiatre", "Neurologue", "Gynécologue", "Généraliste", "Orthopédiste"};

            String nomPatient = renseignerNomPatient(scanner);
            int agePatient = renseignerAgePatient(nomPatient, scanner);
            afficherMessage("Le patient souhaite-il prendre un rendez-vous ? (true/false)");
            boolean aRendezVous = scanner.nextBoolean();
            scanner.nextLine(); // pour consommer le retour à la ligne généré par le bouton "Entrée"

            if (aRendezVous) {
                afficherMessage("Quelle est la spécialité du médecin à consulter ? (Cardiologue, Dermatologue, Pédiatre, Neurologue, Gynécologue, Généraliste, Orthopédiste)");
                String specialite = scanner.nextLine();

                int indexPraticien = trouverPraticienParSpecialite(specialitesPraticiens, specialite);
                if (indexPraticien == -1) {
                    afficherMessage("Aucun praticien disponible pour la spécialité demandée.");
                } else {
                    String nomMedecin = nomsPraticiens[indexPraticien];
                    double coutRendezVous = definirCoutDuRendezVous(specialite);
                    afficherMessage("Le patient souhaite prendre un rendez-vous avec un %s.".formatted(specialite));

                    afficherInformationsDuPatient(nomPatient, agePatient);
                    afficherRendezVousDuPatient(aRendezVous, nomMedecin, specialite, coutRendezVous);
                }
            } else {
                afficherInformationsDuPatient(nomPatient, agePatient);
                afficherMessage("Le patient ne souhaite pas prendre de rendez-vous.");
            }
        } catch (Exception e) {
            afficherMessage("Une erreur inattendue est survenue. Veuillez réessayer.");
        }
    }

    private static int trouverPraticienParSpecialite(String[] specialitesPraticiens, String specialite) {
        for (int i = 0; i < specialitesPraticiens.length; i++) {
            if (specialitesPraticiens[i].equalsIgnoreCase(specialite)) {
                return i;
            }
        }
        return -1; // Retourne -1 si aucun praticien n'est trouvé pour la spécialité donnée
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

    private static void afficherRendezVousDuPatient(boolean aRendezVous, String nomMedecin, String specialite, double coutRendezVous) {
        if (aRendezVous) {
            afficherMessage(String.format("Le patient a un rendez-vous avec le %s", specialite));
        } else {
            afficherMessage("Le patient n'a pas de rendez-vous.");
        }
        afficherMessage(String.format("Médecin : %s (%s)", nomMedecin, specialite));
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
            case "Neurologue":
                return 120.0;
            case "Gynécologue":
                return 110.0;
            case "Généraliste":
                return 60.0;
            case "Orthopédiste":
                return 100.0;
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
