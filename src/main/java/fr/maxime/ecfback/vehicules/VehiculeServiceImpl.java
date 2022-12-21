package fr.maxime.ecfback.vehicules;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculeServiceImpl implements VehiculeService {

    private final VehiculeRepository repository;

    public VehiculeServiceImpl(VehiculeRepository repository) {
        this.repository = repository;
    }

    /**
     * Cette fonction permet de récupérer la liste de tous les véhicules présents dans la base de données<br>
     * <b>Requête Postman en GET</b> : localhost:8080/vehicules
     * @return une liste de vehicules
     */
    @Override
    public List<Vehicule> findAll() {
        return repository.findAll();
    }

    /**
     * Cette fonction permet de sauvegarder un nouveau véhicule en base de données<br>
     * <b>Requête Postman en POST</b> : localhost:8080/vehicules
     * @param entity Un véhicule
     * @return Le nouveau vehicule enregistré dans la base de données
     */
    @Override
    public Vehicule save(Vehicule entity) {
        return repository.save(entity);
    }

    /**
     * Cette fonction permet de retrouver un véhicule en passant par son id<br>
     * <b>Requête Postman en GET</b> : localhost:8080/vehicules/<span style="color:orange">id</span>
     * @param id L'id du véhicule
     * @return le véhicule recherché
     */
    @Override
    public Vehicule findById(String id) {
        return repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    /**
     * Cette fonction permet de supprimer un véhicule de la base de données en passant par son id<br>
     * <b>Requête Postman en DELETE</b> : localhost:8080/vehicules/<span style="color:orange">id</span>
     * @param id L'id du véhicule à supprimer
     */
    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    /**
     * Cette fonction permet de retrouver un véhicule grâce à sa marque
     * @param marque
     * @return
     */
    public List<Vehicule> findAllByMarque(String marque) {
        return repository.findAllByMarque(marque);
    }

    public List<Vehicule> findAllByModele(String modele) {
        return repository.findAllByModele(modele);
    }

    public List<Vehicule> findAllByMarqueAndModele(String marque, String modele) {
        return repository.findAllByMarqueAndModele(marque, modele);
    }

    public List<Vehicule> findAllByType(String type) {
        return repository.findAllByType(type);
    }

    public List<Vehicule> findByImmatriculation(String immatriculation) {
        return repository.findByImmatriculation(immatriculation);
    }

    public List<Vehicule> findAllByEtat(String etat) {
        return repository.findAllByEtat(etat);
    }

    public List<Vehicule> findAllByPrix(String prix) {
        return repository.findAllByPrix(prix);
    }

    public List<Vehicule> findAllByStatus(String status) {
        return repository.findAllByStatus(status);
    }
}
