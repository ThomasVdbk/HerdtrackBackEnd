package com.herdtrack.herdtrackbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/*

Classe Statut Santé d'un animal ou d'un parc
@author Nicolas Desdevises
 */
@Entity
@Table(name = "statut_sante")
public class StatutSante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "libelle", nullable = false, length = 50)
    private String libelle;
    @OneToMany(mappedBy = "statutSante", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Parc> parcs;

    public StatutSante() {
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

    public List<Parc> getParcs() {
        return parcs;
    }

    public void setParcs(List<Parc> parcs) {
        this.parcs = parcs;
    }
}
