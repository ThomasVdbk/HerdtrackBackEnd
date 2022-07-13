package com.herdtrack.herdtrackbackend.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe carnetsanitaire
 * @author Alexandre Dessoly
 */

@Entity
@Table(name="carnetsanitaire")
public class CarnetSanitaire {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="castration",nullable = false)
    private Boolean castration;
    @Column(name="datenaissance",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Traitement> traitements= new ArrayList<Traitement>();

    /**
     * Constructor carnet sanitaire
     * @author Alexandre Dessoly
     */
    public CarnetSanitaire(){

    }
    public CarnetSanitaire(Long id) {
        this.id = id;
    }

    public CarnetSanitaire(Long id, Boolean castration) {
        this.id = id;
        this.castration = castration;
    }

    public CarnetSanitaire(Long id, Boolean castration, Date dateNaissance) {
        this.id = id;
        this.castration = castration;
        this.dateNaissance = dateNaissance;
    }

    /**
     * getters & setters
     * @author Alexandre Dessoly
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getCastration() {
        return castration;
    }

    public void setCastration(Boolean castration) {
        this.castration = castration;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

}
