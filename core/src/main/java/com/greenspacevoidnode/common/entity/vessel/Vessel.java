package com.greenspacevoidnode.common.entity.vessel;

import com.greenspacevoidnode.common.entity.Entity;
import com.greenspacevoidnode.common.item.Item;

public class Vessel extends Entity {



    //TODO: REPEAT AFTER ME! I WILL NOT AND SHALL NOT INCLUDE BASEVALUES EVER(!!!!) IN THE DATABASE!

    Class blueprintClass;



    double volume;

    boolean canMove;

    //Base(Constructor initialized)
    double baseStructureHP, baseHullHP, baseShieldHP;
    double baseShieldRegenerationRate;

    double baseStructureEnergyResist, baseStructureThermalResist, baseStructureEMPResist, baseStructureExplosiveResist;
    double baseHullEnergyResist, baseHullThermalResist, baseHullEMPResist, baseHullExplosiveResist;
    double baseShieldEnergyResist, baseShieldThermalResist, baseShieldEMPResist, baseShieldExplosiveResist;


    double baseSensorStrength, baseSensorRadius, baseSignatureStrength, baseSignatureRadius;

    double basePowerGrid, baseCapacitorCapacity, baseCapacitorRegenerationRate;

    double baseInertiaModifier, baseSpeed;

    int hullModuleSlots, shieldModuleSlots, weaponModuleSlots, miningSlots, weaponSlots, maxTargets;

    double baseRailGunDamageModifier, baseMissileDamageModifier, baseLaserDamageModifier, baseArtilleryDamageModifier, baseMiningYieldModifier;
    double baseRailGunROFModifier, baseMissileROFModifier, baseLaserROFModifier, baseArtilleryROFModifier, baseMiningROFModifier;

    double baseDroneControlRange, maxNumberOfDrones;
    double baseDroneDamageModifier, baseDroneDefenseModifier,baseDroneSpeedModifier, baseDroneRateOfFireModifier, baseDroneMiningYieldModifier;








    //Current
    double currentStructureHP, currentHullHP, currentShieldHP;
    double currentShieldRegenerationRate;

    double currentStructureEnergyResist, currentStructureThermalResist, currentStructureEMPResist, currentStructureExplosiveResist;
    double currentHullEnergyResist, currentHullThermalResist, currentHullEMPResist, currentHullExplosiveResist;
    double currentShieldEnergyResist, currentShieldThermalResist, currentShieldEMPResist, currentShieldExplosiveResist;


    double currentSensorStrength, currentSensorRadius, currentSignatureStrength, currentSignatureRadius;

    double currentPowerGrid, currentCapacitorCapacity, currentCapacitorRegenerationRate;

    double currentInertiaModifier, currentSpeed;

    int currentHullModuleCount, currentShieldModuleCount, currentWeaponModuleCount, currentMiningModuleCount;

    //Calculated maxes
    double maxStructureHP, maxHullHP, maxShieldHP;
    double maxShieldRegenerationRate;

    double maxStructureEnergyResist, maxStructureThermalResist, maxStructureEMPResist, maxStructureExplosiveResist;
    double maxHullEnergyResist, maxHullThermalResist, maxHullEMPResist, maxHullExplosiveResist;
    double maxShieldEnergyResist, maxShieldThermalResist, maxShieldEMPResist, maxShieldExplosiveResist;


    double maxSensorStrength, maxSensorRadius, maxSignatureStrength, maxSignatureRadius;

    double maxPowerGrid, maxCapacitorCapacity, maxCapacitorRegenerationRate;

    double maxInertiaModifier, maxSpeed;



    Item.CargoHold cargoHold;




    //Lists
    //Todo: Implement modules
    /*
    ArrayList<> weaponModules = new ArrayList<Module>();
    ArrayList<Module> shieldModules = new ArrayList<Module>();
    ArrayList<Module> hullModules = new ArrayList<Module>();
    ArrayList<Module> miningModules = new ArrayList<Module>();

    ArrayList<Weapon> weapons = new ArrayList<Weapon>();

    ArrayList<Entity> targets = new ArrayList<Entity>();
    */








    public Vessel(String name, double x, double y, double volume, boolean isInvincible, boolean isTargetable, boolean canMove, double baseCargoCapacity) {
        super(name, x, y, isInvincible, isTargetable, canMove);
            cargoHold = new Item.CargoHold(baseCargoCapacity);



        this.volume = volume;
    }











}
