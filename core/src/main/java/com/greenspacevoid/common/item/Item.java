package com.greenspacevoid.common.item;

public class Item {
    String name;
    double baseVolume;
    double totalVolume;
    double totalMass; //basevolume * quantity = totalvolume
    int quantity;


    public Item(String name, double baseVolume, int quantity){
        this.name = name;
        this.baseVolume = baseVolume;
        //this.baseMass = baseMass;

        if(quantity <= 0){
            this.quantity = 1;
        }
        this.quantity = quantity;
        //Todo: Calculate total volume/mass based on quantity!





    }


















}
