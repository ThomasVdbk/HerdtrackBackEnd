package com.herdtrack.herdtrackbackend.service.inter;

import com.herdtrack.herdtrackbackend.entity.Animal;

import java.util.List;

public interface IAnimalService {
    List<Animal> findAll();

    Animal findById(Long id);

    List<Animal> findByReference(String reference);

    List<Animal> findByNom(String nom);

    Animal create(Animal newAdresse);

    Animal update(Animal animal);

    Animal delete(Long id);
}
