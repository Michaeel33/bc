package com.example.Eshop.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "personaldocuments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalDocumentsEntity {

    @Id
    @Column(name = "per_id")
    private Long perId;

    @Column(name = "obcianskypreukaz")
    private String customerId;

    @Column(name = "stat")
    private int stat;

    @Column(name = "is_verified")
    private boolean isVerified;
}