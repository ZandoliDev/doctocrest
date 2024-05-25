package fr.zandolidev;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {

        afficherMessageDeBienvenue();

        String nomPatient = "Amina Lopez";
        int agePatient = 28;
        double taillePatient = 1.70;
        boolean aRendezVous = true;

        afficherTypeDePatient(agePatient);

        // Informations sur le rendez-vous
        String nomMedecin = "Dr. Chen Wong";
        String specialite = "Cardiologue"; // Peut être "Cardiologue", "Dermatologue", "Pédiatre"
        int dureeRendezVous = 45; // en minutes

        double coutRendezVous = definirCoutDuRendezVous(specialite);

        afficherInformationsDuPatient(nomPatient, agePatient, taillePatient);
        afficherRendezVousDuPatient(aRendezVous, nomMedecin, specialite, dureeRendezVous, coutRendezVous);

        int nombreDeRendezVousPris = 3;
        afficherLesRendezVousPris(nombreDeRendezVousPris, dureeRendezVous, coutRendezVous);

        int rendezVousRestants = 5;
        afficherLeDeroulementDesRendezVousRestantsAujourdhui(rendezVousRestants);

        afficherLeDeroulementDesRendezVousPrisAujourdhui(nombreDeRendezVousPris);
    }

    private static void afficherRendezVousDuPatient(boolean aRendezVous, String nomMedecin, String specialite, int dureeRendezVous, double coutRendezVous) {
        afficherMessage(String.format("A un rendez-vous : %b", aRendezVous));
        afficherMessage(String.format("Médecin : %s (%s)", nomMedecin, specialite));
        afficherMessage(String.format("Durée du rendez-vous : %d minutes", dureeRendezVous));
        afficherMessage(String.format("Coût du rendez-vous : %.2f euros", coutRendezVous));
    }

    private static void afficherInformationsDuPatient(String nomPatient, int agePatient, double taillePatient) {
        afficherMessage(String.format("Patient : %s", nomPatient));
        afficherMessage(String.format("Âge : %d ans", agePatient));
        afficherMessage(String.format("Taille : %.2f mètres", taillePatient));
    }

    private static void afficherLeDeroulementDesRendezVousPrisAujourdhui(int nombreDeRendezVousPris) {
        int nouveauxRendezVous = 0;
        do {
            afficherMessage("En attente de nouveaux rendez-vous...");
            nouveauxRendezVous++;
            afficherMessage("Nouveau rendez-vous programmé.");
        } while (nouveauxRendezVous < nombreDeRendezVousPris);
        afficherMessage(String.format("%d nouveaux rendez-vous ont été programmés.", nouveauxRendezVous));
    }

    private static void afficherLeDeroulementDesRendezVousRestantsAujourdhui(int rendezVousRestants) {
        while (rendezVousRestants > 0) {
            afficherMessage(String.format("Nombre de rendez-vous restants aujourd'hui : %d", rendezVousRestants));
            rendezVousRestants--;
            afficherMessage("Un rendez-vous vient de se terminer.");
        }
    }

    private static void afficherLesRendezVousPris(int nombreDeRendezVousPris, int dureeRendezVous, double coutRendezVous) {
        afficherMessage(String.format("Les %d prochains rendez-vous :", nombreDeRendezVousPris));
        for (int i = 1; i <= nombreDeRendezVousPris; i++) {
            afficherMessage(String.format("Rendez-vous %d : Durée %d minutes, Coût %.2f euros", i, dureeRendezVous, coutRendezVous));
        }
    }

    private static double definirCoutDuRendezVous(String specialite) {
        double coutRendezVous;
        switch (specialite) {
            case "Cardiologue":
                coutRendezVous = 100.0;
                break;
            case "Dermatologue":
                coutRendezVous = 80.0;
                break;
            case "Pédiatre":
                coutRendezVous = 90.0;
                break;
            default:
                coutRendezVous = 70.0;
                break;
        }
        return coutRendezVous;
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
