package com.greenspacevoidnode.common.core.entity.vessel;

import com.greenspacevoidnode.common.core.entity.Entity;
import com.greenspacevoidnode.common.core.item.Hold;
import com.greenspacevoidnode.common.core.item.Item;
import com.greenspacevoidnode.common.core.item.modules.Module;
import com.greenspacevoidnode.common.core.item.modules.weapons.Weapon;
import com.greenspacevoidnode.common.player.Player;
import com.greenspacevoidnode.common.player.PlayerTells;

import javax.persistence.*;
import java.util.ArrayList;


@MappedSuperclass
public abstract class Vessel extends Entity implements PlayerTells{

    private Player pilot;
    @Column(name = "pilotID")
    private long pilotID;

    @Column(name = "cargoHoldID")
    private long cargoHoldID; //Table reference to this vessel's cargo hold (Screw joins!)

    @Column(name = "oreHoldID")
    private long oreHoldID;

    @Column(name = "shipHoldID")
    private long shipHoldID;

    @Column(name = "droneBayID")
    private long droneBayID;

    @Override
    public void update() {
        //Clears the modules first. This is to prevent item duplication. #Redundant
        hullModules.removeAll(hullModules);
        armorModules.removeAll(armorModules);
        shieldModules.removeAll(shieldModules);
        weaponModules.removeAll(weaponModules);
        miningModules.removeAll(miningModules);
        weapons.removeAll(weapons);

        ArrayList<Item> hullItems = loadItemsFromString(hullModulesData);
        hullItems.removeIf(i -> !(i instanceof Module.HullModule));
        for(Item module : hullItems){
            hullModules.add((Module.HullModule)module);
        }
        ArrayList<Item> armorItems = loadItemsFromString(armorModulesData);
        armorItems.removeIf(i -> !(i instanceof Module.ArmorModule));
        for(Item module : armorItems){
            armorModules.add((Module.ArmorModule)module);
        }
        ArrayList<Item> shieldItems = loadItemsFromString(shieldModulesData);
        shieldItems.removeIf(i -> !(i instanceof Module.ShieldModule));
        for(Item module : shieldItems){
            shieldModules.add((Module.ShieldModule)module);
        }
        ArrayList<Item> weaponModuleItems = loadItemsFromString(weaponModulesData);
        weaponModuleItems.removeIf(i -> !(i instanceof Module.WeaponModule));
        for(Item module : weaponModuleItems){
            weaponModules.add((Module.WeaponModule)module);
        }
        ArrayList<Item> miningModuleItems = loadItemsFromString(miningModulesData);
        miningModuleItems.removeIf(i -> !(i instanceof Module.MiningModule));
        for(Item module : miningModuleItems){
            miningModules.add((Module.MiningModule)module);
        }
        ArrayList<Item> weaponItems = loadItemsFromString(weaponsData);
        weaponItems.removeIf(i -> !(i instanceof Weapon));
        for(Item module : weaponItems){
            weapons.add((Weapon)module);
        }
        setModulesVesselReference();
        cargoHold.update();
    }






    @Transient double volume;



    //Base(Constructor initialized)
   @Transient
   private double baseStructureHP;
   @Transient
   private double baseHullHP;
   @Transient
   private double baseShieldHP;
   @Transient
   private double baseShieldRegenerationRate;
   @Transient
   private double baseStructureEnergyResist;
   @Transient
   private double baseStructureThermalResist;
   @Transient
   private double baseStructureEMPResist;
   @Transient
   private double baseStructureExplosiveResist;
   @Transient
   private double baseHullEnergyResist;
   @Transient
   private double baseHullThermalResist;
   @Transient
   private double baseHullEMPResist;
   @Transient
   private double baseHullExplosiveResist;
   @Transient
   private double baseShieldEnergyResist;
   @Transient
   private double baseShieldThermalResist;
   @Transient
   private double baseShieldEMPResist;
   @Transient
   private double baseShieldExplosiveResist;
   @Transient
   private double baseSensorStrength;
   @Transient
   private double baseSensorRadius;
   @Transient
   private double baseSignatureStrength;
   @Transient
   private double baseSignatureRadius;
   @Transient
   private double basePowerGrid;
   @Transient
   private double baseCapacitorCapacity;
   @Transient
   private double baseCapacitorRegenerationRate;
   @Transient
   private double baseInertiaModifier;
   @Transient
   private double baseSpeed;
   @Transient
   private double baseAccelerationRate;
   @Transient
   private double baseTurnRate;
   @Transient
   private double baseCargoHoldCapacity;

