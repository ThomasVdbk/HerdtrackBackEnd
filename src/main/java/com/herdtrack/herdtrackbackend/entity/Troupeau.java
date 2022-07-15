package com.herdtrack.herdtrackbackend.entity;

/*
Classe Troupeau, entité qui regroupe des animaux
@author Nicolas Desdevises
 */

import javax.persistence.*;

@Entity
@Table(name="troupeau")
public class Troupeau {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Parc parc;

    @ManyToOne
    @JoinColumn(name="espece_id")
    private Espece espece;

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

    public Espece getEspece() {
        return espece;
    }

    public void setEspece(Espece espece) {
        this.espece = espece;
    }
}
