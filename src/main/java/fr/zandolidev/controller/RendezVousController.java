package fr.zandolidev.controller;

import fr.zandolidev.modele.RendezVousMedical;
import fr.zandolidev.modele.Secretariat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rendez-vous")
public class RendezVousController {

    private final Secretariat secretariat;

    public RendezVousController(Secretariat secretariat) {
        this.secretariat = secretariat;
    }

    @PostMapping
    public RendezVousMedical prendreRendezVous(@RequestBody RequetePriseDeRendezVous requete) {
        return secretariat.prendreRendezVous(requete);
    }
}