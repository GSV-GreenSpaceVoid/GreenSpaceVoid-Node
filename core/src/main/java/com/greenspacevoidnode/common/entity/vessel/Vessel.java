package com.greenspacevoidnode.common.entity.vessel;

import com.greenspacevoidnode.common.entity.Entity;
import com.greenspacevoidnode.common.item.Hold;
import com.greenspacevoidnode.common.item.modules.Module;

import javax.persistence.*;
import java.util.ArrayList;


@MappedSuperclass
public class Vessel extends Entity {

    @Column(name = "cargoHoldID")
    private long cargoHoldID; //Table reference to this vessel's cargo hold (Screw joins!)





    //TODO: REPEAT AFTER ME! I WILL NOT AND SHALL NOT INCLUDE BASEVALUES EVER(!!!!) IN THE DATABASE!

    Class blueprintClass;



    double volume;



    //Base(Constructor initialized)
    double baseStructureHP, baseHullHP, baseShieldHP;
    double baseShieldRegenerationRate;

    double baseStructureEnergyResist, baseStructureThermalResist, baseStructureEMPResist, baseStructureExplosiveResist;
    double baseHullEnergyResist, baseHullThermalResist, baseHullEMPResist, baseHullExplosiveResist;
    double baseShieldEnergyResist, baseShieldThermalResist, baseShieldEMPResist, baseShieldExplosiveResist;


    double baseSensorStrength, baseSensorRadius, baseSignatureStrength, baseSignatureRadius;

    double basePowerGrid, baseCapacitorCapacity, baseCapacitorRegenerationRate;

    double baseInertiaModifier, baseSpeed, baseTurnRate;

    double baseCargoHoldCapacity;

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

    double currentInertiaModifier, currentSpeed, currentTurnRate;

    int currentHullModuleCount, currentShieldModuleCount, currentWeaponModuleCount, currentMiningModuleCount;

    boolean isPacked;

    //Calculated maxes

    //Maxes can be recomputed upon load, saving database table utilization.

    double maxStructureHP, maxHullHP, maxShieldHP;
    double maxShieldRegenerationRate;

    double maxStructureEnergyResist, maxStructureThermalResist, maxStructureEMPResist, maxStructureExplosiveResist;
    double maxHullEnergyResist, maxHullThermalResist, maxHullEMPResist, maxHullExplosiveResist;
    double maxShieldEnergyResist, maxShieldThermalResist, maxShieldEMPResist, maxShieldExplosiveResist;


    double maxSensorStrength, maxSensorRadius, maxSignatureStrength, maxSignatureRadius;

    double maxPowerGrid, maxCapacitorCapacity, maxCapacitorRegenerationRate;

    double maxInertiaModifier, maxSpeed, maxTurnRate;



    Hold.CargoHold cargoHold;



//            88b           d88                        88               88
//            888b         d888                        88               88
//            88`8b       d8'88                        88               88
//            88 `8b     d8' 88   ,adPPYba,    ,adPPYb,88  88       88  88   ,adPPYba,  ,adPPYba,
//            88  `8b   d8'  88  a8"     "8a  a8"    `Y88  88       88  88  a8P_____88  I8[    ""
//            88   `8b d8'   88  8b       d8  8b       88  88       88  88  8PP"""""""   `"Y8ba,
//            88    `888'    88  "8a,   ,a8"  "8a,   ,d88  "8a,   ,a88  88  "8b,   ,aa  aa    ]8I
//            88     `8'     88   `"YbbdP"'    `"8bbdP"Y8   `"YbbdP'Y8  88   `"Ybbd8"'  `"YbbdP"'


    //Database table reference stuff

    //Stored as tableName:id,

    @Column(name = "shieldModules")
    private String shieldModulesData;
    @Column(name = "armorModules")
    private String armorModulesData;
    @Column(name = "hullModules")
    private String hullModulesData;

    @Column(name = "weaponModules")
    private String weaponModulesData;
    @Column(name = "miningModules")
    private String miningModulesData;

    @Column(name = "weapons")
    private String weaponsData;










    ArrayList<Module> shieldModules = new ArrayList<>();
    ArrayList<Module> armorModules = new ArrayList<>();
    ArrayList<Module> hullModules = new ArrayList<>();

    ArrayList<Module> weaponModules = new ArrayList<>();
    ArrayList<Module> miningModules = new ArrayList<>();

    ArrayList<Module> weapons = new ArrayList<>();

    @Override
    public Long save() {
        shieldModulesData = "";
        armorModulesData = "";
        hullModulesData = "";
        weaponModulesData = "";
        miningModulesData = "";
        weaponsData = "";

        for(Module module : shieldModules){

            shieldModulesData = module.getClass().getSimpleName() + ":" + module.getId() + ",";
        }

        for(Module module : armorModules){
            armorModulesData = module.getClass().getSimpleName() + ":" + module.getId() + ",";
        }

        for(Module module : hullModules){
            hullModulesData = module.getClass().getSimpleName() + ":" + module.getId() + ",";
        }

        for(Module module : weaponModules){
            weaponModulesData = module.getClass().getSimpleName() + ":" + module.getId() + ",";
        }

        for(Module module : weaponModules){
            weaponModulesData = module.getClass().getSimpleName() + ":" + module.getId() + ","; //Mapping. This will be necessary for generation
        }

        for(Module module : miningModules){
            miningModulesData = module.getClass().getSimpleName() + ":" + module.getId() + ","; //Mapping. This will be necessary for generation
        }

        for(Module module : weapons){
            weaponsData = module.getClass().getSimpleName() + ":" + module.getId() + ","; //Mapping. This will be necessary for generation
        }


        cargoHoldID = cargoHold.save();


        return super.save();
    }

    public String getShieldModulesData() {
        return shieldModulesData;
    }

    public void setShieldModulesData(String shieldModulesData) {
        this.shieldModulesData = shieldModulesData;
    }

    public String getArmorModulesData() {
        return armorModulesData;
    }

    public void setArmorModulesData(String armorModulesData) {
        this.armorModulesData = armorModulesData;
    }

    public String getHullModulesData() {
        return hullModulesData;
    }

    public void setHullModulesData(String hullModulesData) {
        this.hullModulesData = hullModulesData;
    }

    public String getWeaponModulesData() {
        return weaponModulesData;
    }

    public void setWeaponModulesData(String weaponModulesData) {
        this.weaponModulesData = weaponModulesData;
    }

    public String getMiningModulesData() {
        return miningModulesData;
    }

    public void setMiningModulesData(String miningModulesData) {
        this.miningModulesData = miningModulesData;
    }

    public String getWeaponsData() {
        return weaponsData;
    }

    public void setWeaponsData(String weaponsData) {
        this.weaponsData = weaponsData;
    }

    public Vessel(String name, long x, long y, double volume, boolean isInvincible, boolean isTargetable, boolean canMove, double baseCargoCapacity) {
        super(name, x, y, isInvincible, isTargetable, canMove);
            Hold.CargoHold cargoHold = new Hold.CargoHold(baseCargoCapacity);



        this.volume = volume;
    }










}
