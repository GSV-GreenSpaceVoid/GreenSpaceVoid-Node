package com.greenspacevoidnode.common.core.entity.vessel.ship;

import com.greenspacevoidnode.common.core.entity.vessel.Vessel;
import com.greenspacevoidnode.common.player.Player;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Ship extends Vessel {




    private Class blueprintClass;


    public Ship(String name, long systemID, long x, long y, double volume, boolean isInvincible, boolean isTargetable, boolean canMove, double baseCargoCapacity) {
        super(name, systemID, x, y, volume, isInvincible, isTargetable, canMove, baseCargoCapacity);
    }


















}
