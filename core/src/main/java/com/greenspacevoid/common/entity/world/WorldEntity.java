package com.greenspacevoid.common.entity.world;

import com.greenspacevoid.common.entity.Entity;

public class WorldEntity extends Entity {


    public WorldEntity(String name, double x, double y, boolean isInvincible, boolean isTargetable, boolean canMove) {
        super(name, x, y, isInvincible, isTargetable, canMove);
    }
}