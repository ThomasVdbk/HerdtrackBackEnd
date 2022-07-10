package com.herdtrack.herdtrackbackend.entity;

import javax.persistence.*;

/*
Classe d'un éleveur d'animaux
@author Nicolas Desdevises
 */
@Entity
@Table(name="eleveur")
public class Eleveur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nom", nullable = false, length = 50)
    private String nom;
    @Column(name = "prenom", nullable = false, length = 50)
    private String prenom;
    //ToDo : modifier l'annotation pour onetomany ?
    @OneToOne(mappedBy = "eleveur")
    private Etablissement etablissement;

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

    public Etablissement getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }
}
