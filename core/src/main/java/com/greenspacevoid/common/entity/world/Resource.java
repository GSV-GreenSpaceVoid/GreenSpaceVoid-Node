package com.greenspacevoid.common.entity.world;

public class Resource extends WorldEntity{

    static final String name = "Asteroid";







    public Resource(double x, double y, boolean targetable) {
        //Todo: Create tons of wonky code that allows for efficient asteroid generation B)





        super(name,x, y, targetable);
    }



    public enum Resources{
        //Asteroid
        TITANIUM,
        STEEL,
        DILITHIUM,


        //










    }




}
