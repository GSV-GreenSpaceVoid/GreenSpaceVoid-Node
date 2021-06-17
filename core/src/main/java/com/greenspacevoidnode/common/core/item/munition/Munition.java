package com.greenspacevoidnode.common.core.item.munition;

import com.greenspacevoidnode.common.Sizes;
import com.greenspacevoidnode.common.core.item.Item;
import com.greenspacevoidnode.common.core.item.modules.weapons.DamageTypes;

public class Munition extends Item {

    private DamageTypes damageType;
    private Sizes munitionSize;

    private double damage, range;





    public Munition(String name, double basevolume, int quantity) {
        super(name, basevolume, quantity);
    }



    public static class ArtilleryShell{



    }


    public static class LaserCrystal{


    }

    public static class MiningCrystal{
        private int durability;


    }

    public static class Missile{



    }









}
