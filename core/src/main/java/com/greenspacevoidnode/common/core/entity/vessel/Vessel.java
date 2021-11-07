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
public class Vessel extends Entity implements PlayerTells{

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












    //TODO: REPEAT AFTER ME! I WILL NOT AND SHALL NOT INCLUDE BASEVALUES EVER(!!!!) IN THE DATABASE!





    double volume;



    //Base(Constructor initialized)
    double baseStructureHP = 0;
    double baseHullHP = 0;
    double baseShieldHP = 0;
    double baseShieldRegenerationRate = 0;


    double baseStructureEnergyResist = 0;
    double baseStructureThermalResist = 0;
    double baseStructureEMPResist = 0;
    double baseStructureExplosiveResist = 0;
    double baseHullEnergyResist = 0;
    double baseHullThermalResist = 0;
    double baseHullEMPResist = 0;
    double baseHullExplosiveResist = 0;

    double baseShieldEnergyResist = 0;
    double baseShieldThermalResist = 0;
    double baseShieldEMPResist = 0;
    double baseShieldExplosiveResist = 0;


    double baseSensorStrength;
    double baseSensorRadius;
    double baseSignatureStrength;
    double baseSignatureRadius;

    double basePowerGrid = 0;
    double  baseCapacitorCapacity = 0;
    double  baseCapacitorRegenerationRate = 0;

    double baseInertiaModifier = 0;
    double  baseSpeed = 0;
    double  baseAccelerationRate = 0;
    double  baseTurnRate = 0;

    double baseCargoHoldCapacity = 0;

    int hullModuleSlots = 0;
    int armorModuleSlots = 0;
    int shieldModuleSlots = 0;
    int weaponModuleSlots = 0;
    int miningModuleSlots = 0;
    int weaponSlots = 0;
    int maxTargets = 0;
    double baseRailGunDamageModifier = 0;
    double baseMissileDamageModifier = 0;
    double baseLaserDamageModifier = 0;
    double baseArtilleryDamageModifier = 0;
    double baseMiningYieldModifier = 0;
    double baseRailGunROFModifier = 0;
    double baseMissileROFModifier = 0;
    double baseLaserROFModifier = 0;
    double baseArtilleryROFModifier = 0;
    double baseMiningROFModifier = 0;

    double baseDroneControlRange = 0;
    double maxNumberOfDrones = 0;
    double baseDroneDamageModifier = 0;
    double baseDroneDefenseModifier = 0;
    double baseDroneSpeedModifier = 0;
    double baseDroneRateOfFireModifier = 0;
    double baseDroneMiningYieldModifier = 0;






    //Current
    double currentStructureHP, currentHullHP, currentShieldHP;
    double currentShieldRegenerationRate;

    double currentStructureEnergyResist, currentStructureThermalResist, currentStructureEMPResist, currentStructureExplosiveResist;
    double currentHullEnergyResist, currentHullThermalResist, currentHullEMPResist, currentHullExplosiveResist;
    double currentShieldEnergyResist, currentShieldThermalResist, currentShieldEMPResist, currentShieldExplosiveResist;


    double currentSensorStrength, currentSensorRadius, currentSignatureStrength, currentSignatureRadius;

    double currentPowerGrid, currentCapacitorCapacity, currentCapacitorRegenerationRate;

    double currentInertiaModifier, currentSpeed, currentAccelerationRate, currentTurnRate;

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

    double maxInertiaModifier, maxSpeed, maxAccelerationRate, maxTurnRate;


    private Hold.CargoHold cargoHold;
    private Hold.OreHold oreHold;
    private Hold.ShipHold shipHold;
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


    private ArrayList<Module.ShieldModule> shieldModules = new ArrayList<>();
    private ArrayList<Module.ArmorModule> armorModules = new ArrayList<>();
    private ArrayList<Module.HullModule> hullModules = new ArrayList<>();

    private ArrayList<Module.WeaponModule> weaponModules = new ArrayList<>();
    private ArrayList<Module.MiningModule> miningModules = new ArrayList<>();

    private ArrayList<Weapon> weapons = new ArrayList<>();

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
    private boolean isMoving;
    private long destinationX, destinationY;
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


}
