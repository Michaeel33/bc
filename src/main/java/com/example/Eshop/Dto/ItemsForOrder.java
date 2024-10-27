package com.example.Eshop.Dto;

import lombok.Data;

@Data
public class ItemsForOrder {
    private Integer id;
    private String orderNumber;
    private Integer itemId;
}