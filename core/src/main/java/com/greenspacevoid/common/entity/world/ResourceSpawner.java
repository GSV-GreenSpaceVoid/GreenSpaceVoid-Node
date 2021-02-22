package com.greenspacevoid.common.entity.world;

import com.greenspacevoid.system.StarSystem;

public class ResourceSpawner extends WorldEntity {

    public enum SpawnerType{
        ASTEROID,
        ICE,
        GAS,
        MIXED,

    }
    private static final int resourceNodeCap = 300;
    private int maxResourceNodeCount;
    private static final boolean targetable = false;


    int resourceNodeCount; //Asteroids, gas clouds, iceballs, the works|We will try and limit this to <300
    static String name = "Multi-Resource Field";
    double securityLevel; //Determines resource rarity.
    SpawnerType type = SpawnerType.MIXED;


    public ResourceSpawner(double x, double y, SpawnerType type) {
        super(name, x, y, targetable);

        update();//Sets important data such as name and security level.

        //<System name> + <to be implemented(celestial body name) + <FieldType name> + <?(number)

    }







    @Override
    public void update() {//Keeps things up to date when kingdoms change.
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








    //Resource field variants below:

    public static class AsteroidFieldSpawner extends ResourceSpawner {
        private static final SpawnerType type = SpawnerType.ASTEROID;

        public AsteroidFieldSpawner(double x, double y) {
            super(x, y, type);
        }
    }

    public static class IceFieldSpawner extends ResourceSpawner {
        private static final SpawnerType type = SpawnerType.ICE;

        public IceFieldSpawner(double x, double y) {
            super(x, y, type);
        }
    }

    public static class GasFieldSpawner extends ResourceSpawner {
        private static final SpawnerType type = SpawnerType.GAS;

        public GasFieldSpawner(double x, double y) {
            super(x, y, type);
        }
    }

    public static class MixedResourceFieldSpawner extends ResourceSpawner {
        private static final SpawnerType type = SpawnerType.MIXED;

        public MixedResourceFieldSpawner(double x, double y) {
            super(x, y, type);
        }
    }














}
