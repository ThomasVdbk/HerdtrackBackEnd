package com.herdtrack.herdtrackbackend.repository;

import com.herdtrack.herdtrackbackend.entity.Vaccin;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Date;
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

    List<Vaccin> findByNumero (String numero_lot);

    /**
     * Trouvez tous les vaccins qui ont été administrés à une date précise.
     *
     * @param "date" la date du vaccin
     * @return Une liste d'objets Vaccin
     */

    List<Vaccin> findByDate (Date date);

    /**
     * > Retrouvez tous les vaccins dus dans les nbrJoursProchain jours à venir
     *
     * @param nbrJoursProchain le nombre de jours avant la prochaine vaccination
     * @return Une liste d'objets Vaccin
     */
    List<Vaccin> findByJours (int nbrJoursProchain);

}
