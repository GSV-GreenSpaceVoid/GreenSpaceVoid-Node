package com.greenspacevoid.entity;

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









    public enum EntityTypes{//Enumerations may be deprecated due to instanceOf
        VESSEL,
        ASTEROID,
        PLANET,
        STAR,
        RESOURCE_SPAWNER, //World spawners represent asteroid(or other resource<s>) field destinations










    }












}
