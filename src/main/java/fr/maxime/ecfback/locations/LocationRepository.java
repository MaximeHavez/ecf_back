package fr.maxime.ecfback.locations;

import fr.maxime.ecfback.locataires.Locataire;
import fr.maxime.ecfback.vehicules.Vehicule;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface LocationRepository extends MongoRepository<Location, String> {

    List<Location> findAllByDateDebut(LocalDate dateDebut);
    List<Location> findAllByDateFin(LocalDate dateFin);
    List<Location> findAllByDateDebutAndDateFin(LocalDate dateDebut, String dateFin);



}
