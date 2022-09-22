package com.cydeo.model;

import lombok.Data;

@Data
public class Ingredients {
    private String name;
    private int quantity;
    private QuantityType quantityType;

    public enum QuantityType {
        OUNCE, LB, TBSP
    }
}
