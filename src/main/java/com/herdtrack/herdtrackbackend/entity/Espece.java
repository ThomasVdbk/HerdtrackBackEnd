package com.herdtrack.herdtrackbackend.entity;


import javax.persistence.*;

@Entity
@Table(name = "espece")
public class Espece {

    @Id
    @GeneratedValue
    private Long id;


    @Column(name = "libelle", nullable = false)
    private String libelle;


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
