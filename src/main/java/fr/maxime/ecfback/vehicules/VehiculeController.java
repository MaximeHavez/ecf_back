package fr.maxime.ecfback.vehicules;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/vehicules")
public class VehiculeController {

    private final VehiculeServiceImpl service;

    public VehiculeController(VehiculeServiceImpl service) {
        this.service = service;
    }

    /**
     * Cette fonction permet de récupérer la liste de tous les véhicules présents dans la base de données<br>
     * <b>Requête Postman en GET</b> : localhost:8080/vehicules
     *
     * @return une liste de vehicules
     */
    @GetMapping("")
    public List<Vehicule> findAll() {
        return service.findAll();
    }

    /**
     * Cette fonction permet de sauvegarder un nouveau véhicule en base de données<br>
     * <b>Requête Postman en POST</b> : localhost:8080/vehicules
     *
     * @param entity Un véhicule
     * @return Le nouveau vehicule enregistré dans la base de données
     */
    @PostMapping("")
    public Vehicule save(@RequestBody Vehicule entity) {
        return service.save(entity);
    }

    /**
     * Cette fonction permet de retrouver un véhicule en passant par son id<br>
     * <b>Requête Postman en GET</b> : localhost:8080/vehicules/<span style="color:orange">id</span>
     *
     * @param id L'id du véhicule
     * @return le véhicule recherché
     */
    @GetMapping("{id}")
    public Vehicule findById(@PathVariable String id) {
        return service.findById(id);
    }

    /**
     * Cette fonction permet de supprimer un véhicule de la base de données en passant par son id<br>
     * <b>Requête Postman en DELETE</b> : localhost:8080/vehicules/<span style="color:orange">id</span>
     *
     * @param id L'id du véhicule à supprimer
     */
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        service.deleteById(id);
    }
}
