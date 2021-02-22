package com.greenspacevoid.entity;

import com.greenspacevoid.system.StarSystem;

public class Entity {
    //Literally anything!
    String name;
    double x, y, direction;
    boolean targetable;

    public Entity(String name, double x, double y,  boolean targetable){
        this.name = name;
        this.x = x;
        this.y = y;
        this.direction = 0;
        this.targetable = targetable;

    }


    public StarSystem getStarSystem(){
        //Todo: Find which Arraylist(System) this entity exists in.
        for(StarSystem system:StarSystem.StarSystems){

            for(Entity entity : system.getEntities()){

                if(entity.equals(this)) {
                    return system;
                }
            }
        }
        System.out.println("We may have a memory leak on board...");
        return null; //Yikes if this gets here.

    }


    public void update(){//Before kingdoms can change, men must change - Isaiah probably









    }







    public void setName(String name) {
        this.name = name;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public void setTargetable(boolean targetable) {
        this.targetable = targetable;
    }

    public String getName() {
        return name;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getDirection() {
        return direction;
    }

    public boolean isTargetable() {
        return targetable;
    }

    public enum EntityTypes{//Enumerations may be deprecated due to instanceOf
        VESSEL,
        ASTEROID,
        PLANET,
        STAR,
        RESOURCE_SPAWNER, //World spawners represent asteroid(or other resource<s>) field destinations










    }












}
