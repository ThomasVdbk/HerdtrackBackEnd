package com.herdtrack.herdtrackbackend.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "entree")
public class Entree {


    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "dateEntree")
    private Date date;

    @Column(name = "raisonEntree", length = 20)
    @Enumerated(EnumType.STRING)
    private Raison raison;

    @OneToOne
    private Animal animal;


    public Entree() {
        super();
    }

    public Entree(Long id, Date date, Raison raison) {
        this.id = id;
        this.date = date;
        this.raison = raison;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Raison getRaison() {
        return raison;
    }

    public void setRaison(Raison raison) {
        this.raison = raison;
    }
}
