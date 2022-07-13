package com.herdtrack.herdtrackbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/*
Classe d'un éleveur d'animaux
@author Nicolas Desdevises
 */
@Entity
@Table(name = "eleveur")
public class Eleveur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nom", nullable = false, length = 50)
    private String nom;
    @Column(name = "prenom", nullable = false, length = 50)
    private String prenom;

    @OneToMany(mappedBy = "eleveur", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Etablissement> etablissements;

    @OneToMany(mappedBy = "eleveur", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Animal> animals;

    public Eleveur() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<Etablissement> getEtablissements() {
        return etablissements;
    }

    public void setEtablissements(List<Etablissement> etablissements) {
        this.etablissements = etablissements;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}
