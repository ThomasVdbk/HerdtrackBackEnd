package com.herdtrack.herdtrackbackend.service;

import com.herdtrack.herdtrackbackend.entity.Eleveur;

import java.util.List;

public interface IEleveurService {
    /*
        methode qui retourne la liste de l'ensemble des eleveurs
        @return Eleveur List
        @author Nicolas Desdevises
        */
    List<Eleveur> findAll();

    /*
         methode qui recupere un eleveur en fonction de son id
         @param id Long, id de l'eleveur recherché
         @return Eleveur
         @author Nicolas Desdevises
         */
    Eleveur findById(Long id);

    /*
        methode pour créer un éleveur
        @param eleveur Eleveur, eleveur à enregistrer
        @return Etablissement créé
        @author Nicolas Desdevises
        */
    Eleveur create(Eleveur eleveur);

    /*
        methode pour mettre à jour un éleveur
        @param eleveur Eleveur, eleveur qui contient la mise à jour
        @return Etablissement mise à jour
        @author Nicolas Desdevises
        */
    Eleveur update(Eleveur eleveur);
}
