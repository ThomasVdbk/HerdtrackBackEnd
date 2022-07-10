package com.herdtrack.herdtrackbackend.service;

import com.herdtrack.herdtrackbackend.entity.Sortie;
import com.herdtrack.herdtrackbackend.repository.SortieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SortieService {

    @Autowired
    private SortieRepo sortieRepo;


    public List<Sortie> findAll() {
        return this.sortieRepo.findAll();
    }


    public Sortie findById(Long id) {
        Optional<Sortie> optEntree = this.sortieRepo.findById(id);
        if (optEntree.isPresent()) {
            return optEntree.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public List<Sortie> findByDate(Date date) {
        return this.sortieRepo.findByDate(date);
    }

    public Sortie create(Sortie newSortie) {
        return this.sortieRepo.save(newSortie);
    }

    public Sortie update(Sortie sortie) {
        if (!this.sortieRepo.existsById(sortie.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    "impossible de trouver la Sortie a mettre à jour");
        }
        return this.sortieRepo.save(sortie);
    }

    public Sortie delete(Long id) {
        if (!this.sortieRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "impossible de trouver la Sortie à supprimer");
        }
        Sortie sortieDel = this.findById(id);
        this.sortieRepo.deleteById(id);
        if (this.sortieRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                    "erreur lors de la suppression de la Sortie");
        }

        return sortieDel;
    }

}
