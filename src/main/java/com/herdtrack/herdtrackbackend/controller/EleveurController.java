package com.herdtrack.herdtrackbackend.controller;

import com.herdtrack.herdtrackbackend.entity.Eleveur;
import com.herdtrack.herdtrackbackend.service.inter.IEleveurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eleveurs")
public class EleveurController {

    @Autowired
    private IEleveurService eleveurService;

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Eleveur> findAll(){
        return this.eleveurService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Eleveur findById(@PathVariable Long id){
        return this.eleveurService.findById(id);
    }

    @PostMapping("")
    public Eleveur createEleveur(@RequestBody Eleveur eleveur){
        return this.eleveurService.create(eleveur);
    }
}
