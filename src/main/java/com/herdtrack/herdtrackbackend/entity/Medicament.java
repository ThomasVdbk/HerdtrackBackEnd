package com.herdtrack.herdtrackbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe medicament
 * @author Alexandre Dessoly
 */
@Entity
@Table(name="medicament")
public class Medicament {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="numerolot",nullable = false)
    private String numeroLot;

    @Column(name="libelle",nullable = false)
    private String libelle;

    @ManyToMany(mappedBy = "medicaments", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Traitement> traitements= new ArrayList<Traitement>();

    /**
     * Constructeur
     * @Author Alexandre Dessoly
     */

    public Medicament(){

    }
    public Medicament(Long id) {
        this.id = id;
    }

    public Medicament(Long id, String numeroLot) {
        this.id = id;
        this.numeroLot = numeroLot;
    }

    public Medicament(Long id, String numeroLot, String libelle) {
        this.id = id;
        this.numeroLot = numeroLot;
        this.libelle = libelle;
    }

    /**
     * Getters && Setters
     * @Author Alexandre Dessoly
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroLot() {
        return numeroLot;
    }

    public void setNumeroLot(String numeroLot) {
        this.numeroLot = numeroLot;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
