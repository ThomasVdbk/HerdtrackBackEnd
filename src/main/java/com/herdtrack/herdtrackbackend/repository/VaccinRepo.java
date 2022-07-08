package com.herdtrack.herdtrackbackend.repository;

import com.herdtrack.herdtrackbackend.entity.Vaccin;
import org.springframework.data.jpa.repository.JpaRepository;


import java.sql.Date;
import java.util.List;

public interface VaccinRepo extends JpaRepository<Vaccin, Long> {

    List<Vaccin> findByLibelle(String libelle);

    List<Vaccin> findByNumero (String numero_lot);

    List<Vaccin> findByDate (Date date);

    List<Vaccin> findByJours (int nbrJoursProchain);

}
