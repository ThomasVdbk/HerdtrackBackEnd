package com.herdtrack.herdtrackbackend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;


@Entity
@Table(name = "vaccin")
public class Vaccin {

    // Creating a primary key for the table.
    @Id
    @GeneratedValue
    private Long id;

   // A JPA annotation that maps the field to a column in the database.
    @Column(name = "libelle", length = 45,nullable = false)
    private String libelle;

    // Creating a column in the database called numero_lot with a length of 45 characters and it is not nullable.
    @Column(name = "numero_lot", length = 45,nullable = false)
    private String numero_lot;

    // Creating a column in the database called date_vaccination and it is not nullable.
    @Column(name = "date_vaccination",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date_vaccination;


    @Column(name = "nbr_jours_prochain" , nullable = false)
    private int nbrJoursProchain;

    // A void constructor.
    public Vaccin() {
    }

    // A constructor.
    public Vaccin(String libelle, String numero_lot, Date date_vaccination, int nbrDaysNext) {
        this.libelle = libelle;
        this.numero_lot = numero_lot;
        this.date_vaccination = date_vaccination;
        this.nbrJoursProchain = nbrDaysNext;
    }

    public Vaccin(Long id, String libelle, String numero_lot, Date date_vaccination, int nbrDaysNext) {
        this.id = id;
        this.libelle = libelle;
        this.numero_lot = numero_lot;
        this.date_vaccination = date_vaccination;
        this.nbrJoursProchain = nbrDaysNext;
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

    public String getNumero_lot() {
        return numero_lot;
    }

    public void setNumero_lot(String numero_lot) {
        this.numero_lot = numero_lot;
    }

    public Date getDate_vaccination() {
        return date_vaccination;
    }

    public void setDate_vaccination(Date date_vaccination) {
        this.date_vaccination = date_vaccination;
    }

    public int getNbrJoursProchain() {
        return nbrJoursProchain;
    }

    public void setNbrJoursProchain(int nbrJoursProchain) {
        this.nbrJoursProchain = nbrJoursProchain;
    }
}
