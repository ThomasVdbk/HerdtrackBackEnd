package com.herdtrack.herdtrackbackend.repository;

import com.herdtrack.herdtrackbackend.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepo extends JpaRepository<Contact, Long> {

    List<Contact> findByLastName(String lastName);

    List<Contact> findByfirstName(String firstName);

    List<Contact> findByPhone (String phone);

    List<Contact> findByRelation(String relation);


}
