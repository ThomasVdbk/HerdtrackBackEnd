package com.herdtrack.herdtrackbackend.service.inter;

import com.herdtrack.herdtrackbackend.entity.Parc;

import java.util.List;

public interface IParcService {
    /*
        methode qui retourne la liste de l'ensemble des parcs
        @return Parc List
        @author Nicolas Desdevises
        */
    List<Parc> findAll();

    /*
        methode qui recupere un parc en fonction de son id
        @param id Long, id du parc recherché
        @return Parc
        @author Nicolas Desdevises
        */
    Parc findById(Long id);

    /*
        methode pour créer un parc
        @param parc Parc, parc à enregistrer
        @return Parc créé
        @author Nicolas Desdevises
        */
    Parc create(Parc parc);

    /*
        methode pour mettre à jour un parc
        @param parc Parc, parc qui contient la mise à jour
        @return Parc mise à jour
        @author Nicolas Desdevises
        */
    Parc update(Parc parc);
}
