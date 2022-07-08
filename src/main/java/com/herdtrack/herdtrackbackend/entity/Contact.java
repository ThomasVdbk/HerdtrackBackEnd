package com.herdtrack.herdtrackbackend.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "contact")
public class Contact {


    @Id
    @GeneratedValue
    private  Long id;


    @Column(name = "last_name", length = 45)
    @NotNull
    private String lastName;



    @Column(name = "first_name", length = 45)
    @NotNull
    private String firstName;


    @Column(name = "relation", length = 45)
    private String relation;


    @Column(name = "phone",length = 45)
    @NotNull
    private String phone;

    public Contact() {
    }

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
