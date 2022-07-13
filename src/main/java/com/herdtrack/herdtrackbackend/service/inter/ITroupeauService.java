package com.herdtrack.herdtrackbackend.service.inter;

import com.herdtrack.herdtrackbackend.entity.Troupeau;

import java.util.List;

public interface ITroupeauService {
    /*
        methode qui retourne la liste de l'ensemble des troupeaus
        @return Troupeau List
        @author Nicolas Desdevises
        */
    List<Troupeau> findAll();

    /*
        methode qui recupere un troupeau en fonction de son id
        @param id Long, id du troupeau recherché
        @return Troupeau
        @author Nicolas Desdevises
        */
    Troupeau findById(Long id);

    /*
        methode pour créer un troupeau.
        @param parc Troupeau, parc à enregistrer
        @return Troupeau créé
        @author Nicolas Desdevises
        */
    Troupeau create(Troupeau troupeau);

    /*
        methode pour mettre à jour un troupeau
        @param troupeau Troupeau, troupeau qui contient la mise à jour
        @return Troupeau mise à jour
        @author Nicolas Desdevises
        */
    Troupeau update(Troupeau troupeau);
}
