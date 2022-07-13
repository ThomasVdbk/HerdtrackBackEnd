package com.herdtrack.herdtrackbackend.service;

import com.herdtrack.herdtrackbackend.entity.Espece;
import com.herdtrack.herdtrackbackend.entity.Race;

import java.util.List;

public interface IEspeceService {
    // Une méthode qui est utilisée pour trouver toutes les espèces dans la base de données.
    List<Espece> findAll();

    Espece findById(Long id);

    List<Espece> findByLibelle(String libelle);

    Espece create(Espece newEspece);

    Espece update(Espece espece);

    Espece delete(Long id);

    List<Race> findEspeceById(Long id);
}
