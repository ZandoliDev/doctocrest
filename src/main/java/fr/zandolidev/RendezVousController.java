package fr.zandolidev;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rendez-vous")
public class RendezVousController {

    ServiceRendezVous serviceRendezVous = new ServiceRendezVous();

    @PostMapping
    public RendezVousMedical prendreRendezVous(@RequestBody RequetePriseDeRendezVous requete) {
        return serviceRendezVous.prendreRendezVous(requete);
    }
}