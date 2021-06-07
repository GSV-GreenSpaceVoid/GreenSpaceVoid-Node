package com.greenspacevoidnode.sql;


import javax.persistence.*;


@MappedSuperclass

public class TestClass{
    @Id @GeneratedValue
    @Column(name = "id")
    private int id;


    @Column(name = "hullHP")
    private int hullHP;
    @Column(name = "armorHP")
    private int armorHP;
    @Column(name = "shieldHP")
    private int shieldHP;




    @Column(name = "name")
    private String name;

    @Column(name = "powerlevel")
    private int powerlevel;

    public TestClass(String name, int hullHP, int armorHP, int shieldHP, int powerlevel){
        this.hullHP = hullHP;
        this.armorHP = armorHP;
        this.shieldHP = shieldHP;
        this.name = name;
        this.powerlevel = powerlevel;


    }

    public TestClass(){

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

    public int getPowerlevel() {
        return powerlevel;
    }

    public void setPowerlevel(int powerlevel) {
        this.powerlevel = powerlevel;
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










