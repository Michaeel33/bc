package com.example.Eshop.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "personal_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
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

}