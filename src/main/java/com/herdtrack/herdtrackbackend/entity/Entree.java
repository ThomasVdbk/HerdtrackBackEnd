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

    public Entree() {
        super();
    }

    public Entree(Long id, Date date) {
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
