package com.greenspacevoidnode.sql;


import javax.persistence.*;

@Entity
@Table(name = "otherclass")
public class OtherGrandChildClass extends ChildTestClass{

    @Column(name = "unga")
    private String unga;


    public OtherGrandChildClass() {
    }

    public OtherGrandChildClass(String name, int hullHP, int armorHP, int shieldHP, int powerlevel) {
        super(name, hullHP, armorHP, shieldHP, powerlevel);
        unga = "UNGA!";
    }


    public String getUnga() {
        return unga;
    }

    public void setUnga(String unga) {
        this.unga = unga;
    }
}
