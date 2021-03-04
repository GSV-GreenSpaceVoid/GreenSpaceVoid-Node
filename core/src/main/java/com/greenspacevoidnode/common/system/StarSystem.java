package com.greenspacevoidnode.common.system;

import com.greenspacevoidnode.common.entity.Entity;

import java.util.ArrayList;

public class StarSystem {
    public static ArrayList<StarSystem> StarSystems = new ArrayList<>();



    String name;
    double securityLevel;
    ArrayList<Entity> entities = new ArrayList<>();
    //Galactic coordinates
    double LYX, LYY;

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

    public double getLYX() {
        return LYX;
    }

    public double getLYY() {
        return LYY;
    }
}
