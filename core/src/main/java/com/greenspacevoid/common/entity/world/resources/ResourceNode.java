package com.greenspacevoid.common.entity.world.resources;

import com.greenspacevoid.common.entity.world.WorldEntity;

public class ResourceNode extends WorldEntity {

    static final String name = "Asteroid";

    public ResourceNode(String name, double x, double y, boolean isInvincible, boolean isTargetable, boolean canMove) {
        super(name, x, y, isInvincible, isTargetable, canMove);



        //Create generator code


    }


    public enum Resources{
        //Asteroid
        TITANIUM,
        STEEL,
        DILITHIUM,


        //










    }




}