   @Transient
   private int hullModuleSlots;
   @Transient
   private int armorModuleSlots;
   @Transient
   private int shieldModuleSlots;
   @Transient
   private int weaponModuleSlots;
   @Transient
   private int miningModuleSlots;
   @Transient
   private int weaponSlots;
   @Transient
   private int maxTargets;

   @Transient
   private double baseRailGunDamageModifier;
   @Transient
   private double baseMissileDamageModifier;
   @Transient
   private double baseLaserDamageModifier;
   @Transient
   private double baseArtilleryDamageModifier;
   @Transient
   private double baseMiningYieldModifier;
   @Transient
   private double baseRailGunROFModifier;
   @Transient
   private double baseMissileROFModifier;
   @Transient
   private double baseLaserROFModifier;
   @Transient
   private double baseArtilleryROFModifier;
   @Transient
   private double baseMiningROFModifier;
   @Transient
   private double baseDroneControlRange;
   @Transient
   private int maxNumberOfDrones;
   @Transient
   private double baseDroneDamageModifier;
   @Transient
   private double baseDroneDefenseModifier;
   @Transient
   private double baseDroneSpeedModifier;
   @Transient
   private double baseDroneRateOfFireModifier;
   @Transient
   private double baseDroneMiningYieldModifier;






    //Current
   @Transient
    double currentStructureHP;
   @Transient
   double currentHullHP;
   @Transient
   double currentShieldHP;
   @Transient
   double currentShieldRegenerationRate;

   @Transient
   double currentStructureEnergyResist;
   @Transient
   double currentStructureThermalResist;
   @Transient
   double currentStructureEMPResist;
   @Transient
   double currentStructureExplosiveResist;
   @Transient
   double currentHullEnergyResist;
   @Transient
   double currentHullThermalResist;
   @Transient
   double currentHullEMPResist;
   @Transient
   double currentHullExplosiveResist;
   @Transient
   double currentShieldEnergyResist;
   @Transient
   double currentShieldThermalResist;
   @Transient
   double currentShieldEMPResist;
   @Transient
   double currentShieldExplosiveResist;


   @Transient
   double currentSensorStrength;
   @Transient
   double currentSensorRadius;
   @Transient
   double currentSignatureStrength;
   @Transient
   double currentSignatureRadius;

   @Transient
   double currentPowerGrid;
   @Transient
   double currentCapacitorCapacity;
   @Transient
   double currentCapacitorRegenerationRate;

   @Transient
   double currentInertiaModifier;
   @Transient
   double currentSpeed;
   @Transient
   double currentAccelerationRate;
   @Transient
   double currentTurnRate;

   @Transient
   double maxStructureHP;
   @Transient
   double maxHullHP;
   @Transient
   double maxShieldHP;
   @Transient
   double maxShieldRegenerationRate;

   @Transient
   double maxStructureEnergyResist;
   @Transient
   double maxStructureThermalResist;
   @Transient
   double maxStructureEMPResist;
   @Transient
   double maxStructureExplosiveResist;
   @Transient
   double maxHullEnergyResist;
   @Transient
   double maxHullThermalResist;
   @Transient
   double maxHullEMPResist;
   @Transient
   double maxHullExplosiveResist;
   @Transient
   double maxShieldEnergyResist;
   @Transient
   double maxShieldThermalResist;
   @Transient
   double maxShieldEMPResist;
   @Transient
   double maxShieldExplosiveResist;


   @Transient
   double maxSensorStrength;
   @Transient
   double maxSensorRadius;
   @Transient
   double maxSignatureStrength;
   @Transient
   double maxSignatureRadius;

