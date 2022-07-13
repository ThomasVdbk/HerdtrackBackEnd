package com.herdtrack.herdtrackbackend.controller;

import com.herdtrack.herdtrackbackend.entity.Parc;
import com.herdtrack.herdtrackbackend.service.IParcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parcs")
public class ParcController {

    @Autowired
    private IParcService parcService;

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Parc> findAll() {
        return this.parcService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Parc findById(@PathVariable Long id) {
        return this.parcService.findById(id);
    }

    @PostMapping("")
    public Parc createParc(@RequestBody Parc parc) {
        return this.parcService.create(parc);
    }
}
