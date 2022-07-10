package com.herdtrack.herdtrackbackend.controller;


import com.herdtrack.herdtrackbackend.entity.Vaccin;
import com.herdtrack.herdtrackbackend.service.VaccinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/vaccins")
public class VaccinController {

    // Injecter le VaccinService dans le contrôleur.
    @Autowired
    private VaccinService vaccinService;

    /**
     * Il renvoie une liste de tous les vaccins de la base de données.
     *
     * @return Une liste de tous les vaccins
     */
    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Vaccin> findAll(){
        return this.vaccinService.findAll();
    }

    /**
     * Cette fonction est utilisée pour trouver un vaccin par son identifiant
     *
     * @param id l'identifiant du vaccin à trouver
     * @return Vaccin
     */
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Vaccin findById(@PathVariable Long id) { return this.vaccinService.findById(id);}

    /**
     * Il renvoie une liste de vaccins portant le même nom.
     *
     * @param libelle Le nom du vaccin
     * @return Une liste d'objets Vaccin
    /**
     * Cette fonction est une requête GET qui renvoie une liste de vaccins avec le même numero_lot
     *
     * @param "numero_lot" le numéro du lot
     * @return Une liste d'objets Vaccin
     */

    @GetMapping("/libelle/{libelle}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Vaccin> findByLibelle(@PathVariable String libelle){
        return this.vaccinService.findByLibelle(libelle);
    }
    @GetMapping("/numeros_de_lot/{numero_lot}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Vaccin> findByNumero (@PathVariable String numero_lot){return  this.vaccinService.findByNumero(numero_lot);}
    /**
     * Il renvoie une liste de vaccins par date.
     *
     * @param date La date du vaccin
     * @return Une liste d'objets Vaccin
     */
    @GetMapping("/date/{date}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Vaccin> findByDate (@PathVariable Date date){return this.vaccinService.findByDate(date);}
    // Une méthode qui renvoie une liste des vaccins qui sont dus dans les prochains nbrJoursProchain jours.
    @GetMapping("/jours/{nbrJoursProchain}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Vaccin> findByJours (@PathVariable int nbrJoursProchain){return this.vaccinService.findByDays(nbrJoursProchain);}
    /**
     * Il crée un nouveau vaccin
     *
     * @param newVaccin L'objet qui sera créé.
     * @return L'objet Vaccin est renvoyé.
     */
    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Vaccin create(@RequestBody Vaccin newVaccin){return this.vaccinService.create(newVaccin);}
    /**
     * Il met à jour un vaccin
     *
     * @param vaccin l'objet qui sera mis à jour
     * @param id L'identifiant du Vaccin à mettre à jour
     */
    @PostMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Vaccin update(@RequestBody Vaccin vaccin, @PathVariable Long id) {
        if (!id.equals(vaccin.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "mauvaise Race a mettre à jour");
        }
        return this.vaccinService.update(vaccin);
    }
    /**
     * Il supprime un vaccin par identifiant.
     *
     * @param id l'identifiant du vaccin à supprimer
     * @return L'objet Vaccin supprimé.
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(code=HttpStatus.ACCEPTED)
public Vaccin delete(@PathVariable Long id){return this.vaccinService.delete(id);}

}
