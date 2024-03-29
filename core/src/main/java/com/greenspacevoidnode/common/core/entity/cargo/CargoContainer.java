package com.greenspacevoidnode.common.core.entity.cargo;

import com.greenspacevoidnode.common.core.entity.Entity;
import com.greenspacevoidnode.common.core.item.Hold;

import javax.persistence.*;

@MappedSuperclass
public class CargoContainer extends Entity {

    private static final boolean isInvincible = true;
    private static final boolean isTargetable = true;
    private static final boolean canMove = true;

    Hold hold;

    @Column(name = "owner")
    private long playerID;

    //Todo: Create player!

    @Column(name = "holdID")
    private long cargoHoldID;




    private CargoContainer(String name, long systemID, long x, long y, Hold hold) {
        super(name, systemID, x, y, isInvincible, isTargetable, canMove);
        this.hold = hold;


    }

    @javax.persistence.Entity
    public static class SmallCargoContainer extends CargoContainer{
        private static final String name = "Small Cargo Container";
        private static final double cargoHoldSpace = 500;




        public SmallCargoContainer(long systemID, long x, long y) {
            super(name, systemID,x, y, new Hold(cargoHoldSpace));
        }
    }

    @javax.persistence.Entity
    public static class MediumCargoContainer extends CargoContainer{
        private static final String name = "Medium Cargo Container";
        private static final double cargoHoldSpace = 1000;

        public MediumCargoContainer(long systemID, long x, long y) {
            super(name, systemID, x, y, new Hold(cargoHoldSpace));
        }
    }

    @javax.persistence.Entity
    public static class LargeCargoContainer extends CargoContainer {
        private static final String name = "Large Cargo Container";
        private static final double cargoHoldSpace = 2500;

        public LargeCargoContainer(long systemID, long x, long y) {
            super(name, systemID, x, y, new Hold(cargoHoldSpace));
        }
    }

    @javax.persistence.Entity
    public static class CapitalCargoContainer extends CargoContainer{
        private static final String name = "Capital Cargo Container";
        private static final double cargoHoldSpace = 5000;

        public CapitalCargoContainer(long systemID, long x, long y) {
            super(name, systemID, x, y, new Hold(cargoHoldSpace));
        }
    }

    @javax.persistence.Entity
    public static class OreContainer extends CargoContainer{
        private static final String name = "Capital Cargo Container";
        private static final double oreHoldSpace = 30000;

        public OreContainer(long systemID, long x, long y) {
            super(name, systemID, x, y, new Hold(oreHoldSpace));
        }
    }










}
