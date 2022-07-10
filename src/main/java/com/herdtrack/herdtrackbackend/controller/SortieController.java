package com.herdtrack.herdtrackbackend.controller;


import com.herdtrack.herdtrackbackend.entity.Sortie;
import com.herdtrack.herdtrackbackend.service.SortieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/sortie")
public class SortieController {

    @Autowired
    private SortieService sortieService;


    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Sortie> findAll() {
        return this.sortieService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Sortie findById(@PathVariable Long id) {
        return this.sortieService.findById(id);
    }

    ;

    @GetMapping("/date/{date}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Sortie> findByDate(@PathVariable Date date) {
        return this.sortieService.findByDate(date);
    }

    ;


    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Sortie create(@RequestBody Sortie newSortie) {
        return this.sortieService.create(newSortie);
    }

    ;

    @PostMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Sortie update(@RequestBody Sortie sortie, @PathVariable Long id) {
        if (!id.equals(sortie.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "mauvaise Sortie a mettre à jour");
        }
        return this.sortieService.update(sortie);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Sortie delete(@PathVariable Long id) {
        return this.sortieService.delete(id);
    }
}
