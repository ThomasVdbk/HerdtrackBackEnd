package com.herdtrack.herdtrackbackend.entity;

import javax.persistence.*;
import java.util.Set;

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

    @ManyToMany(mappedBy = "subParcs")
    private Set<Parc> parcs;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Parc> subParcs;


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

    public Set<Parc> getParcs() {
        return parcs;
    }

    public void setParcs(Set<Parc> parcs) {
        this.parcs = parcs;
    }

    public Set<Parc> getSubParcs() {
        return subParcs;
    }

    public void setSubParcs(Set<Parc> subParcs) {
        this.subParcs = subParcs;
    }
}
