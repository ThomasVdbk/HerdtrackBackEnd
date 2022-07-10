package com.herdtrack.herdtrackbackend.service;


import com.herdtrack.herdtrackbackend.entity.Entree;

import com.herdtrack.herdtrackbackend.repository.EntreeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EntreeService {

    @Autowired
    private EntreeRepo entreeRepo;


    public List<Entree> findAll() {
        return this.entreeRepo.findAll();
    }


    public Entree findById(Long id) {
        Optional<Entree> optEntree = this.entreeRepo.findById(id);
        if (optEntree.isPresent()) {
            return optEntree.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public List<Entree> findByDate(Date date) {
        return this.entreeRepo.findByDate(date);
    }

    public Entree create(Entree newEntree) {
        return this.entreeRepo.save(newEntree);
    }

    public Entree update(Entree entree) {
        if (!this.entreeRepo.existsById(entree.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    "impossible de trouver l'Entree a mettre à jour");
        }
        return this.entreeRepo.save(entree);
    }

    public Entree delete(Long id) {
        if (!this.entreeRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "impossible de trouver l'Entree à supprimer");
        }
        Entree entreeDel = this.findById(id);
        this.entreeRepo.deleteById(id);
        if (this.entreeRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                    "erreur lors de la suppression de l'Entree");
        }

        return entreeDel;
    }
}
