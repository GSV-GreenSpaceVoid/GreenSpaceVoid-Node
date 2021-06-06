package com.greenspacevoidnode.sql;


public class TestClass{
    private int id;
    private int hullHP, armorHP, shieldHP;
    private String name;


    public TestClass(String name, int hullHP, int armorHP, int shieldHP){
        this.hullHP = hullHP;
        this.armorHP = armorHP;
        this.shieldHP = shieldHP;
        this.name = name;



    }


    public int getHullHP() {
        return hullHP;
    }

    public int getArmorHP() {
        return armorHP;
    }

    public int getId() {
        return id;
    }





    public void setId(int id) {
        this.id = id;
    }

    public int getShieldHP() {
        return shieldHP;
    }

    public String getName() {
        return name;
    }
}










