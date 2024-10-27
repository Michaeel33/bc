package com.example.Eshop.Dto;

import lombok.Data;

@Data
public class Items {
    private Integer itemId;
    private String druhTovaru; // typ položky
    private Double cena;
}