package com.greenspacevoidnode.common.core.item.modules.weapons;

import com.greenspacevoidnode.common.core.entity.Entity;
import com.greenspacevoidnode.common.core.item.modules.Module;
public class Weapon extends Module{



    private boolean usesCharges;
    private Class munition;//Munition type.
    private Entity target;


    private double baseDamageOutput;
    private double currentDamageOutput;
    private int baseReloadSpeed; //In Millis
    private int currentReloadSpeed;
    private int basePowerConsumption;


    boolean isReloading;
    boolean canFire;
    boolean repeat;

    public Weapon(String name, double baseVolume, int quantity, int size) {
        super(name, baseVolume, quantity, size);
    }


    public void fire(){

    }

    public void reload(){





    }


    public Entity getTarget() {
        return target;
    }

    public void setTarget(Entity target) {
        this.target = target;
    }
}
