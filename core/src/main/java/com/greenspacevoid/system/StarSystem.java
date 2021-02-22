package com.greenspacevoid.system;

import com.greenspacevoid.entity.Entity;

import java.util.ArrayList;

public class StarSystem {
    public static ArrayList<StarSystem> StarSystems = new ArrayList<>();



    String name;
    double securityLevel;
    ArrayList<Entity> entities = new ArrayList<>();
    //Todo: Starcharts B)

    public StarSystem(String name, double securityLevel){
        this.name = name;
        this.securityLevel = securityLevel;
    }

    public String getName() {
        return name;
    }

    public double getSecurityLevel() {
        return securityLevel;
    }

    public ArrayList<Entity> getEntities() {//Returns an arraylist don't forget...
        return entities;
    }
}
