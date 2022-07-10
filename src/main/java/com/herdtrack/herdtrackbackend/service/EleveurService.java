package com.herdtrack.herdtrackbackend.service;

import com.herdtrack.herdtrackbackend.entity.Eleveur;
import com.herdtrack.herdtrackbackend.entity.Etablissement;
import com.herdtrack.herdtrackbackend.repository.EleveurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class EleveurService {

    @Autowired
    private EleveurRepository eleveurRepository;

    /*
    methode qui retourne la liste de l'ensemble des eleveurs
    @return Eleveur List
    @author Nicolas Desdevises
    */
    public List<Eleveur> findAll() {

        return eleveurRepository.findAll();
    }

    /*
     methode qui recupere un eleveur en fonction de son id
     @param id Long, id de l'eleveur recherché
     @return Eleveur
     @author Nicolas Desdevises
     */
    public Eleveur findById(Long id) {

        Optional<Eleveur> optEleveur = this.eleveurRepository.findById(id);
        if (optEleveur.isPresent()) {
            return optEleveur.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    /*
    methode pour créer un éleveur
    @param eleveur Eleveur, eleveur à enregistrer
    @return Etablissement créé
    @author Nicolas Desdevises
    */
    public Eleveur create(Eleveur eleveur) {

        return this.eleveurRepository.save(eleveur);
    }

    /*
    methode pour mettre à jour un éleveur
    @param eleveur Eleveur, eleveur qui contient la mise à jour
    @return Etablissement mise à jour
    @author Nicolas Desdevises
    */
    public Eleveur update(Eleveur eleveur) {

        if (!this.eleveurRepository.existsById(eleveur.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    "impossible de trouver l'eleveur a mettre à jour");
        }

        return this.eleveurRepository.save(eleveur);
    }
}
