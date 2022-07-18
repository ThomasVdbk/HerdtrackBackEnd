package com.herdtrack.herdtrackbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/*
Classe Parc, lieu où est placé un troupeau
@author Nicolas Desdevises
 */
@Entity
@Table(name = "parc")
public class Parc {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "libelle", nullable = false, length = 50)
    private String libelle;
    @Column(name = "nombre_troupeau", nullable = false)
    private int nombreTroupeau;
    @Column(name = "quarantaine", nullable = false)
    private boolean quarantaine;
    @OneToMany(mappedBy = "parc", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Troupeau> troupeaux;
    @ManyToOne
    private StatutSante statutSante;

    public Parc() {
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

    public int getNombreTroupeau() {
        return nombreTroupeau;
    }

    public void setNombreTroupeau(int nombreTroupeau) {
        this.nombreTroupeau = nombreTroupeau;
    }

    public boolean isQuarantaine() {
        return quarantaine;
    }

    public void setQuarantaine(boolean quarantaine) {
        this.quarantaine = quarantaine;
    }

    public List<Troupeau> getTroupeaux() {
        return troupeaux;
    }

    public void setTroupeaux(List<Troupeau> troupeaux) {
        this.troupeaux = troupeaux;
    }
}
