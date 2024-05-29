package fr.zandolidev;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class App {
    public static void main(String[] args) {

        Random random = new Random();

        Instant debut = Instant.now();

        String[] nomsPraticiens = {"Dr. Alice Martin", "Dr. Li Wei", "Dr. Maria Gonzalez", "Dr. John Smith", "Dr. Adebayo Adeyemi", "Dr. Hiroshi Yamamoto", "Dr. Elena Ivanova"};
        String[] specialitesPraticiens = {"Cardiologue", "Dermatologue", "Pédiatre", "Neurologue", "Gynécologue", "Généraliste", "Orthopédiste"};

        for(int i=0; i<1000000000; i++) {

            int indexSpecialite = random.nextInt(specialitesPraticiens.length);
            String specialite = specialitesPraticiens[indexSpecialite];

            int indexPraticien = trouverPraticienParSpecialite(specialitesPraticiens, specialite);
            String nomPraticien = nomsPraticiens[indexPraticien];
            definirCoutDuRendezVous(specialite);
        }

        Instant fin = Instant.now();
        Duration duree = Duration.between(debut, fin);
        long secondes = duree.getSeconds() % 60;
        long millis = duree.toMillis() % 1000;
        System.out.printf("Durée de l'opération : %ds %dms", secondes, millis);
    }

    private static int trouverPraticienParSpecialite(String[] specialitesPraticiens, String specialite) {
        for (int i = 0; i < specialitesPraticiens.length; i++) {
            if (specialitesPraticiens[i].equalsIgnoreCase(specialite)) {
                return i;
            }
        }
        return -1;
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

}