   @Transient
   double maxPowerGrid;
   @Transient
   double maxCapacitorCapacity;
   @Transient
   double maxCapacitorRegenerationRate;

   @Transient
   double maxInertiaModifier;
   @Transient
   double maxSpeed;
   @Transient
   double maxAccelerationRate;
   @Transient
   double maxTurnRate;


   @Transient
   private Hold.CargoHold cargoHold;
   @Transient
   private Hold.OreHold oreHold;
   @Transient
   private Hold.ShipHold shipHold;
   @Transient
   private Hold.DroneBay droneBay;

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

    @Transient
    private ArrayList<Module.ShieldModule> shieldModules = new ArrayList<>();
    @Transient
    private ArrayList<Module.ArmorModule> armorModules = new ArrayList<>();
    @Transient
    private ArrayList<Module.HullModule> hullModules = new ArrayList<>();
    @Transient
    private ArrayList<Module.WeaponModule> weaponModules = new ArrayList<>();
    @Transient
    private ArrayList<Module.MiningModule> miningModules = new ArrayList<>();
    @Transient
    private ArrayList<Weapon> weapons = new ArrayList<>();

    @Override
    public void initialize() {
        initializeBaseValues();
        update();





        super.initialize();
    }

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
        System.out.println("Sent a warning to player: " + pilot.getUsername() + " ID: " + pilot.getId());

    }


    public void setModulesVesselReference(){//Tells every module which ship that they're installed on. This is vital for weaponry/stats.
        for(Module.HullModule h : hullModules){
            h.setVessel(this);
        }
        for(Module.ArmorModule a : armorModules){
            a.setVessel(this);
        }
        for(Module.ShieldModule s : shieldModules){
            s.setVessel(this);
        }
        for(Module.WeaponModule w : weaponModules){
            w.setVessel(this);
        }
        for(Module.MiningModule m : miningModules){
            m.setVessel(this);
        }
        for(Weapon weapon : weapons){
            weapon.setVessel(this);
        }
    }








    public void updateStats(){
        //Todo: Module Modifier Multiplication!


    }

