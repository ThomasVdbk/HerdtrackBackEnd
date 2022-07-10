package com.herdtrack.herdtrackbackend.repository;

import com.herdtrack.herdtrackbackend.entity.Race;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RaceRepo extends JpaRepository<Race, Long> {

    /**
     * Trouver toutes les races dont la libelle est égale à la libelle donnée.
     *
     * @param libelle Le nom de la course
     * @return Une liste d'objets Race
     */
    List<Race> findByLibelle(String libelle);

}
