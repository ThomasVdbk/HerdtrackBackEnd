package com.herdtrack.herdtrackbackend.Controller;

import com.herdtrack.herdtrackbackend.Entity.CarnetSanitaire;
import com.herdtrack.herdtrackbackend.Service.CarnetSanitaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/carnetsanitaires")
public class CarnetSanitaireController {

    @Autowired
    private CarnetSanitaireService carnetSanitaire;

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<CarnetSanitaire> findAll(){
        return this.carnetSanitaire.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public CarnetSanitaire findById(@PathVariable Long id) {
        return this.carnetSanitaire.findById(id);
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public CarnetSanitaire create(@RequestBody CarnetSanitaire newCarnetSanit) {
        return this.carnetSanitaire.create(newCarnetSanit);
    }

    @PostMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public CarnetSanitaire update(@RequestBody CarnetSanitaire carnetSanitaire,@PathVariable Long id) {
        if (!id.equals(carnetSanitaire.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "mauvais carnet sanitaire a mettre à jour");
        }
        return this.carnetSanitaire.update(carnetSanitaire);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code=HttpStatus.ACCEPTED)
    public CarnetSanitaire delete(@PathVariable Long id) {
        return this.carnetSanitaire.delete(id);
    }
}
