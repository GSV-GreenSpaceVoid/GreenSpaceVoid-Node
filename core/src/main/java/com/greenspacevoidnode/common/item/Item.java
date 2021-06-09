package com.greenspacevoidnode.common.item;

import com.greenspacevoidnode.common.item.industry.resources.Resource;
import com.greenspacevoidnode.engine.exceptions.ErrorMessages;
import com.greenspacevoidnode.sql.SQL;
import com.greenspacevoidnode.sql.Saveable;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.*;
import java.util.ArrayList;






@MappedSuperclass
public class Item implements Saveable {

    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;//This may be redundant as this is an item. But so be it...


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



        this.save();
    }


    public void update(){
        /*Todo: This method is called in every grandchild class.




         */







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


    @Override
    public Long save() {
        return Saveable.super.save();
    }
}
