package com.herdtrack.herdtrackbackend.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="traitement")
public class Traitement {
    @Id
    private Long id;
    @Column(name="numeroordonnance",nullable = false)
    private String numeroOrdonnance;
    @Column(name="datedebut",nullable = false)
    private Date dateDebut;
    @Column(name="datefin",nullable = false)
    private Date dateFin;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Medicament> medicaments = new ArrayList<Medicament>();

    @ManyToMany(mappedBy = "traitements",fetch = FetchType.LAZY )
    private List<CarnetSanitaire> carnetSanitaires = new ArrayList<CarnetSanitaire>();


    /**
     * Constructeur
     * @Author Alexandre Dessoly
     */

    public Traitement(){

    }

    public Traitement(Long id) {
        this.id = id;
    }

    public Traitement(Long id, String numeroOrdonnance) {
        this.id = id;
        this.numeroOrdonnance = numeroOrdonnance;
    }

    public Traitement(Long id, String numeroOrdonnance, Date dateDebut) {
        this.id = id;
        this.numeroOrdonnance = numeroOrdonnance;
        this.dateDebut = dateDebut;
    }

    public Traitement(Long id, String numeroOrdonnance, Date dateDebut, Date dateFin) {
        this.id = id;
        this.numeroOrdonnance = numeroOrdonnance;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
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

    public String getNumeroOrdonnance() {
        return numeroOrdonnance;
    }

    public void setNumeroOrdonnance(String numeroOrdonnance) {
        this.numeroOrdonnance = numeroOrdonnance;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
}
