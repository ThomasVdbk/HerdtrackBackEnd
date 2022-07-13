package com.herdtrack.herdtrackbackend.service;

import com.herdtrack.herdtrackbackend.entity.CarnetSanitaire;

import java.util.List;

public interface ICarnetSanitaireService {
    List<CarnetSanitaire> findAll();

    CarnetSanitaire findById(Long id);

    CarnetSanitaire create(CarnetSanitaire newCarnetSanit);

    CarnetSanitaire update(CarnetSanitaire carnetSanitaire);

    CarnetSanitaire delete(Long id);
}
