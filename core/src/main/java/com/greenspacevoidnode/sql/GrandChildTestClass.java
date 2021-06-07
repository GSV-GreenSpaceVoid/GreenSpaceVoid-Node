package com.greenspacevoidnode.sql;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "grandchildtest")
public class GrandChildTestClass extends ChildTestClass{



    @Column(name = "chadnumber")
    private int chadnumber;


    public GrandChildTestClass(String name, int hullHP, int armorHP, int shieldHP, int powerlevel) {
        super(name, hullHP, armorHP, shieldHP, powerlevel);
        chadnumber = 365;
    }

    public GrandChildTestClass(){

    }

    public int getChadnumber() {
        return chadnumber;
    }

    public void setChadnumber(int chadnumber) {
        this.chadnumber = chadnumber;
    }
}
