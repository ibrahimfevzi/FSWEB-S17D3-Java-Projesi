package com.workintech.zoo.entity;


import lombok.Data;

@Data

public class Kangaroo extends Animal {

    private double height;

    private boolean isAggresive;

    public Kangaroo (int id, String name, double weight, Gender gender, double height, boolean isAggresive){
        super(id, name, weight,gender);
        this.height = height;
        this.isAggresive = isAggresive;
    }
}
