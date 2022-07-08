package com.herdtrack.herdtrackbackend.repository;

import com.herdtrack.herdtrackbackend.entity.Race;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RaceRepo extends JpaRepository<Race, Long> {

    List<Race> findByLibelle(String libelle);

}
