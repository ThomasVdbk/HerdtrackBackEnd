package com.herdtrack.herdtrackbackend.service;

import com.herdtrack.herdtrackbackend.entity.Race;

import java.util.List;

public interface IRaceService {
    List<Race> findAll();

    Race findById(Long id);

    List<Race> findByLibelle(String libelle);

    Race create(Race newRace);

    Race update(Race race);

    Race delete(Long id);
}
