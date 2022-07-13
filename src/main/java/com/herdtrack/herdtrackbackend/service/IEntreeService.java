package com.herdtrack.herdtrackbackend.service;

import com.herdtrack.herdtrackbackend.entity.Entree;
import com.herdtrack.herdtrackbackend.entity.Raison;

import java.util.Date;
import java.util.List;

public interface IEntreeService {
    List<Entree> findAll();

    Entree findById(Long id);

    List<Entree> findByDate(Date date);

    List<Entree> findByRaison(Raison raison);

    Entree create(Entree newEntree);

    Entree update(Entree entree);

    Entree delete(Long id);
}
