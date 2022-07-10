package com.herdtrack.herdtrackbackend.entity;

import javax.persistence.*;

/*

Classe Etablissement d'un éleveur
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
}
