package com.herdtrack.herdtrackbackend.entity;



import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "vaccin")
public class Vaccin {


    // Création d'une clé primaire pour la table.
    @Id
    @GeneratedValue
    private Long id;

    // Création d'une colonne dans la base de données appelée libelle et non nullable.
    @Column(name = "libelle", length = 45,nullable = false)
    private String libelle;


    // Création d'une colonne dans la base de données appelée numero_lot et elle n'est pas nullable.
    @Column(name = "numero_lot", length = 45,nullable = false)
    private String numeroLot;


    // Le code ci-dessus crée une colonne dans la base de données appelée date_vaccination et il n'est pas nullable.
    @Column(name = "date_vaccination",nullable = false)
    private Date date_vaccination;


    // Une colonne dans la base de données.
    @Column(name = "nbr_jours_prochain" , nullable = false)
    private int nbrJoursProchain;


    // Un constructeur par défaut.
    public Vaccin() {
    }


    // Un constructeur.
    public Vaccin(String libelle, String numeroLot, Date date_vaccination, int nbrDaysNext) {
        this.libelle = libelle;
        this.numeroLot = numeroLot;
        this.date_vaccination = date_vaccination;
        this.nbrJoursProchain = nbrDaysNext;
    }

   // Un constructeur.
     public Vaccin(Long id, String libelle, String numeroLot, Date date_vaccination, int nbrDaysNext) {
        this.id = id;
        this.libelle = libelle;
        this.numeroLot = numeroLot;
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

    public String getNumeroLot() {
        return numeroLot;
    }

    public void setnumeroLot(String numeroLot) {
        this.numeroLot = numeroLot;
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
