package fr.zandolidev;

import java.util.Random;

public class App {
    public static void main(String[] args) {

        Random random = new Random();
        for(int i=0; i<10000000; i++) {
            afficherMessageDeBienvenue();

            String[] nomsPraticiens = {"Dr. Alice Martin", "Dr. Li Wei", "Dr. Maria Gonzalez", "Dr. John Smith", "Dr. Adebayo Adeyemi", "Dr. Hiroshi Yamamoto", "Dr. Elena Ivanova"};
            String[] specialitesPraticiens = {"Cardiologue", "Dermatologue", "Pédiatre", "Neurologue", "Gynécologue", "Généraliste", "Orthopédiste"};

            String nomPatient = "toto";
            int agePatient = 24;
            boolean aRendezVous = true;

            int indexSpecialite = random.nextInt(specialitesPraticiens.length);
            String specialite = specialitesPraticiens[indexSpecialite];
            afficherMessage("Nouveau rendez-vous demandé pour un %s.".formatted(specialite));

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
        //System.out.println(message);
    }

}
