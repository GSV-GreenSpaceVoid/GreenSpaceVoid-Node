package com.greenspacevoidnode.common.entity.vessel;

import com.greenspacevoidnode.common.entity.Entity;
import com.greenspacevoidnode.common.item.Hold;
import com.greenspacevoidnode.common.item.modules.Module;
import com.greenspacevoidnode.common.item.modules.weapons.Weapon;
import com.greenspacevoidnode.common.player.Player;
import com.greenspacevoidnode.common.player.PlayerTells;

import javax.persistence.*;
import java.util.ArrayList;


@MappedSuperclass
public class Vessel extends Entity implements PlayerTells {

    private Player pilot;


    @Column(name = "cargoHoldID")
    private long cargoHoldID; //Table reference to this vessel's cargo hold (Screw joins!)





    //TODO: REPEAT AFTER ME! I WILL NOT AND SHALL NOT INCLUDE BASEVALUES EVER(!!!!) IN THE DATABASE!

    private Class blueprintClass;



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

    int hullModuleSlots, armorModuleSlots, shieldModuleSlots, weaponModuleSlots, miningModuleSlots, weaponSlots, maxTargets;

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

    @Column(name = "shieldModulesData")
    private String shieldModulesData;
    @Column(name = "armorModulesData")
    private String armorModulesData;
    @Column(name = "hullModulesData")
    private String hullModulesData;

    @Column(name = "weaponModulesData")
    private String weaponModulesData;
    @Column(name = "miningModulesData")
    private String miningModulesData;

    @Column(name = "weaponsData")
    private String weaponsData;


    ArrayList<Module.ShieldModule> shieldModules = new ArrayList<>();
    ArrayList<Module.ArmorModule> armorModules = new ArrayList<>();
    ArrayList<Module.HullModule> hullModules = new ArrayList<>();

    ArrayList<Module.WeaponModule> weaponModules = new ArrayList<>();
    ArrayList<Module.MiningModule> miningModules = new ArrayList<>();

    ArrayList<Weapon> weapons = new ArrayList<>();

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

    public void addModule(Module module){
        if(module instanceof Module.HullModule){
            if(hullModules.size() < hullModuleSlots){
                hullModules.add((Module.HullModule) module);
                module.setVessel(this);
            }else{
                pilot.warn("Not Enough Hull Module Slots");
            }
        }else if(module instanceof Module.ArmorModule){
            if(armorModules.size() < armorModuleSlots) {
                armorModules.add((Module.ArmorModule) module);
                module.setVessel(this);
            }else{
                pilot.warn("Not Enough Armor Module Slots");
            }
        }else if(module instanceof Module.ShieldModule){
            if(shieldModules.size() < shieldModuleSlots) {
                shieldModules.add((Module.ShieldModule) module);
                module.setVessel(this);
            }else{
                pilot.warn("Not Enough Shield Module Slots");
            }
        }else if(module instanceof Module.WeaponModule){
            if(weaponModules.size() < weaponModuleSlots){
                weaponModules.add((Module.WeaponModule) module);
                module.setVessel(this);
            }else{
                pilot.warn("Not Enough Weapon Module Slots");
            }
        }else if(module instanceof Module.MiningModule){
            if(miningModules.size() < miningModuleSlots){
                miningModules.add((Module.MiningModule) module);
                module.setVessel(this);
            }else{
                pilot.warn("Not Enough Mining Module Slots");
            }
        }else if(module instanceof Weapon) {
            if(weapons.size() < weaponSlots) {
                weapons.add((Weapon) module);
            }else{
                pilot.warn("Not Enough Mining Module Slots");
            }
        }else{
            System.out.println("A bad module tried to be inserted into objectID:" + this.getId());
        }
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


    @Override
    public void destroy() {

        //Todo: Create loot/salvage on death!

        super.destroy();
    }








}
