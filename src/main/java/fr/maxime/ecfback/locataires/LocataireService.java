package fr.maxime.ecfback.locataires;

import java.util.List;

public interface LocataireService {
    List<Locataire> findAll();

    Locataire save(Locataire entity);

    Locataire findById(String id);

    Locataire update(String id, Locataire locataire);

    void deleteById(String id);


}
