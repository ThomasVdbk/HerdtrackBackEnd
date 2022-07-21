package com.herdtrack.herdtrackbackend.controller;

import com.herdtrack.herdtrackbackend.entity.StatutSante;
import com.herdtrack.herdtrackbackend.service.inter.IStatutSanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statutsantes")
public class StatutSanteController {

    @Autowired
    private IStatutSanteService statutSanteService;

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<StatutSante> findAll() {
        return this.statutSanteService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public StatutSante findById(@PathVariable Long id) {
        return this.statutSanteService.findById(id);
    }

    @PostMapping("")
    public StatutSante createTroupeau(@RequestBody StatutSante statutSante) {
        return this.statutSanteService.create(statutSante);
    }
}
