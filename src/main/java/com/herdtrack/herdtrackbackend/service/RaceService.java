package com.herdtrack.herdtrackbackend.service;

import com.herdtrack.herdtrackbackend.entity.Race;
import com.herdtrack.herdtrackbackend.entity.Vaccin;
import com.herdtrack.herdtrackbackend.repository.RaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RaceService {

    @Autowired
    private RaceRepo raceRepo;

    public List<Race> findAll(){
        return this.raceRepo.findAll();
    }
    public Race findById(Long id) {
        Optional<Race> optRace = this.raceRepo.findById(id);
        if (optRace.isPresent()) {
            return optRace.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
public List<Race> findByLibelle(String libelle) {
    return this.raceRepo.findByLibelle(libelle);
}
    public Race create(Race newRace) {
        return this.raceRepo.save(newRace);
    }

    public Race update(Race race) {
        if (! this.raceRepo.existsById(race.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    "impossible de trouver le contact a mettre à jour");
        }
        return this.raceRepo.save(race);
    }

    public Race delete (Long id) {
        if (! this.raceRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "impossible de trouver le contact à supprimer");
        }
        Race raceDel = this.findById(id);
        this.raceRepo.deleteById(id);
        if (this.raceRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                    "erreur lors de la suppression du contact");
        }

        return raceDel;
    }



}
