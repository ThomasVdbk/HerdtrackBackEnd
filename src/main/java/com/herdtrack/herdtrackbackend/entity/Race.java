package com.herdtrack.herdtrackbackend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "race")
public class Race {

    // Creating a primary key for the table.
    @Id
    @GeneratedValue
    private Long id;


    // Creating a column in the database called libelle with a length of 45 characters and it is not null.
    @Column(name = "libelle",length = 45,nullable = false)
    private String libelle;


    // A void constructor.
    public Race() {
    }

    // A constructor.
    public Race(String libelle) {
        this.libelle = libelle;
    }


    public Race(Long id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
