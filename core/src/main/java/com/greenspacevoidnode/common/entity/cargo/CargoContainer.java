package com.greenspacevoidnode.common.entity.cargo;

import com.greenspacevoidnode.common.entity.Entity;
import com.greenspacevoidnode.common.item.Item;

import javax.persistence.*;

@MappedSuperclass
public class CargoContainer extends Entity {

    private static final boolean isInvincible = true;
    private static final boolean isTargetable = true;
    private static final boolean canMove = true;

    Item.GenericHold genericHold;

    @Column(name = "owner")
    private long playerID;

    //Todo: Create player!

    @Column(name = "holdID")
    private long cargoHoldID;




    private CargoContainer(String name, double x, double y, Item.GenericHold genericHold) {
        super(name, x, y, isInvincible, isTargetable, canMove);
        this.genericHold = genericHold;


    }

    @javax.persistence.Entity
    public static class SmallCargoContainer extends CargoContainer{
        private static final String name = "Small Cargo Container";
        private static final double cargoHoldSpace = 500;




        public SmallCargoContainer(double x, double y) {
            super(name, x, y, new Item.GenericHold(cargoHoldSpace));
        }
    }

    @javax.persistence.Entity
    public static class MediumCargoContainer extends CargoContainer{
        private static final String name = "Medium Cargo Container";
        private static final double cargoHoldSpace = 1000;

        public MediumCargoContainer(double x, double y) {
            super(name, x, y, new Item.GenericHold(cargoHoldSpace));
        }
    }

    @javax.persistence.Entity
    public static class LargeCargoContainer extends CargoContainer{
        private static final String name = "Large Cargo Container";
        private static final double cargoHoldSpace = 2500;

        public LargeCargoContainer(double x, double y) {
            super(name, x, y, new Item.GenericHold(cargoHoldSpace));
        }
    }

    @javax.persistence.Entity
    public static class CapitalCargoContainer extends CargoContainer{
        private static final String name = "Capital Cargo Container";
        private static final double cargoHoldSpace = 5000;

        public CapitalCargoContainer(double x, double y) {
            super(name, x, y, new Item.GenericHold(cargoHoldSpace));
        }
    }

    @javax.persistence.Entity
    public static class OreContainer extends CargoContainer{
        private static final String name = "Capital Cargo Container";
        private static final double oreHoldSpace = 30000;

        public OreContainer(double x, double y) {
            super(name, x, y, new Item.OreHold(oreHoldSpace));
        }
    }










}
