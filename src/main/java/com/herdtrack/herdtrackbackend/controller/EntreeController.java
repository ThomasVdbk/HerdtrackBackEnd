package com.herdtrack.herdtrackbackend.controller;

import com.herdtrack.herdtrackbackend.entity.Entree;
import com.herdtrack.herdtrackbackend.entity.Raison;
import com.herdtrack.herdtrackbackend.service.inter.IEntreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/entree")
public class EntreeController {
    @Autowired
    private IEntreeService entreeService;


    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Entree> findAll() {
        return this.entreeService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Entree findById(@PathVariable Long id) {
        return this.entreeService.findById(id);
    }

    ;

    @GetMapping("/date/{date}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Entree> findByDate(@PathVariable Date date) {
        return this.entreeService.findByDate(date);
    }

    @GetMapping("/Raison/{raison}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Entree> findByRaison(@PathVariable Raison raison) {
        return this.entreeService.findByRaison(raison);
    }


    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Entree create(@RequestBody Entree newEntree) {
        return this.entreeService.create(newEntree);
    }

    ;

    @PostMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Entree update(@RequestBody Entree entree, @PathVariable Long id) {
        if (!id.equals(entree.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "mauvaise Entree a mettre à jour");
        }
        return this.entreeService.update(entree);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Entree delete(@PathVariable Long id) {
        return this.entreeService.delete(id);
    }


}
