package fr.maxime.ecfback.locations;

import fr.maxime.ecfback.locataires.Locataire;
import fr.maxime.ecfback.vehicules.Vehicule;
import fr.maxime.ecfback.vehicules.VehiculeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    Logger logger = LoggerFactory.getLogger(LocationServiceImpl.class);

    private final LocationRepository repository;
    private final VehiculeServiceImpl vehiculeService;

    public LocationServiceImpl(LocationRepository repository, VehiculeServiceImpl vehiculeService) {
        this.repository = repository;
        this.vehiculeService = vehiculeService;
    }

    /**
     * Cette fonction permet de récupérer la liste de toutes les locations présentes dans la base de données<br>
     * <b>Requête Postman en GET</b> : localhost:8080/locations
     * @return une liste de locations
     */
    @Override
    public List<Location> findAll() {
        return repository.findAll();
    }

    /**
     * Cette fonction permet de sauvegarder une nouvelle location en base de données<br>
     * <b>Requête Postman en POST</b> : localhost:8080/locations
     * @param entity Une location
     * @return La nouvelle location enregistrée dans la base de données
     */
    @Override
    public Location save(Location entity) {
        return repository.save(entity);
    }

    /**
     * Cette fonction permet de retrouver une location en passant par son id<br>
     * <b>Requête Postman en GET</b> : localhost:8080/locations/<span style="color:orange">id</span>
     * @param id L'id de la location
     * @return la location recherchée
     */
    @Override
    public Location findById(String id) {
        return repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    /**
     * Cette fonction permet de supprimer une location de la base de données en passant par son id<br>
     * <b>Requête Postman en DELETE</b> : localhost:8080/vehicules/<span style="color:orange">id</span>
     * @param id L'id de la location à supprimer
     */
    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    /**
     * Cette fonction permet de retrouver une location en fonction de sa date de début de location<br>
     * <b>Requête Postman en GET</b> : localhost:8080/locations/datedebut?dateDebut=<span style="color:orange">dateDebut</span>
     * @param dateDebut La date de début de location (Format : "YYYY-MM-DD")
     * @return Une liste de locations
     */
    public List<Location> findAllByDateDebut(LocalDate dateDebut) {
        return repository.findAllByDateDebut(dateDebut);
    }

    /**
     * Cette fonction permet de retrouver une location en fonction de sa date de fin de location<br>
     * <b>Requête Postman en GET</b> : localhost:8080/locations/datefin?dateFin=<span style="color:orange">dateFin</span>
     * @param dateFin La date de fin de location (Format : "YYYY-MM-DD")
     * @return Une liste de locations
     */
    public List<Location> findAllByDateFin(LocalDate dateFin) {
        return repository.findAllByDateFin(dateFin);
    }

    /**
     * Cette fonction permet de retrouver une location en fonction de sa date de début et de fin de location
     * <b>Requête Postman en GET</b> : localhost:8080/locations/datedebut&fin?dateDebut=<span style="color:orange">dateDebut</span>&dateFin=<span style="color:orange">dateFin</span>
     * @param dateDebut La date de début de location (Format : "YYYY-MM-DD")
     * @param dateFin La date de fin de location (Format : "YYYY-MM-DD")
     * @return Une liste de locations
     */
    public List<Location> findAllByDateDebutAndDateFin(LocalDate dateDebut, String dateFin) {
        return repository.findAllByDateDebutAndDateFin(dateDebut, dateFin);
    }

    /**
     * Cette fonction permet de retrouver une location en fonction de son locataire
     * @param locataire Le locataire
     * @return Une liste de Locations
     */
    public List<Location> findAllByLocataire(Locataire locataire) {
        return repository.findAllByLocataire(locataire);
    }

    /**
     * Cette fonction permet de retrouver une location en fonction de son véhicule
     * @param vehicule Le vehicule
     * @return Une liste de locations
     */
    public List<Location> findAllByVehicule(Vehicule vehicule) {
        return repository.findAllByVehicule(vehicule);
    }

    /**
     * Cette fonction permet de calculer le prix total de la location en fonction du prix à la journée du véhicule
     * et de la durée de la location, calculée en comparant la date de début et de fin de la location.
     * @param idVoiture L'id du véhicule
     * @param idLocation L'id de la location
     * @param dateDebut La date de début de la location (Format : "YYYY-MM-DD")
     * @param dateFin La date de fin de la location (Format : "YYYY-MM-DD")
     * @return Le prix total de la location
     */
    @Override
    public Double calculPrixTotal(String idVoiture, String idLocation, LocalDate dateDebut, LocalDate dateFin) {
        Double prixUnitaire = this.vehiculeService.findById(idVoiture).getPrix();
        Long duration = ChronoUnit.DAYS.between(dateDebut, dateFin);
        Double prixTotal = prixUnitaire*duration;
        logger.info("Prix Total : " + prixTotal);
        return prixTotal;
    }




}
