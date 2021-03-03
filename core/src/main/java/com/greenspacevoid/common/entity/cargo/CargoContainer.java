package com.greenspacevoid.common.entity.cargo;

import com.greenspacevoid.common.entity.Entity;
import com.greenspacevoid.common.item.Item;

public class CargoContainer extends Entity {

    private static final boolean isInvincible = true;
    private static final boolean isTargetable = true;
    private static final boolean canMove = true;

    Item.CargoHold cargoHold;





    private CargoContainer(String name, double x, double y, Item.CargoHold cargoHold) {
        super(name, x, y, isInvincible, isTargetable, canMove);
        this.cargoHold = cargoHold;


    }


    public static class SmallCargoContainer extends CargoContainer{
        private static final String name = "Small Cargo Container";
        private static final double cargoHoldSpace = 500;




        public SmallCargoContainer(double x, double y) {
            super(name, x, y, new Item.CargoHold(cargoHoldSpace));
        }
    }


    public static class MediumCargoContainer extends CargoContainer{
        private static final String name = "Medium Cargo Container";
        private static final double cargoHoldSpace = 1000;

        public MediumCargoContainer(double x, double y) {
            super(name, x, y, new Item.CargoHold(cargoHoldSpace));
        }
    }


    public static class LargeCargoContainer extends CargoContainer{
        private static final String name = "Large Cargo Container";
        private static final double cargoHoldSpace = 2500;

        public LargeCargoContainer(double x, double y) {
            super(name, x, y, new Item.CargoHold(cargoHoldSpace));
        }
    }

    public static class CapitalCargoContainer extends CargoContainer{
        private static final String name = "Capital Cargo Container";
        private static final double cargoHoldSpace = 5000;

        public CapitalCargoContainer(double x, double y) {
            super(name, x, y, new Item.CargoHold(cargoHoldSpace));
        }
    }

    public static class OreContainer extends CargoContainer{
        private static final String name = "Capital Cargo Container";
        private static final double oreHoldSpace = 30000;

        public OreContainer(double x, double y) {
            super(name, x, y, new Item.OreHold(oreHoldSpace));
        }
    }










}
