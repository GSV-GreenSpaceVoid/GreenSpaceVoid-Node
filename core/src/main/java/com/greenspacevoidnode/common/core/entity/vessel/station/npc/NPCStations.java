package com.greenspacevoidnode.common.core.entity.vessel.station.npc;

import com.greenspacevoidnode.common.core.entity.vessel.station.Station;

public abstract class NPCStations extends Station {
    private static final double volume = 1;
    private static final boolean isInvincible = true;
    private static final boolean isTargetable = false;
    private static final boolean canMove = false;


    public NPCStations(String name, long systemID, long x, long y) {
        super(name, systemID, x, y, volume, isInvincible, isTargetable, canMove);
    }
























}
