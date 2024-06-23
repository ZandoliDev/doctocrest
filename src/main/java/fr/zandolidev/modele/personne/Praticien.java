package fr.zandolidev.modele.personne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.zandolidev.modele.Specialite;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Praticien extends Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private final Specialite specialite;

    public Praticien(String nom, Specialite specialite) {
        super(nom);
        this.specialite = specialite;
    }

    @JsonIgnore
    public double getPrix() {
        return this.specialite.getPrix();
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public boolean exerceSpecialite(Specialite specialiteChoisie) {
        return specialiteChoisie == this.specialite;
    }

}
