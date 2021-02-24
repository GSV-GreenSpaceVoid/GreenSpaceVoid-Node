package com.greenspacevoid.common.entity.vessel;

import com.greenspacevoid.common.entity.Entity;
import com.greenspacevoid.common.item.Item;

import java.util.ArrayList;

public class Vessel extends Entity {

    boolean canMove;

    //Base(Constructor initialized)
    double baseStructureHP, baseHullHP, baseShieldHP;
    double baseShieldRegenerationRate;

    double baseStructureEnergyResist, baseStructureThermalResist, baseStructureEMPResist, baseStructureExplosiveResist;
    double baseHullEnergyResist, baseHullThermalResist, baseHullEMPResist, baseHullExplosiveResist;
    double baseShieldEnergyResist, baseShieldThermalResist, baseShieldEMPResist, baseShieldExplosiveResist;

    double baseCargoCapacity;
    double baseSensorStrength, baseSensorRadius, baseSignatureStrength, baseSignatureRadius;

    double basePowerGrid, baseCapacitorCapacity, baseCapacitorRegenerationRate;

    double baseInertiaModifier, baseSpeed;

    int hullModuleSlots, shieldModuleSlots, weaponModuleSlots, miningSlots, weaponSlots, maxTargets;


    //Current
    double currentStructureHP, currentHullHP, currentShieldHP;
    double currentShieldRegenerationRate;

    double currentStructureEnergyResist, currentStructureThermalResist, currentStructureEMPResist, currentStructureExplosiveResist;
    double currentHullEnergyResist, currentHullThermalResist, currentHullEMPResist, currentHullExplosiveResist;
    double currentShieldEnergyResist, currentShieldThermalResist, currentShieldEMPResist, currentShieldExplosiveResist;

    double currentCargoCapacity;
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

    double maxCargoCapacity;
    double maxSensorStrength, maxSensorRadius, maxSignatureStrength, maxSignatureRadius;

    double maxPowerGrid, maxCapacitorCapacity, maxCapacitorRegenerationRate;

    double maxInertiaModifier, maxSpeed;








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








    public Vessel(String name, double x, double y, boolean isInvincible, boolean isTargetable, boolean canMove) {
        super(name, x, y, isInvincible, isTargetable, canMove);
    }













}
