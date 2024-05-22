package fr.zandolidev;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Les variables et les types de données
        // Déclarons quelques variables pour notre application DoctoCrest

        String nomPatient = "Amina Lopez";
        int agePatient = 28;
        double taillePatient = 1.70;
        var aRendezVous = true; // type déduit automatiquement : boolean
        // Les types primitifs en Java
        // int : entier
        // double : nombre à virgule flottante
        // boolean : vrai ou faux
        // byte : entier de 8 bits
        // short : entier de 16 bits
        // long : entier de 64 bits
        // float : nombre à virgule flottante de 32 bits
        // char : caractère Unicode
        // Les types de données de base en Java
        // String : chaîne de caractères
        // Integer : entier
        // Double : nombre à virgule flottante
        // Boolean : vrai ou faux
        // Byte : entier de 8 bits
        // Short : entier de 16 bits
        // Long : entier de 64 bits
        // Float : nombre à virgule flottante de 32 bits
        // Character : caractère Unicode


        // Informations sur le rendez-vous
        String nomMedecin = "Dr. Chen Wong";
        String specialite = "Cardiologue";
        int dureeRendezVous = 45; // en minutes
        double coutRendezVous = 80.0; // en euros

        // Affichage des informations du patient et du rendez-vous
        System.out.print("Bienvenue sur DoctoCrest !\n"); // \n pour un saut de ligne
        System.out.println("Patient : " + nomPatient); // println pour un saut de ligne après l'affichage
        // utilisation des String literals (ou interpolation de chaînes) - Java 15 et versions ultérieures
        System.out.printf("Âge : %d ans%n", agePatient); // %d pour un entier
        System.out.printf("Taille : %.2f mètres%n", taillePatient); // %.2f pour un nombre à virgule flottante avec 2 décimales
        String messageRendezVous = "A un rendez-vous : %s".formatted(aRendezVous); // formatted pour l'interpolation de chaînes - Java 13 et versions ultérieures
        String messageMedecin = String.format("Médecin : %s (%s)", nomMedecin, specialite); // format pour l'interpolation de chaînes - Java 5 et versions ultérieures
        System.out.println(messageRendezVous);
        System.out.println(messageMedecin);
        // utilisation des text blocks - Java 13 et versions ultérieures
        System.out.printf("""
                Durée du rendez-vous : %d minutes
                Coût du rendez-vous : %.2f euros
                """, dureeRendezVous, coutRendezVous);

        // Les opérateurs arithmétiques
        // Calculons le coût total des rendez-vous de la semaine pour Amina

        int nombreDeRendezVous = 3;
        double coutTotalAnnee = nombreDeRendezVous * coutRendezVous;
        System.out.println("Le coût total des rendez-vous cette année est de " + coutTotalAnnee + " euros.");
        // Liste des pérateurs arithmétiques
        // + : addition
        // - : soustraction
        // * : multiplication
        // / : division
        // % : modulo (reste de la division)


        // Les opérateurs de comparaison
        // Comparons l'âge du patient avec l'âge minimum pour certains traitements

        int ageMinimumPourTraitement = 18;
        boolean estEligiblePourTraitement = agePatient >= ageMinimumPourTraitement;
        System.out.println("Le patient est-il éligible pour le traitement ? " + estEligiblePourTraitement);
        // Liste des opérateurs de comparaison
        // == : égal à
        // != : différent de
        // < : inférieur à
        // > : supérieur à
        // <= : inférieur ou égal à
        // >= : supérieur ou égal à


        // Les opérateurs logiques
        // Vérifions si le patient a un rendez-vous aujourd'hui et s'il est éligible pour le traitement

        boolean aRendezVousAujourdhui = true;
        boolean aRendezVousEtEstEligible = aRendezVousAujourdhui && estEligiblePourTraitement;
        System.out.println("Le patient a-t-il un rendez-vous aujourd'hui et est-il éligible pour le traitement ? " + aRendezVousEtEstEligible);

        // Les opérateurs d'incrémentation
        // Gérons le nombre de rendez-vous restants pour aujourd'hui

        int rendezVousRestants = 5;
        System.out.println("Nombre de rendez-vous restants aujourd'hui : " + rendezVousRestants);
        rendezVousRestants--;
        System.out.println("Un rendez-vous vient de se terminer. Rendez-vous restants : " + rendezVousRestants);
        // Liste des opérateurs d'incrémentation
        // ++ : incrémentation de 1
        // -- : décrémentation de 1
        // += : incrémentation de la valeur spécifiée
        // -= : décrémentation de la valeur spécifiée
        // *= : multiplication par la valeur spécifiée
        // /= : division par la valeur spécifiée
        // %= : modulo par la valeur spécifiée
    }
}
