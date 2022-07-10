package com.herdtrack.herdtrackbackend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "race")
public class Race {


    // Création d'une clé primaire pour la table.
    @Id
    @GeneratedValue
    private Long id;



    // Création d'une colonne dans la base de données appelée libelle avec une longueur de 45 et elle n'est pas nullable.
    @Column(name = "libelle",length = 45,nullable = false)
    private String libelle;

@ManyToOne
 private Espece espece;

    // Un constructeur vide.
    public Race() {
    }


    // Un constructeur.
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
