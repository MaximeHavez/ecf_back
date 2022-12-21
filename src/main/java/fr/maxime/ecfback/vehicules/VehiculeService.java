package fr.maxime.ecfback.vehicules;

import java.util.List;

public interface VehiculeService {
    List<Vehicule> findAll();

    Vehicule save(Vehicule entity);

    Vehicule findById(String id);

    void deleteById(String id);
}
