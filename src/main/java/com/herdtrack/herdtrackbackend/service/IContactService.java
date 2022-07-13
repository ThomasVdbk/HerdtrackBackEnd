package com.herdtrack.herdtrackbackend.service;

import com.herdtrack.herdtrackbackend.entity.Contact;

import java.util.List;

public interface IContactService {
    List<Contact> findAll();

    Contact findById(Long id);

    List<Contact> findByNom(String nom);

    List<Contact> findByPrenom(String prenom);

    List<Contact> findByRelation(String relation);

    List<Contact> findByPhone(String phone);

    Contact create(Contact newContact);

    Contact update(Contact contact);

    Contact delete(Long id);
}
