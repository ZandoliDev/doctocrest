package fr.zandolidev;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        // Les variables et les types de données
        String nomPatient = "Amina Lopez";
        int agePatient = 28;
        double taillePatient = 1.70;
        boolean aRendezVous = true;

        // Informations sur le rendez-vous
        String nomMedecin = "Dr. Chen Wong";
        String specialite = "Cardiologue"; // Peut être "Cardiologue", "Dermatologue", "Pédiatre"
        int dureeRendezVous = 45; // en minutes
        double coutRendezVous;

        // Les structures de contrôle

        // Instruction conditionnelle if-else
        if (agePatient >= 65) {
            System.out.println("Le patient est un senior.");
        } else if (agePatient >= 18) {
            System.out.println("Le patient est un adulte.");
        } else {
            System.out.println("Le patient est un mineur.");
        }

        // Instruction conditionnelle switch-case

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

        // Affichage des informations du patient et du rendez-vous
        System.out.printf("Bienvenue sur DoctoCrest !%n");
        System.out.printf("Patient : %s", nomPatient);
        System.out.printf("Âge : %d ans%n", agePatient);
        System.out.printf("Taille : %.2f mètres%n", taillePatient);
        System.out.printf("A un rendez-vous : %b%n", aRendezVous);
        System.out.printf("Médecin : %s (%s)%n", nomMedecin, specialite);
        System.out.printf("Durée du rendez-vous : %d minutes%n", dureeRendezVous);
        System.out.printf("Coût du rendez-vous : %.2f euros%n", coutRendezVous);

        // Boucle for - Afficher les 3 prochains rendez-vous
        System.out.println("Les 3 prochains rendez-vous :");
        for (int i = 1; i <= 3; i++) {
            System.out.printf("Rendez-vous %d : Durée %d minutes, Coût %.2f euros%n", i, dureeRendezVous, coutRendezVous);
        }

        // Boucle while - Décrémenter les rendez-vous restants
        int rendezVousRestants = 5;
        while (rendezVousRestants > 0) {
            System.out.printf("Nombre de rendez-vous restants aujourd'hui : %d", rendezVousRestants);
            rendezVousRestants--;
            System.out.println("Un rendez-vous vient de se terminer.");
        }

        // Boucle do-while - Simulation de l'attente de nouveaux rendez-vous
        int nouveauxRendezVous = 0;
        do {
            System.out.println("En attente de nouveaux rendez-vous...");
            nouveauxRendezVous++;
            System.out.println("Nouveau rendez-vous programmé.");
        } while (nouveauxRendezVous < 3);
        System.out.printf("%d nouveaux rendez-vous ont été programmés.%n", nouveauxRendezVous);

        // Opérateur ternaire
        int ageMinimumPourTraitement = 18;
        String messagePatientEligible = "Le patient est éligible pour le traitement.";
        String messagePatientNonEligible = "Le patient n'est pas éligible pour le traitement.";
        boolean estEligiblePourTraitement = agePatient >= ageMinimumPourTraitement;
        String messageEligibilitePatient = estEligiblePourTraitement ? messagePatientEligible : messagePatientNonEligible;
        System.out.println(messageEligibilitePatient);
    }
}
