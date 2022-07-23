package com.herdtrack.herdtrackbackend.controller;

import com.herdtrack.herdtrackbackend.entity.Animal;
import com.herdtrack.herdtrackbackend.service.inter.IAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    private IAnimalService animalService;

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Animal> findAll() {
        return this.animalService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Animal findById(@PathVariable Long id) {
        return this.animalService.findById(id);
    }

    @GetMapping("/reference/{reference}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Animal> findByReference(@PathVariable String reference) {
        return this.animalService.findByReference(reference);
    }

    @GetMapping("/nom/{nom}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Animal> findByNom(@PathVariable String nom) {
        return this.animalService.findByNom(nom);
    }


    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Animal create(@RequestBody Animal newAnimal) {

        return this.animalService.create(newAnimal);
    }

    @PostMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Animal update(@RequestBody Animal animal, @PathVariable Long id) {
        if (!id.equals((animal.getId()))) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Mauvais Animal à update");
        }
        return this.animalService.update(animal);
    }


}
