package com.herdtrack.herdtrackbackend.service;

import com.herdtrack.herdtrackbackend.entity.Parc;
import com.herdtrack.herdtrackbackend.repository.ParcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ParcService {

    @Autowired
    private ParcRepository parcRepository;

    /*
    methode qui retourne la liste de l'ensemble des parcs
    @return Parc List
    @author Nicolas Desdevises
    */
    public List<Parc> findAll() {

        return parcRepository.findAll();
    }

    /*
    methode qui recupere un parc en fonction de son id
    @param id Long, id du parc recherché
    @return Parc
    @author Nicolas Desdevises
    */
    public Parc findById(Long id) {

        Optional<Parc> optParc = this.parcRepository.findById(id);
        if (optParc.isPresent()) {
            return optParc.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    /*
    methode pour créer un parc
    @param parc Parc, parc à enregistrer
    @return Parc créé
    @author Nicolas Desdevises
    */
    public Parc create(Parc parc) {

        return this.parcRepository.save(parc);
    }

    /*
    methode pour mettre à jour un parc
    @param parc Parc, parc qui contient la mise à jour
    @return Parc mise à jour
    @author Nicolas Desdevises
    */
    public Parc update(Parc parc) {

        if (!this.parcRepository.existsById(parc.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    "impossible de trouver le parc a mettre à jour");
        }

        return this.parcRepository.save(parc);
    }
}
