package com.herdtrack.herdtrackbackend.service;

import com.herdtrack.herdtrackbackend.entity.Animal;
import com.herdtrack.herdtrackbackend.repository.AnimalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepo animalRepo;

    public List<Animal> findAll() {
        return this.animalRepo.findAll();
    }

    public Animal findById(Long id) {
        Optional<Animal> optAnimal = this.animalRepo.findById(id);
        if (optAnimal.isPresent()) {
            return optAnimal.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public List<Animal> findByReference(String reference) {
        return this.animalRepo.findByReference(reference);
    }
    public List<Animal> findByNom(String nom) {
        return this.animalRepo.findByNom(nom);
    }

    public Animal create(Animal newAdresse) {
        return this.animalRepo.save(newAdresse);
    }

    public Animal update(Animal animal) {
        if (!this.animalRepo.existsById(animal.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    "impossible de trouver l'animal a mettre à jour");
        }
        return this.animalRepo.save(animal);
    }

    public Animal delete(Long id) {
        if (!this.animalRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "impossible de trouver l'animal à supprimer");
        }
        Animal animalDel = this.findById(id);
        this.animalRepo.deleteById(id);
        if (this.animalRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                    "erreur lors de la suppression de l'animal");
        }

        return animalDel;
    }

}
