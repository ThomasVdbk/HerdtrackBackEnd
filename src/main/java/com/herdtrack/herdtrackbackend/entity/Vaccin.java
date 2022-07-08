package com.herdtrack.herdtrackbackend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
@Table(name = "vaccin")
public class Vaccin {

    @Id
    @GeneratedValue
private Long id;

    @Column(name = "libelle", length = 45)
    @NotNull
private String libelle;

    @Column(name = "numero_lot", length = 45)
    @NotNull
private String numero_lot;

    @Column(name = "date_vaccination")
    @Temporal(TemporalType.DATE)
    @NotNull
private Date date_vaccination;

private int nbrDaysNext;

    public Vaccin() {
    }

    public Vaccin(String libelle, String numero_lot, Date date_vaccination, int nbrDaysNext) {
        this.libelle = libelle;
        this.numero_lot = numero_lot;
        this.date_vaccination = date_vaccination;
        this.nbrDaysNext = nbrDaysNext;
    }

    public Vaccin(Long id, String libelle, String numero_lot, Date date_vaccination, int nbrDaysNext) {
        this.id = id;
        this.libelle = libelle;
        this.numero_lot = numero_lot;
        this.date_vaccination = date_vaccination;
        this.nbrDaysNext = nbrDaysNext;
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

    public int getNbrDaysNext() {
        return nbrDaysNext;
    }

    public void setNbrDaysNext(int nbrDaysNext) {
        this.nbrDaysNext = nbrDaysNext;
    }
}
