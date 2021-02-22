package com.greenspacevoid.entity.world;

import com.greenspacevoid.entity.Entity;

public class ResourceSpawners extends WorldEntity {
    private static final boolean targetable = false;
    int ResourceNodeCount; //Asteroids, gas clouds, iceballs, the works
    SpawnerType type = SpawnerType.MIXED;





    public ResourceSpawners(String name, double x, double y) {

        name += name +
        super(name, x, y, targetable);
    }



    public void generateResources(){

        //Todo: lots of randoms n stuff





    }



    //Resource field variants below:

    public static class AsteroidFieldSpawner extends ResourceSpawners{


        public AsteroidFieldSpawner(String name, double x, double y) {
            super(name, x, y);
        }
    }


    public enum SpawnerType{
        ASTEROID =
        ICE,
        GAS,
        MIXED,

    }







}
