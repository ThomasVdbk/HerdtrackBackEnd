package com.herdtrack.herdtrackbackend.controller;

import com.herdtrack.herdtrackbackend.entity.Espece;
import com.herdtrack.herdtrackbackend.entity.Race;
import com.herdtrack.herdtrackbackend.service.EspeceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/especes")
public class EspeceController {

    // Injecter l'EspeceService dans le contrôleur.
    @Autowired
    private EspeceService especeService;

    /**
     * Cette fonction renvoie une liste de toutes les espèces de la base de données
     *
     * @return Une liste de toutes les espèces dans la base de données.
     */
    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Espece> findAll(){
        return this.especeService.findAll();
    }

    /**
     * Cette fonction est utilisée pour trouver une espèce par son identifiant
     *
     * @param id l'id de l'espece à trouver
     */
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Espece findById(@PathVariable Long id) {
        return this.especeService.findById(id);
    }

    /**
     * Cette fonction est une requête GET qui renvoie une liste d'espèces dont le nom est égal au nom passé dans l'URL
     *
     * @param libelle Le nom de l'espèce
     * @return Une liste d'Espece
     */
    @GetMapping("/libelle/{libelle}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Espece> findByNom(@PathVariable String libelle){
        return this.especeService.findByLibelle(libelle);
    }

    /**
     * Il crée une nouvelle espèce
     *
     * @param newEspece L'objet qui sera créé.
     * @return L'objet newEspece
     */
    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Espece create(@RequestBody Espece newEspece) {
        return this.especeService.create(newEspece);
    }


    /**
     * Il met à jour l'espece avec l'identifiant donné dans l'url.
     *
     * @param espece L'objet qui sera mis à jour.
     * @param id L'identifiant de l'espece à mettre à jour.
     */
    @PostMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Espece update(@RequestBody Espece espece,@PathVariable Long id) {

        if (!id.equals(espece.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "mauvaise Race a mettre à jour");
        }
        return this.especeService.update(espece);
    }

    /**
     * Il supprime une espèce par identifiant.
     *
     * @param id l'id de l'espece à supprimer
     * @return L'espèce supprimée.
     */
    @DeleteMapping("/supp/{id}")
    @ResponseStatus(code=HttpStatus.ACCEPTED)
    public Espece delete(@PathVariable Long id) {
        return this.especeService.delete(id);
    }


    @GetMapping("races/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Race> findEspeceById(Long id) {
        return this.especeService.findEspeceById(id);
    }
}

