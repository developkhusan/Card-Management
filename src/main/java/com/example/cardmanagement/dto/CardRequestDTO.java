package com.example.cardmanagement.dto;

import jdk.jfr.DataAmount;
import lombok.Data;

@Data
public class CardRequestDTO {
    private String number;
    private String pin;
    private Double balance;
    private String cvc;
    private String expiration;
}
