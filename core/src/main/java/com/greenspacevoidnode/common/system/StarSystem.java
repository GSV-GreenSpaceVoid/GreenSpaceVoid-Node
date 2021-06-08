package com.greenspacevoidnode.common.system;

import com.greenspacevoidnode.common.entity.Entity;

import javax.persistence.*;


import java.util.ArrayList;

@javax.persistence.Entity
@Table(name = "systemInfo")
public class StarSystem {//It's actually a database B)
    //public static ArrayList<StarSystem> StarSystems = new ArrayList<>();

    public static StarSystem starSystem;




    @Id@GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    String name;
    @Column(name = "securityLevel")
    private double securityLevel;

    @Column(name = "galacticX")
    private double galacticX;

    @Column(name = "galacticY")
    double galacticY;

    ArrayList<Entity> entities; //List by which we store all pointers to our entities.
    //Galactic coordinates


    //Todo: Starcharts B)

    public StarSystem(String name, double securityLevel){
        this.name = name;
        this.securityLevel = securityLevel;
        entities = new ArrayList<>();
    }

    public StarSystem(){
        entities = new ArrayList<>();


    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(double securityLevel) {
        this.securityLevel = securityLevel;
    }

    public double getGalacticX() {
        return galacticX;
    }

    public void setGalacticX(double galacticX) {
        this.galacticX = galacticX;
    }

    public double getGalacticY() {
        return galacticY;
    }

    public void setGalacticY(double galacticY) {
        this.galacticY = galacticY;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }
}
