package com.greenspacevoid.common.entity.cargo;

import com.greenspacevoid.common.entity.Entity;
import com.greenspacevoid.common.item.Item;

public class CargoContainer extends Entity {

    private static final boolean isInvincible = true;
    private static final boolean isTargetable = true;
    private static final boolean canMove = true;

    Item.CargoHold cargoHold;





    private CargoContainer(String name, double x, double y, double cargoHoldSpace) {
        super(name, x, y, isInvincible, isTargetable, canMove);
        cargoHold = new Item.CargoHold(cargoHoldSpace);


    }


    public static class SmallCargoContainer{









    }


    public static class MediumCargoContainer{








    }


    public static class LargeCargoContainer{








    }

    public static class CapitalCargoContainer{








    }

    public static class CapitalCargoContainer{








    }










}
