package com.greenspacevoidnode.common.entity.world;

import com.greenspacevoidnode.common.entity.Entity;

public class WorldEntity extends Entity {


    public WorldEntity(String name, long x, long y, boolean isInvincible, boolean isTargetable, boolean canMove) {
        super(name, x, y, isInvincible, isTargetable, canMove);
    }
}