package com.example.Eshop.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "personal_data")
public class PersonalDataEntity {

    @Id
    @Column(name = "per_id")
    private Long perId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "ulica")
    private String ulica;

    @Column(name = "mesto")
    private String mesto;

    @Column(name = "psc")
    private String psc;


    public PersonalDataEntity() {
    }


    public PersonalDataEntity(Long perId, String firstName, String lastName, String ulica, String mesto, String psc) {
        this.perId = perId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ulica = ulica;
        this.mesto = mesto;
        this.psc = psc;
    }


    public Long getPerId() {
        return perId;
    }

    public void setPerId(Long perId) {
        this.perId = perId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getPsc() {
        return psc;
    }

    public void setPsc(String psc) {
        this.psc = psc;
    }
}