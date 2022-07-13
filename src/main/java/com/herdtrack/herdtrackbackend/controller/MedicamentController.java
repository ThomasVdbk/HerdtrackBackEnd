package com.herdtrack.herdtrackbackend.controller;

import com.herdtrack.herdtrackbackend.entity.Medicament;
import com.herdtrack.herdtrackbackend.service.inter.IMedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/medicaments")
public class MedicamentController {

    @Autowired
    private IMedicamentService medicamentService;

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Medicament> findAll(){
        return this.medicamentService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Medicament findById(@PathVariable Long id) {
        return this.medicamentService.findById(id);
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Medicament create(@RequestBody Medicament newMedicament) {
        return this.medicamentService.create(newMedicament);
    }

    @PostMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Medicament update(@RequestBody Medicament medicament,@PathVariable Long id) {
        if (!id.equals(medicament.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "mauvais medicament a mettre à jour");
        }
        return this.medicamentService.update(medicament);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code=HttpStatus.ACCEPTED)
    public Medicament delete(@PathVariable Long id) {
        return this.medicamentService.delete(id);
    }
}
