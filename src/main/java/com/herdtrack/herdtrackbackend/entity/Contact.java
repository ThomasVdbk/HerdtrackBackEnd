package com.herdtrack.herdtrackbackend.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "contact")
public class Contact {


    // Création d'une clé primaire pour la table.
    @Id
    @GeneratedValue
    private  Long id;


    // Mappage du champ à une colonne de la base de données.
    @Column(name = "nom", length = 45,nullable = false)
    private String nom;



    // Mappage du champ à une colonne de la base de données.
    @Column(name = "prenom", length = 45,nullable = false)
    private String prenom;


    // Une annotation JPA qui mappe le champ à une colonne de la base de données.
    @Column(name = "relation", length = 45)
    private String relation;


    // Une annotation JPA qui mappe le champ à une colonne de la base de données.
    @Column(name = "phone",length = 45,nullable = false)
    private String phone;


    // Il s'agit d'un constructeur vide.
    public Contact() {
    }


    public Contact(String lastName, String firstName, String relation, String phone) {
        this.nom = nom;
        this.prenom = prenom;
        this.relation = relation;
        this.phone = phone;
    }


    // Il s'agit d'un constructeur.
    public Contact(Long id, String lastName, String firstName, String relation, String phone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.relation = relation;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String Nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
