package com.herdtrack.herdtrackbackend.controller;

import com.herdtrack.herdtrackbackend.entity.Troupeau;
import com.herdtrack.herdtrackbackend.service.ITroupeauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/troupeaux")
public class TroupeauController {

    @Autowired
    private ITroupeauService troupeauService;

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Troupeau> findAll() {
        return this.troupeauService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Troupeau findById(@PathVariable Long id) {
        return this.troupeauService.findById(id);
    }

    @PostMapping("")
    public Troupeau createTroupeau(@RequestBody Troupeau troupeau) {
        return this.troupeauService.create(troupeau);
    }
}
