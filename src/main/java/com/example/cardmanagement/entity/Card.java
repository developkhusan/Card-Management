package com.example.cardmanagement.entity;

import lombok.Data;

@Data
public class Card {
    private Integer id;
    private String number;
    private String expiration;
    private String cvc;
    private String pin;
    private Double balance;
    private Boolean active;
}

