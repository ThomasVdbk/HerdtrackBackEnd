package com.herdtrack.herdtrackbackend.repository;

import com.herdtrack.herdtrackbackend.entity.Vaccin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.sql.Date;
import java.util.List;

public interface VaccinRepo extends JpaRepository<Vaccin, Long> {

    /**
     * Trouver tous les objets Vaccin dont le champ libelle est égal au paramètre libelle donné.
     *
     * @param libelle le nom du champ à rechercher
     * @return Une liste d'objets Vaccin
     */
    List<Vaccin> findByLibelle(String libelle);

    /**
     * > Trouver tous les vaccins avec le numéro de lot donné
     *
     * @param "numero_lot" le numéro de lot du vaccin
     * @return Une liste d'objets Vaccin
     */


    @Query("select v from Vaccin v where v.numeroLot = :numeroLot")
    List<Vaccin> findByNumeroLot (String numeroLot);

    /**
     * Trouvez tous les vaccins qui ont été administrés à une date précise.
     *
     * @param "date_vaccination" la date du vaccin
     * @return Une liste d'objets Vaccin
     */

    @Query("select v from Vaccin v where v.date_vaccination=:date_vaccination")
  List<Vaccin> findByDate_vaccination (Date date_vaccination);



}
