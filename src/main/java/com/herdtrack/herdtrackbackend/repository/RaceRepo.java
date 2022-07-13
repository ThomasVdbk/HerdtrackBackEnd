package com.herdtrack.herdtrackbackend.repository;

import com.herdtrack.herdtrackbackend.entity.Espece;
import com.herdtrack.herdtrackbackend.entity.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface RaceRepo extends JpaRepository<Race, Long> {

    /**
     * Trouver toutes les races dont la libelle est égale à la libelle donnée.
     *
     * @param libelle Le nom de la race
     * @return Une liste d'objets Race
     */
    List<Race> findByLibelle(String libelle);



}
