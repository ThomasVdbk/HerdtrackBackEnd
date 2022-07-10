package com.herdtrack.herdtrackbackend.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sortie")
public class Sortie {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "dateSortie")
    private Date date;

    public Sortie() {
        super();
    }

    public Sortie(Long id, Date date) {
        this.id = id;
        this.date = date;
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
}
