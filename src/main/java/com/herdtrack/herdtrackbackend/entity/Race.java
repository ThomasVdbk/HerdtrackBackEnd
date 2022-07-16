package com.herdtrack.herdtrackbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;


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

// Création d'une relation entre les tables Race et Espece.
@ManyToOne
@JoinColumn(name = "espece_id")
 private Espece espece;


    /**
    * Relation entre carnet sanitaire et race
    * @Alexandre Dessoly
    */
    @OneToMany(mappedBy = "race")
    @JsonIgnore
    private List<CarnetSanitaire> carnetSanitaires;


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
