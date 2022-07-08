package com.herdtrack.herdtrackbackend.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "contact")
public class Contact {


    // This is a JPA annotation that tells the database to auto-generate the id for each new record.
    @Id
    @GeneratedValue
    private  Long id;


    // This is a JPA annotation that tells the database to create a column called last_name with a length of 45 characters.
    @Column(name = "last_name", length = 45)
    @NotNull
    private String lastName;



    // This is a JPA annotation that tells the database to create a column called first_name with a length of 45
    // characters.
    @Column(name = "first_name", length = 45)
    @NotNull
    private String firstName;


  // This is a JPA annotation that tells the database to create a column called relation with a length of 45 characters.
    @Column(name = "relation", length = 45)
    private String relation;


    // This is a JPA annotation that tells the database to create a column called phone with a length of 45 characters.
    @Column(name = "phone",length = 45)
    @NotNull
    private String phone;

    // This is a default constructor. It is required by JPA.
    public Contact() {
    }

    // This is a constructor that takes in the parameters and sets them to the class variables.
    public Contact(String lastName, String firstName, String relation, String phone) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.relation = relation;
        this.phone = phone;
    }


    public Contact(Long id, String lastName, String firstName, String relation, String phone) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.relation = relation;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
