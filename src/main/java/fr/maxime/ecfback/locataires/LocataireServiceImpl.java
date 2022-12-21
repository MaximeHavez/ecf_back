package fr.maxime.ecfback.locataires;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class LocataireServiceImpl implements LocataireService {

    private final LocataireRepository repository;

    public LocataireServiceImpl(LocataireRepository repository) {
        this.repository = repository;
    }

    /**
     * Cette fonction permet de récupérer la liste de tous les locataires présents dans la base de données<br>
     * <b>Requête Postman en GET</b> : localhost:8080/locataires
     * @return une liste de locataires
     */
    @Override
    public List<Locataire> findAll() {
        return repository.findAll();
    }

    /**
     * Cette fonction permet de sauvegarder un nouveau locataire en base de données<br>
     * <b>Requête Postman en POST</b> : localhost:8080/locataires
     * @param entity Un locataire
     * @return Le nouveau locataire enregistré dans la base de données
     */
    @Override
    public Locataire save(Locataire entity) {
        return repository.save(entity);
    }

    /**
     * Cette fonction permet de retrouver un locataire en passant par son id<br>
     * <b>Requête Postman en GET</b> : localhost:8080/locataires/<span style="color:orange">id</span>
     * @param id L'id du locataire
     * @return le locataire recherché
     */
    @Override
    public Locataire findById(String id) {
        return repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    /**
     * Cette fonction permet de supprimer un locataire de la base de données en passant par son id<br>
     * <b>Requête Postman en DELETE</b> : localhost:8080/locataires/<span style="color:orange">id</span>
     * @param id L'id du locataire à supprimer
     */
    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    /**
     * Cette fonction permet de retrouver un locataire grâce à son nom de famille
     * <b>Requête Postman en GET</b> : localhost:8080/locataires/findby?nom=<span style="color:orange">nom</span>
     * @param nom Le nom de famille du locataire
     * @return Une liste de locataire
     */
    public List<Locataire> findAllByNom(String nom) {
        return repository.findAllByNom(nom);
    }

    /**
     * Cette fonction permet de retrouver un locataire grâce à son prénom
     * <b>Requête Postman en GET</b> : localhost:8080/locataires/findby?prenom=<span style="color:orange">prenom</span>
     * @param prenom Le prénom du locataire
     * @return Une liste de locataires
     */
    public List<Locataire> findAllByPrenom(String prenom) {
        return repository.findAllByPrenom(prenom);
    }

    /**
     * Cette fonction permet de retrouver un locataire grâce à son nom de famille et son prénom
     * <b>Requête Postman en GET</b> : localhost:8080/locataires/findby?nom=<span style="color:orange">nom</span>&prenom=<span style="color:orange">prenom</span>
     * @param nom Le nom de famille du locataire
     * @param prenom Le prénom du locataire
     * @return Une liste de locataire
     */
    public List<Locataire> findAllByNomAndPrenom(String nom, String prenom) {
        return repository.findAllByNomAndPrenom(nom, prenom);
    }

    /**
     * Cette fonction permet de retrouver un locataire grâce à son email
     * <b>Requête Postman en GET</b> : localhost:8080/locataires/findby?email=<span style="color:orange">email</span>
     * @param email L'email du locataire
     * @return Le locataire recherché
     */
    public List<Locataire> findByEmail(String email) {
        return repository.findByEmail(email);
    }
}