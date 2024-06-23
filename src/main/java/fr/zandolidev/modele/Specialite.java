package fr.zandolidev.modele;

public enum Specialite {
    CARDIOLOGUE(100.0),
    DERMATOLOGUE(80.0),
    PEDIATRE(90.0),
    NEUROLOGUE(120.0),
    GYNECOLOGUE(110.0),
    GENERALISTE(60.0),
    ORTHOPEDISTE(100.0),
    ;

    private final double prix;

    Specialite(double prix) {
        this.prix = prix;
    }

    public double getPrix() {
        return prix;
    }
}