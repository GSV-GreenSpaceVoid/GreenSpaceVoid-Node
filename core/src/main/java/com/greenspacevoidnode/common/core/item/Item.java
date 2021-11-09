package com.greenspacevoidnode.common.core.item;

import com.greenspacevoidnode.common.core.Identifiable;
import com.greenspacevoidnode.sql.Saveable;

import javax.persistence.*;


@MappedSuperclass
public abstract class Item implements Saveable, Identifiable {

    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;//This may be redundant as this is an item. But so be it...

    private int UUID;

    private double baseVolume, volume; //Computed/onJar values values. No need for database access.




    @Column(name = "quantity")
    private int quantity;


    public Item(String name, double basevolume, int quantity){
        this.name = name;
        this.baseVolume = basevolume;
        //this.baseMass = baseMass;

        if(quantity <= 0){//No zero quantities around here!
            this.quantity = 1;
        }else {
            this.quantity = quantity;
        }
    }








     //public void stack(){


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getBaseVolume() {
        return baseVolume;
    }

    public void setBaseVolume(double baseVolume) {
        this.baseVolume = baseVolume;
    }

    public double getVolume() {

        if (volume <= 0){
            return baseVolume;
        }

        return volume;
    }


    public int getQuantity() {
        return quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }




}
