package com.greenspacevoid.common.entity.world.resources;

import com.greenspacevoid.common.entity.world.WorldEntity;

public class ResourceNode extends WorldEntity {

    static final String name = "Asteroid";







    public ResourceNode(double x, double y, boolean targetable) {
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
