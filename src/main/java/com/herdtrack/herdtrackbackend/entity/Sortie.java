package com.herdtrack.herdtrackbackend.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sortie")

public class Sortie {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "dateSortie", length = 20)
    private Date date;
    @Column(name = "raisonSortie", length = 20)
    @Enumerated(EnumType.STRING)
    private Raison raison;

    @OneToOne(mappedBy = "sortie")
    private Animal animal;


    public Sortie() {
        super();
    }

    public Sortie(Long id, Date date, Raison raison) {
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
