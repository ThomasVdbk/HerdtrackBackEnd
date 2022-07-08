package com.herdtrack.herdtrackbackend.service;

import com.herdtrack.herdtrackbackend.entity.Contact;
import com.herdtrack.herdtrackbackend.repository.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    // Injecter le ContactRepo dans le ContactService.
    @Autowired
    private ContactRepo contactRepo;

/**
 * Trouvez tous les contacts dans la base de données et renvoyez-les sous forme de liste.
 *
 * @return Une liste de tous les contacts dans la base de données.
 */
public List<Contact> findAll(){return this.contactRepo.findAll();}

    /**
     * Si le contact est trouvé, retournez-le, sinon lancez un 404
     *
     * @param id L'identifiant du contact à récupérer.
     * @return Un objet facultatif.
     */
    public Contact findById(Long id) {
        Optional<Contact> optContact = this.contactRepo.findById(id);
        if (optContact.isPresent()) {
            return optContact.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

/**
 * Trouver tous les contacts avec le nom donné.
 *
 * @param nom le nom de la méthode
 * @return Une liste de contacts
 */
public List<Contact> findByNom(String nom){
        return this.contactRepo.findByNom(nom);
}


/**
 * Trouver tous les contacts avec le prénom donné.
 *
 * @param prenom le nom du paramètre dans la signature de la méthode
 * @return Une liste de contacts
 */
public List<Contact> findByPrenom(String prenom){
    return this.contactRepo.findByPrenom(prenom);
}

/**
 * Trouver tous les contacts avec la relation donnée.
 *
 * @param relation La relation du contact.
 * @return Une liste de contacts
 */
public List<Contact> findByRelation(String relation){
return this.contactRepo.findByRelation(relation);
}

/**
 * Trouver tous les contacts avec le numéro de téléphone donné.
 *
 * @param phone Le numéro de téléphone à rechercher.
 * @return Une liste de contacts
 */
public List<Contact> findByPhone (String phone){
    return  this.contactRepo.findByPhone(phone);
}

    /**
     * Créez un nouveau contact et enregistrez-le dans la base de données.
     *
     * @param newContact C'est l'objet que nous créons.
     * @return Le nouveau contact qui a été créé.
     */
    public Contact create(Contact newContact) {
        return this.contactRepo.save(newContact);
    }

    /**
     * Si le contact existe, mettez-le à jour, sinon lancez une exception
     *
     * @param contact l'objet contact à mettre à jour
     * @return Le contact mis à jour
     */
    public Contact update(Contact contact) {
        if (! this.contactRepo.existsById(contact.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    "impossible de trouver le contact a mettre à jour");
        }
        return this.contactRepo.save(contact);
    }

    /**
     * Si le contact existe, supprimez-le et renvoyez-le
     *
     * @param id l'id du contact à supprimer
     * @return Le contact supprimé
     */
    public Contact delete (Long id) {
        if (! this.contactRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "impossible de trouver le contact à supprimer");
        }
        Contact contactDel = this.findById(id);
        this.contactRepo.deleteById(id);
        if (this.contactRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                    "erreur lors de la suppression du contact");
        }

        return contactDel;
    }

}
