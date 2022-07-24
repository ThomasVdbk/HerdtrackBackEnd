package com.herdtrack.herdtrackbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "entree")
public class Entree {


    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "raison")
    @Enumerated(EnumType.STRING)
    private Raison raison;

    @OneToMany(mappedBy = "entree")
    @JsonIgnore
    private List<Animal> animals;


    public Entree() {
    }

    public Entree(Long id, Date date, Raison raison) {
        this.id = id;
        this.date = date;
        this.raison = raison;
    }

    public Entree(Date date, Raison raison) {
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
