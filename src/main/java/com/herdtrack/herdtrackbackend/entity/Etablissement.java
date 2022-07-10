package com.herdtrack.herdtrackbackend.entity;

import javax.persistence.*;

/*

Classe Etablissement d'un éleveur
@author Nicolas Desdevises
 */
@Entity
@Table(name = "etablissement")
public class Etablissement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "lieu", nullable = false, length = 150)
    private String lieu;
    @Column(name = "numero_exploitation", nullable = false, length = 50)
    private String numeroExploitation;
    @OneToOne()
    private Eleveur eleveur;

    public Etablissement() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getNumeroExploitation() {
        return numeroExploitation;
    }

    public void setNumeroExploitation(String numeroExploitation) {
        this.numeroExploitation = numeroExploitation;
    }

    public Eleveur getEleveur() {
        return eleveur;
    }

    public void setEleveur(Eleveur eleveur) {
        this.eleveur = eleveur;
    }
}
