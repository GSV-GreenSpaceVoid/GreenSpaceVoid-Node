package com.greenspacevoidnode.common.entities.faction.israel.ship.military.fighter;

import com.greenspacevoidnode.common.core.entity.vessel.ship.Ship;

public class Gideon extends Ship {

    private static double baseStructureHP = 100;
    private static double baseHullHP = 100;
    private static double baseShieldHP = 0;
    private static double baseShieldRegenerationRate = 0;

    private static double baseStructureEnergyResist = 0.05;
    private static double baseStructureThermalResist = 0.05;
    private static double baseStructureEMPResist = 0.05;
    private static double baseStructureExplosiveResist = 0.05;
    private static double baseHullEnergyResist = 0.05;
    private static double baseHullThermalResist = 0.05;
    private static double baseHullEMPResist = 0.05;
    private static double baseHullExplosiveResist = 0.05;
    private static double baseShieldEnergyResist = 0.05;
    private static double baseShieldThermalResist = 0.05;
    private static double baseShieldEMPResist = 0.05;
    private static double baseShieldExplosiveResist = 0.05;


    private static double baseSensorStrength = 0.5;
    private static double BaseSensorRadius = 5000;
    private static double baseSignatureStrength = 0.5;
    private static double baseSignatureRadius = 2500;



    





    private static double basePowerGrid = 1000;
    private static double baseCapacitorCapacity = 4000;
    private static double baseCapacitorRegenerationRate = 150;

    private static double baseInertiaModifier = 1;
    private static double baseSpeed = 1000;
    private static double baseAccelerationRate = 0.1;
    private static double baseTurnRate = 20;

    private static double baseCargoHoldCapacity = 100;

    private static int hullModuleSlots = 2;
    private static int armorModuleSlots = 2;
    private static int shieldModuleSlots = 0;
    private static int weaponModuleSlots = 2;
    private static int miningModuleSlots = 0;
    private static int weaponSlots = 4;
    private static int maxTargets = 2;

    private static double baseRailGunDamageModifier = 0;
    private static double baseMissileDamageModifier = 0.2;
    private static double baseLaserDamageModifier = 0;
    private static double baseArtilleryDamageModifier = 0.2;
    private static double baseMiningYieldModifier = 0;
    private static double baseRailGunROFModifier = 0;
    private static double baseMissileROFModifier = 0;
    private static double baseLaserROFModifier = 0;
    private static double baseArtilleryROFModifier = 0;
    private static double baseMiningROFModifier = 0;

    private static double baseDroneControlRange = 0;
    private static double maxNumberOfDrones = 0;
    private static double baseDroneDamageModifier = 0;
    private static double baseDroneDefenseModifier = 0;
    private static double baseDroneSpeedModifier = 0;
    private static double baseDroneRateOfFireModifier = 0;
    private static double baseDroneMiningYieldModifier = 0;





















    public Gideon(String name, long systemID, long x, long y, double volume, boolean isInvincible, boolean isTargetable, boolean canMove, double baseCargoCapacity) {
        super(name, systemID, x, y, volume, isInvincible, isTargetable, canMove, baseCargoCapacity);
    }






























}
