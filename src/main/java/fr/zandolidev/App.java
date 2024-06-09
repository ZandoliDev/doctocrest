package fr.zandolidev;

import java.time.Duration;
import java.time.Instant;
import java.util.EnumMap;
import java.util.Random;

public class App {

    enum Praticien {
        CARDIOLOGUE,
        DERMATOLOGUE,
        PEDIATRE,
        NEUROLOGUE,
        GYNECOLOGUE,
        GENERALISTE,
        ORTHOPEDISTE,
        ;

    }

    public static void main(String[] args) {

        EnumMap<Praticien, String> mapNomsPraticiens = new EnumMap<>(Praticien.class);
        mapNomsPraticiens.put(Praticien.CARDIOLOGUE, "Dr. Alice Martin");
        mapNomsPraticiens.put(Praticien.DERMATOLOGUE, "Dr. Li Wei");
        mapNomsPraticiens.put(Praticien.PEDIATRE, "Dr. Maria Gonzalez");
        mapNomsPraticiens.put(Praticien.NEUROLOGUE, "Dr. John Smith");
        mapNomsPraticiens.put(Praticien.GYNECOLOGUE, "Dr. Adebayo Adeyemi");
        mapNomsPraticiens.put(Praticien.GENERALISTE, "Dr. Hiroshi Yamamoto");
        mapNomsPraticiens.put(Praticien.ORTHOPEDISTE, "Dr. Elena Ivanova");

        EnumMap<Praticien, Double> mapCoutsRendezVous = new EnumMap<>(Praticien.class);
        mapCoutsRendezVous.put(Praticien.CARDIOLOGUE, 100.0);
        mapCoutsRendezVous.put(Praticien.DERMATOLOGUE, 80.0);
        mapCoutsRendezVous.put(Praticien.PEDIATRE, 90.0);
        mapCoutsRendezVous.put(Praticien.NEUROLOGUE, 120.0);
        mapCoutsRendezVous.put(Praticien.GYNECOLOGUE, 110.0);
        mapCoutsRendezVous.put(Praticien.GENERALISTE, 60.0);
        mapCoutsRendezVous.put(Praticien.ORTHOPEDISTE, 100.0);


        Random random = new Random();

        Instant debut = Instant.now();

        for(int i=0; i<1000000000; i++) {

            Praticien[] praticiens = Praticien.values();
            int indexSpecialite = random.nextInt(praticiens.length);
            Praticien specialite = praticiens[indexSpecialite];

            mapNomsPraticiens.get(specialite);
            mapCoutsRendezVous.get(specialite);
        }

        Instant fin = Instant.now();
        Duration duree = Duration.between(debut, fin);
        long secondes = duree.getSeconds() % 60;
        long millis = duree.toMillis() % 1000;
        System.out.printf("Durée de l'opération : %ds %dms", secondes, millis);
    }

}
