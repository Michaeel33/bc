package com.example.Eshop.Dto;

import lombok.Data;

@Data
public class PersonalDocuments {
    private Integer docId;
    private Integer perId; // cudzí kľúč
    private String obcianskypreukaz;
    private Integer stat; // ID krajiny ako cudzí kľúč
    private boolean isVerified;
}