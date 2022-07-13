package com.herdtrack.herdtrackbackend.service;

import com.herdtrack.herdtrackbackend.entity.Traitement;
import com.herdtrack.herdtrackbackend.repository.TraitementRepo;
import com.herdtrack.herdtrackbackend.service.inter.ITraitementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TraitementService implements ITraitementService {
    @Autowired
    private TraitementRepo traitementRepo;

    @Override
    public List<Traitement> findAll() {
        return this.traitementRepo.findAll();
    }


    @Override
    public Traitement findById(Long id) {
        Optional<Traitement> optTraitement = this.traitementRepo.findById(id);
        if (optTraitement.isPresent()) {
            return optTraitement.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Traitement create(Traitement newTraitement) {
        return this.traitementRepo.save(newTraitement);
    }


    @Override
    public Traitement update(Traitement traitement) {
        if (! this.traitementRepo.existsById(traitement.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    "impossible de trouver le traitement à mettre à jour");
        }
        return this.traitementRepo.save(traitement);
    }

    @Override
    public Traitement delete(Long id) {
        if (! this.traitementRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "impossible de trouver le traitement à supprimer");
        }
        Traitement traitementDel = this.findById(id);
        this.traitementRepo.deleteById(id);
        if (this.traitementRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                    "erreur lors de la suppression du traitement");
        }

        return traitementDel;

    }
}

