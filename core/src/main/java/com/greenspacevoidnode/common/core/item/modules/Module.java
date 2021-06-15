package com.greenspacevoidnode.common.core.item.modules;

import com.greenspacevoidnode.common.Sizes;
import com.greenspacevoidnode.common.core.entity.vessel.Vessel;
import com.greenspacevoidnode.common.core.item.Item;

import javax.persistence.*;


@MappedSuperclass
public class Module extends Item {



    private Sizes size;
    private Vessel vessel; //Vessel reference!



    @Column(name = "isActive")
    private boolean isActive;


    private boolean canActivate, canOverheat;
    private long cycleTime;//In millis

    private double armorHitPointModifier, hullHitPointModifier, shieldHitPointModifier;





    //Basevalues
    private double baseShieldRegenerationRateModifier;

    private double baseStructureEnergyResist, baseStructureThermalResist, baseStructureEMPResist, baseStructureExplosiveResist;
    private double baseHullEnergyResist, baseHullThermalResist, baseHullEMPResist, baseHullExplosiveResist;
    private double baseShieldEnergyResist, baseShieldThermalResist, baseShieldEMPResist, baseShieldExplosiveResist;



    private double cargoCapacityModifier;
    private double baseSensorStrengthModifier, baseSensorRadiusModifier, baseSignatureStrengthModifier, baseSsignatureRadiusModifier;

    private double baseSpeedModifier, baseInertialModifier;


    private double basePowerGrid, baseCapacitorCapacity, baseCapacitorRegenerationRate;





    //Instance Values
    double activeShieldRegenerationRateModifier;
    double activeStructureEnergyResist, activeStructureThermalResist, activeStructureEMPResist, activeStructureExplosiveResist;
    double activeHullEnergyResist, activeHullThermalResist, activeHullEMPResist, activeHullExplosiveResist;
    double activeShieldEnergyResist, activeShieldThermalResist, activeShieldEMPResist, activeShieldExplosiveResist;

    double currentSensorStrengthModifier, currentSensorRadiusModifier, currentSignatureStrengthModifier, currentSignatureRadiusModifier;

    private double currentSpeedModifier, currentInertialModifier;









    protected static void pacifyModule(){//ONLY USED IF THE MODULE IS PASSIVE!(Saves a whole lot of typing and prevents errors)






    }









    public Module(String name, double baseVolume, int quantity, Sizes size) {
        super(name, baseVolume, quantity);
    }


    public void activate(){





    }

    public Vessel getVessel() {
        return vessel;
    }

    public void setVessel(Vessel vessel) {
        this.vessel = vessel;
    }

    public static class WeaponModule extends Module{


        public WeaponModule(String name, double baseVolume, int quantity, Sizes size) {
            super(name, baseVolume, quantity, size);
        }
    }

    public static class MiningModule extends Module{


        public MiningModule(String name, double baseVolume, int quantity, Sizes size) {
            super(name, baseVolume, quantity, size);
        }
    }

    public static class HullModule extends Module{


        public HullModule(String name, double baseVolume, int quantity, Sizes size) {
            super(name, baseVolume, quantity, size);
        }
    }

    public static class ShieldModule extends Module{


        public ShieldModule(String name, double baseVolume, int quantity, Sizes size) {
            super(name, baseVolume, quantity, size);
        }
    }

    public static class ArmorModule extends Module{

        public ArmorModule(String name, double baseVolume, int quantity, Sizes size) {
            super(name, baseVolume, quantity, size);
        }
    }








}
