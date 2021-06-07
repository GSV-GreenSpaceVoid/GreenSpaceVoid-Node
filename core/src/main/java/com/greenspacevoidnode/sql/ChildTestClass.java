package com.greenspacevoidnode.sql;

import javax.persistence.*;


@MappedSuperclass
public class ChildTestClass extends TestClass{
    private static final String childTestClassName = "My buddy!";


    @Column(name = "shipname")
    private String shipname;


    public ChildTestClass(){




    }

    public ChildTestClass(String name, int hullHP, int armorHP, int shieldHP, int powerlevel){
        super(name, hullHP, armorHP, shieldHP, powerlevel);
        shipname = childTestClassName;



    }


    public String getShipname() {
        return shipname;
    }

    public void setShipname(String shipname) {
        this.shipname = shipname;
    }
}
