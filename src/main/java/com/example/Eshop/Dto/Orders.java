package com.example.Eshop.Dto;

import lombok.Data;

import java.util.List;

@Data
public class Orders {
    private String orderNumber; // primárny kľúč
    private Double price;

    List<ItemsForOrder> itemsForOrderList;

}