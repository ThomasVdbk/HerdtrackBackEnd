package com.herdtrack.herdtrackbackend.service;

import com.herdtrack.herdtrackbackend.entity.Traitement;

import java.util.List;

public interface ITraitementService {
    List<Traitement> findAll();

    Traitement findById(Long id);

    Traitement create(Traitement newTraitement);

    Traitement update(Traitement traitement);

    Traitement delete(Long id);
}
