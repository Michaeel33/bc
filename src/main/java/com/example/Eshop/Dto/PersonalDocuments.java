package com.example.Eshop.Dto;

import lombok.Data;

@Data
public class PersonalDocuments {
    private String obcianskypreukaz;
    private String countryName; // ID krajiny ako cudzí kľúč
    private boolean isVerified;
}