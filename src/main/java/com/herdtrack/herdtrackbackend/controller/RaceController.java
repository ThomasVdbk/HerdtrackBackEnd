package com.herdtrack.herdtrackbackend.controller;


import com.herdtrack.herdtrackbackend.entity.Race;
import com.herdtrack.herdtrackbackend.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/races")
public class RaceController {

    @Autowired
    private RaceService raceService;

    /**
     * Cette fonction renvoie une liste de toutes les races dans la base de données
     * 
     * @return Une liste de races
     */
    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Race> findAll(){
        return this.raceService.findAll();
    }

    // Une méthode qui renvoie une race par identifiant.
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Race findById(@PathVariable Long id) {
        return this.raceService.findById(id);
    };

    // Une méthode qui renvoie une liste de races qui ont la même libelle.
    @GetMapping("/libelle/{libelle}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Race> findByNom(@PathVariable String libelle){
        return this.raceService.findByLibelle(libelle);
    };

    // Création d'une nouvelle race.
    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Race create(@RequestBody Race newRace) {
        return this.raceService.create(newRace);
    };

    /**
     * Il met à jour une race
     *
     * @param race L'objet qui sera mis à jour.
     * @param id L'identifiant de la race à mettre à jour.
     * @return La race mise à jour
     */
    @PostMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Race update(@RequestBody Race race,@PathVariable Long id) {

        if (!id.equals(race.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "mauvaise Race a mettre à jour");
        }
        return this.raceService.update(race);
    }

    /**
     * > Supprimer une race par identifiant
     *
     * @param id L'identifiant de la race à supprimer.
     * @return L'objet Race qui a été supprimé.
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(code=HttpStatus.ACCEPTED)
    public Race delete(@PathVariable Long id) {
        return this.raceService.delete(id);
    }
}
