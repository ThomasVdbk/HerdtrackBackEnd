package com.herdtrack.herdtrackbackend.controller;

import com.herdtrack.herdtrackbackend.entity.Traitement;
import com.herdtrack.herdtrackbackend.service.inter.ITraitementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/traitements")
public class TraitementController {

    @Autowired
    private ITraitementService traitementService;

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Traitement> findAll(){
        return this.traitementService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Traitement findById(@PathVariable Long id) {
        return this.traitementService.findById(id);
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Traitement create(@RequestBody Traitement newTraitement) {
        return this.traitementService.create(newTraitement);
    }

    @PostMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Traitement update(@RequestBody Traitement traitement,@PathVariable Long id) {
        if (!id.equals(traitement.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "mauvais traitement a mettre à jour");
        }
        return this.traitementService.update(traitement);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code=HttpStatus.ACCEPTED)
    public Traitement delete(@PathVariable Long id) {
        return this.traitementService.delete(id);
    }
}
