package com.herdtrack.herdtrackbackend.service;

import com.herdtrack.herdtrackbackend.entity.Etablissement;
import com.herdtrack.herdtrackbackend.repository.EtablissementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class EtablissementService {

    @Autowired
    private EtablissementRepository etablissementRepository;

    /*
    methode qui retourne la liste de l'ensemble des etablissements
    @return Etablissement List
    @author Nicolas Desdevises
    */
    public List<Etablissement> findAll() {

        return etablissementRepository.findAll();
    }

    /*
     methode qui recupere un etablissment en fonction de son id
     @param id Long, id de l'etablissement recherché
     @return Etablissement
     @author Nicolas Desdevises
     */
    public Etablissement findById(Long id) {

        Optional<Etablissement> optEtablissement = this.etablissementRepository.findById(id);
        if (optEtablissement.isPresent()) {
            return optEtablissement.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    /*
     methode qui recupere une liste d'etablissment en fonction de son NumeroExploitation
     @param  numeroExploitation String, numeroExploitation de l'etablissement recherché
     @return Etablissement
     @author Nicolas Desdevises
     */
    public Etablissement findByNumeroExploitation(String numeroExploitation) {

        return etablissementRepository.findByNumeroExploitation(numeroExploitation);

    }

    /*
     methode pour créer un établissment
     @param etablissement Etablissement, etablissement à enregistrer
     @return Etablissement créé
     @author Nicolas Desdevises
     */
    public Etablissement create(Etablissement etablissement) {

        return this.etablissementRepository.save(etablissement);
    }

    /*
     methode pour mettre à jour un établissment
     @param etablissement Etablissement, etablissement qui contient la mise à jour
     @return Etablissement mise à jour
     @author Nicolas Desdevises
     */
    public Etablissement update(Etablissement etablissement) {

        if (!this.etablissementRepository.existsById(etablissement.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    "impossible de trouver l'etablissement' a mettre à jour");
        }

        return this.etablissementRepository.save(etablissement);
    }
}
