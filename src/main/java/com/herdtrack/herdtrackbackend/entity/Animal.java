package com.herdtrack.herdtrackbackend.entity;

import javax.persistence.*;

@Entity
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue
    private Long id;
    @Version
    private int version;
    @Column(name = "reference", length = 255)
    private String reference;
    @Column(name = "nom", length = 20)
    private String nom;

    public Animal() {
        super();
    }

    public Animal(Long id, int version, String reference, String nom) {
        this.id = id;
        this.version = version;
        this.reference = reference;
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
