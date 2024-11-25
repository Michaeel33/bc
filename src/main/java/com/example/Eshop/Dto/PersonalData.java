package com.example.Eshop.Dto;




public class PersonalData {

    private Long perId;
    private String firstName;
    private String lastName;
    private String ulica;
    private String mesto;
    private String psc;


    public PersonalData() {
    }

    public PersonalData(Long perId, String firstName, String lastName, String ulica, String mesto, String psc) {
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
