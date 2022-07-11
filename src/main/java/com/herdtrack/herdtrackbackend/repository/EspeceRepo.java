package com.herdtrack.herdtrackbackend.repository;

import com.herdtrack.herdtrackbackend.entity.Espece;
import com.herdtrack.herdtrackbackend.entity.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EspeceRepo extends JpaRepository<Espece, Long> {

    /**
     * Trouver toutes les entités Espece où le champ libelle est égal à la libelle donnée.
     *
     * @param libelle le nom du champ dans l'entité
     * @return Une liste d'objets Espece.
     */
    List<Espece> findByLibelle(String libelle);


}
