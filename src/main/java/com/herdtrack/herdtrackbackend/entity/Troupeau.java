package com.herdtrack.herdtrackbackend.entity;

/*
Classe Troupeau, entité qui regroupe des animaux
@author Nicolas Desdevises
 */

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "troupeau")
public class Troupeau {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Parc parc;

    @OneToMany(mappedBy = "troupeau", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Animal> animaux;

    public Troupeau() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Parc getParc() {
        return parc;
    }

    public void setParc(Parc parc) {
        this.parc = parc;
    }

    public List<Animal> getAnimaux() {
        return animaux;
    }

    public void setAnimaux(List<Animal> animaux) {
        this.animaux = animaux;
    }
}
