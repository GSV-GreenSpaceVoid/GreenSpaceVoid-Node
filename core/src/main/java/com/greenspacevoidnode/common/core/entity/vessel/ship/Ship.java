package com.greenspacevoidnode.common.core.entity.vessel.ship;

import com.greenspacevoidnode.common.core.entity.vessel.Vessel;
import com.greenspacevoidnode.common.player.Player;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Ship extends Vessel {



    private Player player;

    @Column(name = "playerID")
    private long playerID;

    public Ship(String name, long x, long y, double volume, boolean isInvincible, boolean isTargetable, boolean canMove, double baseCargoCapacity) {
        super(name, x, y, volume, isInvincible, isTargetable, canMove, baseCargoCapacity);
    }
























}
