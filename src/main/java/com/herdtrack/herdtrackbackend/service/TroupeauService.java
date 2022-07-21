package com.herdtrack.herdtrackbackend.service;

import com.herdtrack.herdtrackbackend.entity.Troupeau;
import com.herdtrack.herdtrackbackend.repository.TroupeauRepo;
import com.herdtrack.herdtrackbackend.service.inter.ITroupeauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TroupeauService implements ITroupeauService {

    @Autowired
    private TroupeauRepo troupeauRepo;

    /*
    methode qui retourne la liste de l'ensemble des troupeaus
    @return Troupeau List
    @author Nicolas Desdevises
    */
    @Override
    public List<Troupeau> findAll() {

        return troupeauRepo.findAll();
    }

    /*
    methode qui recupere un troupeau en fonction de son id
    @param id Long, id du troupeau recherché
    @return Troupeau
    @author Nicolas Desdevises
    */
    @Override
    public Troupeau findById(Long id) {

        Optional<Troupeau> optTroupeau = this.troupeauRepo.findById(id);
        if (optTroupeau.isPresent()) {
            return optTroupeau.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    /*
    methode pour créer un troupeau.
    @param parc Troupeau, parc à enregistrer
    @return Troupeau créé
    @author Nicolas Desdevises
    */
    @Override
    public Troupeau create(Troupeau troupeau) {

        return this.troupeauRepo.save(troupeau);
    }

    /*
    methode pour mettre à jour un troupeau
    @param troupeau Troupeau, troupeau qui contient la mise à jour
    @return Troupeau mise à jour
    @author Nicolas Desdevises
    */
    @Override
    public Troupeau update(Troupeau troupeau) {

        if (!this.troupeauRepo.existsById(troupeau.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    "impossible de trouver le troupeau à mettre à jour");
        }

        return this.troupeauRepo.save(troupeau);
    }
}
