package com.herdtrack.herdtrackbackend.controller;

import com.herdtrack.herdtrackbackend.entity.Contact;
import com.herdtrack.herdtrackbackend.service.inter.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {


    // Injecter le ContactService dans le ContactController.
    @Autowired
    private IContactService contactService;

    /**
     * Cette fonction est une requête GET qui renvoie une liste de tous les contacts de la base de données
     *
     * @return Une liste de contacts
     */
    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Contact> findAll(){
        return this.contactService.findAll();
    }

    // Il s'agit d'une méthode qui renvoie un contact avec le même identifiant.
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Contact findById(@PathVariable Long id) {
        return this.contactService.findById(id);
    };


    // Il s'agit d'une méthode qui renvoie une liste de contacts portant le même nom de famille.
    @GetMapping("/nom/{nom}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Contact> findByNom(@PathVariable String nom){
        return this.contactService.findByNom(nom);
    };

    // Il s'agit d'une méthode qui renvoie une liste de contacts portant le même prénom.
    @GetMapping("/prenom/{prenom}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Contact> findByPrenom(@PathVariable String prenom){
        return this.contactService.findByPrenom(prenom);



    // Une méthode qui renvoie une liste de contacts avec la même relation.
    };@GetMapping("/relation/{relation}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Contact> findByRelation(@PathVariable String relation){
        return this.contactService.findByRelation(relation);
    }


// Une méthode qui renvoie une liste de contacts avec un numéro de téléphone commençant par le String demandé.
@GetMapping("/phone/{phone}")
@ResponseStatus(code = HttpStatus.OK)
    public List<Contact> findByPhone(@PathVariable String phone){
        return this.contactService.findByPhone(phone);
    };


    // Création d'un nouveau contact.
    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Contact create(@RequestBody Contact newContact) {
        return this.contactService.create(newContact);
    };

    /**
     * Il met à jour un contact
     *
     * @param contact L'objet qui sera mis à jour.
     * @param id L'identifiant du contact à mettre à jour.
     */
    @PostMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Contact update(@RequestBody Contact contact,@PathVariable Long id) {

        if (!id.equals(contact.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "mauvaise Contact a mettre à jour");
        }
        return this.contactService.update(contact);
    }
    /**
     * Cette fonction supprime un contact de la base de données et renvoie le contact supprimé
     *
     * @param id L'identifiant du contact à supprimer.
     * @return Le contact qui a été supprimé.
     */
    @DeleteMapping("/supp/{id}")
    @ResponseStatus(code=HttpStatus.ACCEPTED)
    public Contact delete(@PathVariable Long id) {
        return this.contactService.delete(id);
    }

}
