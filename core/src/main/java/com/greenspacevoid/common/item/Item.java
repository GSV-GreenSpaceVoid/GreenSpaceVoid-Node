package com.greenspacevoid.common.item;

public class Item {
    String name;
    double baseVolume, totalVolume; //basevolume * quantity = totalvolume
    int quantity;


    public Item(String name, double baseVolume){
        this.name = name;
        this.baseVolume = baseVolume;






    }

    public Item(String name, double baseVolume, int quantity){
        this.name = name;
        this.baseVolume = baseVolume;
        //Todo: Calculate total volume based on quantity!





    }


















}
