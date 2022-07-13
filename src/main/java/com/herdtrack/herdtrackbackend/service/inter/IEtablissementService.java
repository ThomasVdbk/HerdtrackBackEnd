package com.herdtrack.herdtrackbackend.service.inter;

import com.herdtrack.herdtrackbackend.entity.Etablissement;

import java.util.List;

public interface IEtablissementService {
    /*
        methode qui retourne la liste de l'ensemble des etablissements
        @return Etablissement List
        @author Nicolas Desdevises
        */
    List<Etablissement> findAll();

    /*
         methode qui recupere un etablissment en fonction de son id
         @param id Long, id de l'etablissement recherché
         @return Etablissement
         @author Nicolas Desdevises
         */
    Etablissement findById(Long id);

    /*
         methode qui recupere une liste d'etablissment en fonction de son NumeroExploitation
         @param  numeroExploitation String, numeroExploitation de l'etablissement recherché
         @return Etablissement
         @author Nicolas Desdevises
         */
    Etablissement findByNumeroExploitation(String numeroExploitation);

    /*
         methode pour créer un établissment
         @param etablissement Etablissement, etablissement à enregistrer
         @return Etablissement créé
         @author Nicolas Desdevises
         */
    Etablissement create(Etablissement etablissement);

    /*
         methode pour mettre à jour un établissment
         @param etablissement Etablissement, etablissement qui contient la mise à jour
         @return Etablissement mise à jour
         @author Nicolas Desdevises
         */
    Etablissement update(Etablissement etablissement);
}