/*           _    _                                _____           _
            | |  | |                              /  ___|         | |
            | |  | | ___  __ _ _ __   ___  _ __   \ `--. _   _ ___| |_ ___ _ __ ___  ___
            | |/\| |/ _ \/ _` | '_ \ / _ \| '_ \   `--. \ | | / __| __/ _ \ '_ ` _ \/ __|
            \  /\  /  __/ (_| | |_) | (_) | | | | /\__/ / |_| \__ \ ||  __/ | | | | \__ \
             \/  \/ \___|\__,_| .__/ \___/|_| |_| \____/ \__, |___/\__\___|_| |_| |_|___/
                             | |                         __/ |
                             |_|                        |___/
*/
    @Transient
    private ArrayList<Entity> targets = new ArrayList<>();

    public void addTarget(Entity entity){
        if(targets.size() < maxTargets){
            if(entity.isTargetable()){
                targets.add(entity);
            }else{
                pilot.warn("Cannot Target " + entity.getName() + "!");
                return;
            }
        }else{
            pilot.warn("You have reached your maximum of " + maxTargets + " targets already!");
        }
    }

    @Deprecated
    public void addTarget(int UUID){//Client Specific


    }

    public void setTurretTarget(int i, Entity target){
        try {
            weapons.get(i).setTarget(target);
        }catch(Exception e){
            pilot.warn("Selected Turret No Longer Exists!");
        }
    }



    public void removeTarget(Entity entity){



    }

    /*  ___  ___                                    _
        |  \/  |                                   | |
        | .  . | _____   _____ _ __ ___   ___ _ __ | |_
        | |\/| |/ _ \ \ / / _ \ '_ ` _ \ / _ \ '_ \| __|
        | |  | | (_) \ V /  __/ | | | | |  __/ | | | |_
        \_|  |_/\___/ \_/ \___|_| |_| |_|\___|_| |_|\__|
     */

    //isMoving determines whether the engine will change ship position based on movement.
    @Transient
    private boolean isMoving;
    @Transient
    private long destinationX;
    @Transient
    private long destinationY;
    @Transient
    private double targetSpeed;


    public void setDestination(long x, long y){
        destinationX = x;
        destinationY = y;
        isMoving = true;
    }

    public void setDestination(Entity entity){
        destinationX = entity.getX();
        destinationY = entity.getY();
        isMoving = true;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public long getDestinationX() {
        return destinationX;
    }

    public long getDestinationY() {
        return destinationY;
    }

    public double getBaseSpeed() {
        return baseSpeed;
    }

    public void setBaseSpeed(double baseSpeed) {
        this.baseSpeed = baseSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getCurrentThrustLevel(){
        return this.getMaxSpeed() / this.getCurrentSpeed();

    }

    public void setTargetSpeed(double targetSpeed){
        this.targetSpeed = targetSpeed;
    }

    public double getTargetSpeed(){
        return targetSpeed;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public void stopMoving(){
        isMoving = false;
    }

    public void freeze(){
        setCanMove(false);
        currentSpeed = 0;
    }

    public void move(){
        //Todo: Physics logic!..This may belong better in the physics engine class as it can read destination and THEN do the according physics. Better there than here?
        if (this.isCanMove()) {
            long destinationX = this.getDestinationX();
            long destinationY = this.getDestinationY();
            double speed = this.getCurrentSpeed();
            double dy, dx, flightpath;

            dy = Math.abs(destinationY - this.getY());
            dx = Math.abs(destinationX - this.getX());
            flightpath = Math.atan(dy / dx);


            if (destinationX != Math.round(this.getX()) || destinationY != Math.round(this.getY())) {
                double travelX = speed * Math.cos(flightpath);
                double travelY = speed * Math.sin(flightpath);
                if (destinationX < this.getX()) {
                    this.setX(Math.round(this.getX() - travelX));
                }
                if (destinationX > this.getX()) {
                    this.setX(Math.round(this.getX() + travelX));
                }
                if (destinationY < this.getY()) {
                    this.setY(Math.round(this.getY() - travelY));
                }
                if (destinationY > this.getY()) {
                    this.setY(Math.round(this.getY() + travelY));
                }
            } else {
                ((Vessel) this).setMoving(false);
                ((Vessel) this).sendPlayerAWarningMessage("You have reached your destination!");
            }
        }


    }


    public Player getPilot() {
        return pilot;
    }

    public void setPilot(Player pilot) {
        this.pilot = pilot;
    }

    public double getCurrentStructureHP() {
        return currentStructureHP;
    }

    public void setCurrentStructureHP(double currentStructureHP) {
        this.currentStructureHP = currentStructureHP;
    }

    public double getCurrentHullHP() {
        return currentHullHP;
    }

    public double getMaxStructureHP() {
        return maxStructureHP;
    }

    public double getMaxHullHP() {
        return maxHullHP;
    }

    public double getMaxShieldHP() {
        return maxShieldHP;
    }

    public void setCurrentHullHP(double currentHullHP) {
        this.currentHullHP = currentHullHP;
    }

    public double getCurrentShieldHP() {
        return currentShieldHP;
    }

    public void setCurrentShieldHP(double currentShieldHP) {
        this.currentShieldHP = currentShieldHP;
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

    public Vessel(String name, long systemID, long x, long y, double volume, boolean isInvincible, boolean isTargetable, boolean canMove, double baseCargoCapacity) {
        super(name, systemID, x, y, isInvincible, isTargetable, canMove);

            Hold.CargoHold cargoHold = new Hold.CargoHold(baseCargoCapacity);



        this.volume = volume;
    }

    @Override
    public void close(){





    }





    @Override
    public void destroy() {

        //Todo: Create loot/salvage on death!

        super.destroy();
    }

    private void initializeBaseValues(){
        initializeBaseStructureHP();
        initializeBaseHullHP();
        initializeBaseShieldHP();
        initializeBaseShieldRegenerationRate();
        initializeBaseStructureEnergyResist();
        initializeBaseStructureThermalResist();
        initializeBaseStructureEMPResist() ;
        initializeBaseStructureExplosiveResist();
        initializeBaseHullEnergyResist();
        initializeBaseHullThermalResist();
        initializeBaseHullEMPResist();
        initializeBaseHullExplosiveResist();
        initializeBaseShieldEnergyResist();
        initializeBaseShieldThermalResist();
        initializeBaseShieldEMPResist();
        initializeBaseShieldExplosiveResist();
        initializeBaseSensorStrength();
        initializeBaseSensorRadius();
        initializeBaseSignatureStrength();
        initializeBaseSignatureRadius();
        initializeBasePowerGrid();
        initializeBaseCapacitorCapacity();
        initializeBaseCapacitorRegenerationRate();
        initializeBaseInertiaModifier();
        initializeBaseSpeed();
        initializeBaseAccelerationRate();
        initializeBaseTurnRate();
        initializeBaseCargoHoldCapacity();
        initializeHullModuleSlots();
        initializeArmorModuleSlots();
        initializeShieldModuleSlots();
        initializeWeaponModuleSlots();
        initializeMiningModuleSlots();
        initializeWeaponSlots();
        initializeMaxTargets();
        initializeBaseRailGunDamageModifier();
        initializeBaseMissileDamageModifier();
        initializeBaseLaserDamageModifier();
        initializeBaseArtilleryDamageModifier();
        initializeBaseMiningYieldModifier();
        initializeBaseRailGunROFModifier();
        initializeBaseMissileROFModifier();
        initializeBaseLaserROFModifier();
        initializeBaseArtilleryROFModifier();
        initializeBaseMiningROFModifier();
        initializeBaseDroneControlRange();
        initializeMaxNumberOfDrones();
        initializeBaseDroneDamageModifier();
        initializeBaseDroneDefenseModifier();
        initializeBaseDroneSpeedModifier();
        initializeBaseDroneRateOfFireModifier();
        initializeBaseDroneMiningYieldModifier();






    }

    public abstract void initializeBaseStructureHP();

    public abstract void initializeBaseHullHP();

    public abstract void initializeBaseShieldHP();

    public abstract void initializeBaseShieldRegenerationRate();

    public abstract void initializeBaseStructureEnergyResist();

    public abstract void initializeBaseStructureThermalResist();

    public abstract void initializeBaseStructureEMPResist() ;

    public abstract void initializeBaseStructureExplosiveResist();

    public abstract void initializeBaseHullEnergyResist();

    public abstract void initializeBaseHullThermalResist();

    public abstract void initializeBaseHullEMPResist();

    public abstract void initializeBaseHullExplosiveResist();

    public abstract void initializeBaseShieldEnergyResist();

    public abstract void initializeBaseShieldThermalResist();

    public abstract void initializeBaseShieldEMPResist();

    public abstract void initializeBaseShieldExplosiveResist();

    public abstract void initializeBaseSensorStrength();

    public abstract void initializeBaseSensorRadius();

    public abstract void initializeBaseSignatureStrength();

    public abstract void initializeBaseSignatureRadius();

    public abstract void initializeBasePowerGrid();

    public abstract void initializeBaseCapacitorCapacity();

    public abstract void initializeBaseCapacitorRegenerationRate();

    public abstract void initializeBaseInertiaModifier();

    public abstract void initializeBaseSpeed();

    public abstract void initializeBaseAccelerationRate();

    public abstract void initializeBaseTurnRate();

    public abstract void initializeBaseCargoHoldCapacity();

    public abstract void initializeHullModuleSlots();

    public abstract void initializeArmorModuleSlots();

    public abstract void initializeShieldModuleSlots();

    public abstract void initializeWeaponModuleSlots();

    public abstract void initializeMiningModuleSlots();

    public abstract void initializeWeaponSlots();

    public abstract void initializeMaxTargets();

    public abstract void initializeBaseRailGunDamageModifier();

    public abstract void initializeBaseMissileDamageModifier();

    public abstract void initializeBaseLaserDamageModifier();

    public abstract void initializeBaseArtilleryDamageModifier();

    public abstract void initializeBaseMiningYieldModifier();

    public abstract void initializeBaseRailGunROFModifier();

    public abstract void initializeBaseMissileROFModifier();

    public abstract void initializeBaseLaserROFModifier();

    public abstract void initializeBaseArtilleryROFModifier();

    public abstract void initializeBaseMiningROFModifier();

    public abstract void initializeBaseDroneControlRange();

    public abstract void initializeMaxNumberOfDrones();

    public abstract void initializeBaseDroneDamageModifier();

    public abstract void initializeBaseDroneDefenseModifier();

    public abstract void initializeBaseDroneSpeedModifier();

    public abstract void initializeBaseDroneRateOfFireModifier();

    public abstract void initializeBaseDroneMiningYieldModifier();

    public void setBaseStructureHP(double baseStructureHP) {
        this.baseStructureHP = baseStructureHP;
    }

    public void setBaseHullHP(double baseHullHP) {
        this.baseHullHP = baseHullHP;
    }

    public void setBaseShieldHP(double baseShieldHP) {
        this.baseShieldHP = baseShieldHP;
    }

    public void setBaseShieldRegenerationRate(double baseShieldRegenerationRate) {
        this.baseShieldRegenerationRate = baseShieldRegenerationRate;
    }

    public void setBaseStructureEnergyResist(double baseStructureEnergyResist) {
        this.baseStructureEnergyResist = baseStructureEnergyResist;
    }

    public void setBaseStructureThermalResist(double baseStructureThermalResist) {
        this.baseStructureThermalResist = baseStructureThermalResist;
    }

    public void setBaseStructureEMPResist(double baseStructureEMPResist) {
        this.baseStructureEMPResist = baseStructureEMPResist;
    }

    public void setBaseStructureExplosiveResist(double baseStructureExplosiveResist) {
        this.baseStructureExplosiveResist = baseStructureExplosiveResist;
    }

    public void setBaseHullEnergyResist(double baseHullEnergyResist) {
        this.baseHullEnergyResist = baseHullEnergyResist;
    }

    public void setBaseHullThermalResist(double baseHullThermalResist) {
        this.baseHullThermalResist = baseHullThermalResist;
    }

    public void setBaseHullEMPResist(double baseHullEMPResist) {
        this.baseHullEMPResist = baseHullEMPResist;
    }

    public void setBaseHullExplosiveResist(double baseHullExplosiveResist) {
        this.baseHullExplosiveResist = baseHullExplosiveResist;
    }

    public void setBaseShieldEnergyResist(double baseShieldEnergyResist) {
        this.baseShieldEnergyResist = baseShieldEnergyResist;
    }

    public void setBaseShieldThermalResist(double baseShieldThermalResist) {
        this.baseShieldThermalResist = baseShieldThermalResist;
    }

    public void setBaseShieldEMPResist(double baseShieldEMPResist) {
        this.baseShieldEMPResist = baseShieldEMPResist;
    }

    public void setBaseShieldExplosiveResist(double baseShieldExplosiveResist) {
        this.baseShieldExplosiveResist = baseShieldExplosiveResist;
    }

    public void setBaseSensorStrength(double baseSensorStrength) {
        this.baseSensorStrength = baseSensorStrength;
    }

    public void setBaseSensorRadius(double baseSensorRadius) {
        this.baseSensorRadius = baseSensorRadius;
    }

    public void setBaseSignatureStrength(double baseSignatureStrength) {
        this.baseSignatureStrength = baseSignatureStrength;
    }

    public void setBaseSignatureRadius(double baseSignatureRadius) {
        this.baseSignatureRadius = baseSignatureRadius;
    }

    public void setBasePowerGrid(double basePowerGrid) {
        this.basePowerGrid = basePowerGrid;
    }

    public void setBaseCapacitorCapacity(double baseCapacitorCapacity) {
        this.baseCapacitorCapacity = baseCapacitorCapacity;
    }

    public void setBaseCapacitorRegenerationRate(double baseCapacitorRegenerationRate) {
        this.baseCapacitorRegenerationRate = baseCapacitorRegenerationRate;
    }

    public void setBaseInertiaModifier(double baseInertiaModifier) {
        this.baseInertiaModifier = baseInertiaModifier;
    }

    public void setBaseAccelerationRate(double baseAccelerationRate) {
        this.baseAccelerationRate = baseAccelerationRate;
    }

    public void setBaseTurnRate(double baseTurnRate) {
        this.baseTurnRate = baseTurnRate;
    }

    public void setBaseCargoHoldCapacity(double baseCargoHoldCapacity) {
        this.baseCargoHoldCapacity = baseCargoHoldCapacity;
    }

    public void setHullModuleSlots(int hullModuleSlots) {
        this.hullModuleSlots = hullModuleSlots;
    }

    public void setArmorModuleSlots(int armorModuleSlots) {
        this.armorModuleSlots = armorModuleSlots;
    }

    public void setShieldModuleSlots(int shieldModuleSlots) {
        this.shieldModuleSlots = shieldModuleSlots;
    }

    public void setWeaponModuleSlots(int weaponModuleSlots) {
        this.weaponModuleSlots = weaponModuleSlots;
    }

    public void setMiningModuleSlots(int miningModuleSlots) {
        this.miningModuleSlots = miningModuleSlots;
    }

    public void setWeaponSlots(int weaponSlots) {
        this.weaponSlots = weaponSlots;
    }

    public void setMaxTargets(int maxTargets) {
        this.maxTargets = maxTargets;
    }

    public void setBaseRailGunDamageModifier(double baseRailGunDamageModifier) {
        this.baseRailGunDamageModifier = baseRailGunDamageModifier;
    }

    public void setBaseMissileDamageModifier(double baseMissileDamageModifier) {
        this.baseMissileDamageModifier = baseMissileDamageModifier;
    }

    public void setBaseLaserDamageModifier(double baseLaserDamageModifier) {
        this.baseLaserDamageModifier = baseLaserDamageModifier;
    }

    public void setBaseArtilleryDamageModifier(double baseArtilleryDamageModifier) {
        this.baseArtilleryDamageModifier = baseArtilleryDamageModifier;
    }

    public void setBaseMiningYieldModifier(double baseMiningYieldModifier) {
        this.baseMiningYieldModifier = baseMiningYieldModifier;
    }

    public void setBaseRailGunROFModifier(double baseRailGunROFModifier) {
        this.baseRailGunROFModifier = baseRailGunROFModifier;
    }

    public void setBaseMissileROFModifier(double baseMissileROFModifier) {
        this.baseMissileROFModifier = baseMissileROFModifier;
    }

    public void setBaseLaserROFModifier(double baseLaserROFModifier) {
        this.baseLaserROFModifier = baseLaserROFModifier;
    }

    public void setBaseArtilleryROFModifier(double baseArtilleryROFModifier) {
        this.baseArtilleryROFModifier = baseArtilleryROFModifier;
    }

    public void setBaseMiningROFModifier(double baseMiningROFModifier) {
        this.baseMiningROFModifier = baseMiningROFModifier;
    }

    public void setBaseDroneControlRange(double baseDroneControlRange) {
        this.baseDroneControlRange = baseDroneControlRange;
    }

    public void setMaxNumberOfDrones(int maxNumberOfDrones) {
        this.maxNumberOfDrones = maxNumberOfDrones;
    }

    public void setBaseDroneDamageModifier(double baseDroneDamageModifier) {
        this.baseDroneDamageModifier = baseDroneDamageModifier;
    }

    public void setBaseDroneDefenseModifier(double baseDroneDefenseModifier) {
        this.baseDroneDefenseModifier = baseDroneDefenseModifier;
    }

    public void setBaseDroneSpeedModifier(double baseDroneSpeedModifier) {
        this.baseDroneSpeedModifier = baseDroneSpeedModifier;
    }

    public void setBaseDroneRateOfFireModifier(double baseDroneRateOfFireModifier) {
        this.baseDroneRateOfFireModifier = baseDroneRateOfFireModifier;
    }

    public void setBaseDroneMiningYieldModifier(double baseDroneMiningYieldModifier) {
        this.baseDroneMiningYieldModifier = baseDroneMiningYieldModifier;
    }




}
