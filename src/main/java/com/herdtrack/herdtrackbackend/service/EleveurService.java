package com.herdtrack.herdtrackbackend.service;

import com.herdtrack.herdtrackbackend.entity.Eleveur;
import com.herdtrack.herdtrackbackend.repository.EleveurRepo;
import com.herdtrack.herdtrackbackend.service.inter.IEleveurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class EleveurService implements IEleveurService {

    @Autowired
    private EleveurRepo eleveurRepo;

    /*
    methode qui retourne la liste de l'ensemble des eleveurs
    @return Eleveur List
    @author Nicolas Desdevises
    */
    @Override
    public List<Eleveur> findAll() {

        return eleveurRepo.findAll();
    }

    /*
     methode qui recupere un eleveur en fonction de son id
     @param id Long, id de l'eleveur recherché
     @return Eleveur
     @author Nicolas Desdevises
     */
    @Override
    public Eleveur findById(Long id) {

        Optional<Eleveur> optEleveur = this.eleveurRepo.findById(id);
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
    @Override
    public Eleveur create(Eleveur eleveur) {

        return this.eleveurRepo.save(eleveur);
    }

    /*
    methode pour mettre à jour un éleveur
    @param eleveur Eleveur, eleveur qui contient la mise à jour
    @return Etablissement mise à jour
    @author Nicolas Desdevises
    */
    @Override
    public Eleveur update(Eleveur eleveur) {

        if (!this.eleveurRepo.existsById(eleveur.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    "impossible de trouver l'eleveur a mettre à jour");
        }

        return this.eleveurRepo.save(eleveur);
    }
}
