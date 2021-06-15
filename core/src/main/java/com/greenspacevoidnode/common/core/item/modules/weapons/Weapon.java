package com.greenspacevoidnode.common.core.item.modules.weapons;

import com.greenspacevoidnode.common.Sizes;
import com.greenspacevoidnode.common.core.item.modules.Module;
public class Weapon extends Module{



    private boolean usesCharges;
    private Class munition;//Munition type.



    private double baseDamageOutput;
    private double currentDamageOutput;
    private int baseReloadSpeed; //In Millis
    private int currentReloadSpeed;
    private int basePowerConsumption;


    boolean isReloading;
    boolean canFire;







    public Weapon(String name, double baseVolume, int quantity, Sizes size) {
        super(name, baseVolume, quantity, size);
    }



    public void fire(){





    }

    public void reload(){





    }







}
