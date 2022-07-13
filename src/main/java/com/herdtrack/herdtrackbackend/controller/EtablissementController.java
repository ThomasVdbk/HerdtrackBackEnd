package com.herdtrack.herdtrackbackend.controller;

import com.herdtrack.herdtrackbackend.entity.Etablissement;
import com.herdtrack.herdtrackbackend.service.EtablissementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etablissements")
public class EtablissementController {

    @Autowired
    private EtablissementService etablissementService;

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Etablissement> findAll(){
        return this.etablissementService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Etablissement findById(@PathVariable Long id){
        return this.etablissementService.findById(id);
    }

    @GetMapping("/numero/{numeroExploitation}")
    @ResponseStatus(code = HttpStatus.OK)
    public Etablissement findByNumeroExploitation(@PathVariable String numeroExploitation){
        return this.etablissementService.findByNumeroExploitation(numeroExploitation);
    }

    @PostMapping("")
    public Etablissement createEtablissement(@RequestBody Etablissement etablissement){
        return this.etablissementService.create(etablissement);
    }
}
