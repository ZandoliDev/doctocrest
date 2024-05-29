package fr.zandolidev;

import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.Random;

public class App {
    public static void main(String[] args) {

        Random random = new Random();

        Instant debut = Instant.now();

        Map<String, String> mapNomPraticienParSpecialite = Map.of(
                "Cardiologue", "Dr. Alice Martin",
                "Dermatologue", "Dr. Li Wei",
                "Pédiatre", "Dr. Maria Gonzalez",
                "Neurologue", "Dr. John Smith",
                "Gynécologue", "Dr. Adebayo Adeyemi",
                "Généraliste", "Dr. Hiroshi Yamamoto",
                "Orthopédiste", "Dr. Elena Ivanova"
        );
        String[] specialitesPraticiens = {"Cardiologue", "Dermatologue", "Pédiatre", "Neurologue", "Gynécologue", "Généraliste", "Orthopédiste"};

        for(int i=0; i<1000000000; i++) {

            int indexSpecialite = random.nextInt(specialitesPraticiens.length);
            String specialite = specialitesPraticiens[indexSpecialite];

            String nomPraticien = mapNomPraticienParSpecialite.get(specialite);
            definirCoutDuRendezVous(specialite);
        }

        Instant fin = Instant.now();
        Duration duree = Duration.between(debut, fin);
        long secondes = duree.getSeconds() % 60;
        long millis = duree.toMillis() % 1000;
        System.out.printf("Durée de l'opération : %ds %dms", secondes, millis);
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
