package com.herdtrack.herdtrackbackend.service.inter;

import com.herdtrack.herdtrackbackend.entity.StatutSante;

import java.util.List;

public interface IStatutSanteService {

    /*
    methode qui retourne la liste de l'ensemble des StatutSante
    @return StatutSante List
    @author Nicolas Desdevises
    */
    List<StatutSante> findAll();

    /*
        methode qui recupere un statutSante en fonction de son id
        @param id Long, id du statutSante recherché
        @return StatutSante
        @author Nicolas Desdevises
        */
    StatutSante findById(Long id);

    /*
        methode pour créer un statutSante.
        @param parc StatutSante, parc à enregistrer
        @return StatutSante créé
        @author Nicolas Desdevises
        */
    StatutSante create(StatutSante statutSante);

    /*
        methode pour mettre à jour un statutSante
        @param statutSante StatutSante, statutSante qui contient la mise à jour
        @return StatutSante mise à jour
        @author Nicolas Desdevises
        */
    StatutSante update(StatutSante statutSante);
}
