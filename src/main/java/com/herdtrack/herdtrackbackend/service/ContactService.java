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

    @Autowired
    private ContactRepo contactRepo;

public List<Contact> findAll(){return this.contactRepo.findAll();}

    public Contact findById(Long id) {
        Optional<Contact> optContact = this.contactRepo.findById(id);
        if (optContact.isPresent()) {
            return optContact.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

public List<Contact> findByLastName(String lastName){
        return this.contactRepo.findByLastName(lastName);
}

public List<Contact> findByfirstName(String firstName){
    return this.contactRepo.findByfirstName(firstName);
}

public List<Contact> findByRelation(String relation){
return this.contactRepo.findByRelation(relation);
}

public List<Contact> findByPhone (String phone){
    return  this.contactRepo.findByPhone(phone);
}

    public Contact create(Contact newContact) {
        return this.contactRepo.save(newContact);
    }

    public Contact update(Contact contact) {
        if (! this.contactRepo.existsById(contact.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    "impossible de trouver le contact a mettre à jour");
        }
        return this.contactRepo.save(contact);
    }

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
