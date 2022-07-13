package com.herdtrack.herdtrackbackend.service;

import com.herdtrack.herdtrackbackend.entity.Vaccin;

import java.sql.Date;
import java.util.List;

public interface IVaccinService {
    List<Vaccin> findAll();

    Vaccin findById(Long id);

    List<Vaccin> findByLibelle(String libelle);

    List<Vaccin> findByNumero(String numero_lot);

    List<Vaccin> findByDateVaccination(Date dateVaccination);

    Vaccin create(Vaccin newVaccin);

    Vaccin update(Vaccin vaccin);

    Vaccin delete(Long id);
}
