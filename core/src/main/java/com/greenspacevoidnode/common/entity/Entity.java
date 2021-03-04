package com.greenspacevoidnode.common.entity;

import com.greenspacevoidnode.common.system.StarSystem;

public class Entity {
    //Literally anything!
    String name;
    double x, y, direction;
    boolean isInvincible;//Think of as being invincible...
    boolean isTargetable;
    boolean canMove;

    public Entity(String name, double x, double y,  boolean isInvincible, boolean isTargetable, boolean canMove){
        this.name = name;
        this.x = x;
        this.y = y;
        this.direction = 0;
        this.isInvincible = isInvincible;
        this.isTargetable = isTargetable;
        this.canMove = canMove;

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


    public void updateSpawner(){//Before kingdoms can change, men must change - Isaiah probably









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

    public void setInvincible(boolean invincible) {
        this.isInvincible = invincible;
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

    public boolean isInvincible() {
        return isInvincible;
    }

    public enum EntityTypes{//Enumerations may be deprecated due to instanceOf
        VESSEL,
        ASTEROID,
        PLANET,
        STAR,
        RESOURCE_SPAWNER, //World spawners represent asteroid(or other resource<s>) field destinations










    }












    //Todo: Physics
    public void move(double x, double y){//Called whenever the physics engine says so..or if an admin needs to yeet something into oblivion.
        //Mmmm yes physics
        if(canMove) {
            this.x = x;
            this.y = y;
        }


    }



   public void forceMove(double x, double y){
        boolean previousState = this.canMove;
        this.canMove = true;
        move(x,y);
        this.canMove = previousState;

   }

   public void setDirection(double direction){
        this.direction = direction;
   }



   public void updateS(){






   }


}
