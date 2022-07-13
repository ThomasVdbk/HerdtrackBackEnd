package com.herdtrack.herdtrackbackend.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "espece")
public class Espece {

    // Création d'une clé primaire pour la table.
    @Id
    @GeneratedValue
    private Long id;


    // Création d'une colonne dans la base de données appelée libelle et non nullable.
    @Column(name = "libelle", nullable = false)
    private String libelle;

// Création d'une relation entre les tables Espece et Race.
    @OneToMany(mappedBy = "espece", fetch = FetchType.LAZY)
    private List<Race> races = new ArrayList<Race>();

    public Espece() {
    }

    public Espece(String libelle) {
        this.libelle = libelle;
    }

    public Espece(Long id, String libelle) {
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
