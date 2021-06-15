package com.greenspacevoidnode.common.core.entity.world.resources;

import com.greenspacevoidnode.common.core.entity.Entity;
import com.greenspacevoidnode.common.core.entity.world.WorldEntity;
import com.greenspacevoidnode.common.system.StarSystem;

import javax.persistence.MappedSuperclass;


@MappedSuperclass
public class ResourceSpawner extends WorldEntity {

    private static boolean isInvincible = true;
    private static boolean isTargetable = false;
    private static boolean canMove = false;


    public ResourceSpawner(long x, long y) {
        super(name, x, y, isInvincible, isTargetable, canMove);

        //updateSpawner();

    }

    private static final int resourceNodeCap = 300;
    private static final int resourceFieldRadius = 30000;

    private int maxResourceNodeCount;
    private static final boolean targetable = false;


    int resourceNodeCount; //Asteroids, gas clouds, iceballs, the works|We will try and limit this to <300
    static String name = "Multi-Resource Field";



    double securityLevel; //Determines resource rarity.



    public void countResources(){

        double thisPosX = this.getX();
        double thisPosY = this.getY();




        for(Entity entity : StarSystem.starSystem.getEntities()){
            if(entity instanceof ResourceNode){
                if(Math.sqrt(Math.pow(entity.getX() - thisPosX, 2) + Math.pow(entity.getY() - thisPosY, 2)) < resourceFieldRadius) {//Distance formula B)
                    resourceNodeCount++;
                }
            }
        }




    }







    /*
    public void updateSpawner() {//Keeps things up to date when kingdoms change.
        StarSystem starSystem = this.getStarSystem();
        try {
            name = starSystem.getName();
            this.securityLevel = starSystem.getSecurityLevel();

        }catch(Exception ignored){
            System.out.println("ERROR: Something went wrong. An asteroid field was created OUTSIDE of a system or a system has an invalid securityLevel." +
                    "Setting security level to 1.0");
            this.securityLevel = 1.0;
        }

        maxResourceNodeCount = (int)(Math.abs(1.1 - securityLevel) * resourceNodeCap);
        switch(type){
            case ASTEROID:
                name += " Asteroid Field";
            case GAS:
                name += " Gas Nebula";
            case ICE:
                name += " Ice Field";
            case MIXED:
                name += " Multi-Resource Field";
            default:
                name += " Multi-Resource Field";
        }
        this.setName(name);
    }
    */






    /*
    public void generateResources(){//May overload..Who knows
        //Override stub method
        //Todo: lots of randoms n stuff
        int count = 0;

        switch(this.type){
            case ASTEROID:
                for(int i = resourceNodeCount; i < Math.random() * (maxResourceNodeCount - resourceNodeCount); i++){
                    //Generate roids!
                    count++;
                }
            case ICE:
                for(int i = resourceNodeCount; i < Math.random() * (maxResourceNodeCount - resourceNodeCount); i++){
                    //Generate ice!
                    count++;
                }
            case GAS:
                for(int i = resourceNodeCount; i < Math.random() * (maxResourceNodeCount - resourceNodeCount); i++){
                    //Generate gas!
                    count++;
                }
            case MIXED:
                for(int i = resourceNodeCount; i < Math.random() * (maxResourceNodeCount - resourceNodeCount); i++){
                    //Generate everything!
                    count++;
                }
            default:
                for(int i = resourceNodeCount; i < Math.random() * (maxResourceNodeCount - resourceNodeCount); i++){
                    //Generate roids!
                    count++;
                }
        }
        resourceNodeCount = count;
    }

    */






    //Resource field variants below:

    public static class AsteroidFieldSpawner extends ResourceSpawner {


        public AsteroidFieldSpawner(long x, long y) {
            super(x, y);
        }
    }

    public static class IceFieldSpawner extends ResourceSpawner {


        public IceFieldSpawner(long x, long y) {
            super(x, y);
        }
    }

    public static class GasFieldSpawner extends ResourceSpawner {



        public GasFieldSpawner(long x, long y) {
            super(x, y);
        }
    }

    public static class MixedResourceFieldSpawner extends ResourceSpawner {


        public MixedResourceFieldSpawner(long x, long y) {
            super(x, y);
        }
    }














}
