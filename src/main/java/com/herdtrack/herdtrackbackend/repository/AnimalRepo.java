package com.herdtrack.herdtrackbackend.repository;

import com.herdtrack.herdtrackbackend.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AnimalRepo extends JpaRepository<Animal, Long> {


    Optional<Animal> findById(Long id);

    List<Animal> findByReference(String reference);

    List<Animal> findByNom(String nom);

}
