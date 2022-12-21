package fr.maxime.ecfback.locations;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/locations")
public class LocationController {

    private final LocationServiceImpl service;

    public LocationController(LocationServiceImpl service) {
        this.service = service;
    }

    /**
     * Cette fonction permet de récupérer la liste de toutes les locations présentes dans la base de données<br>
     * <b>Requête Postman en GET</b> : localhost:8080/locations
     *
     * @return une liste de locations
     */
    @GetMapping("")
    public List<Location> findAll() {
        return service.findAll();
    }

    /**
     * Cette fonction permet de sauvegarder une nouvelle location en base de données<br>
     * Elle calcule le prix total de la location grâçe à la fonction calculPrixTotal du service
     * et enregistre le résultat dans l'objet Location
     * <b>Requête Postman en POST</b> : localhost:8080/locations
     *
     * @param entity Une location
     * @return La nouvelle location enregistrée dans la base de données
     */
    @PostMapping("")
    public Location save(@RequestBody Location entity) {
        String idVehicule = entity.getVehicule().getId();
        String idLocation = entity.getId();
        LocalDate dateDebut = entity.getDateDebut();
        LocalDate dateFin = entity.getDateFin();
        Double prixTotal = service.calculPrixTotal(idVehicule, idLocation, dateDebut, dateFin);
        entity.setPrixTotal(prixTotal);

        return service.save(entity);
    }

    /**
     * Cette fonction permet de retrouver une location en passant par son id<br>
     * <b>Requête Postman en GET</b> : localhost:8080/locations/<span style="color:orange">id</span>
     *
     * @param id L'id de la location
     * @return la location recherchée
     */
    @GetMapping("{id}")
    public Location findById(@PathVariable String id) {
        return service.findById(id);
    }

    /**
     * Cette fonction permet de supprimer une location de la base de données en passant par son id<br>
     * <b>Requête Postman en DELETE</b> : localhost:8080/vehicules/<span style="color:orange">id</span>
     *
     * @param id L'id de la location à supprimer
     */
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        service.deleteById(id);
    }


}
