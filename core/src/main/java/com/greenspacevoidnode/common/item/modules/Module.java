package com.greenspacevoidnode.common.item.modules;

import com.greenspacevoidnode.common.item.Item;

import javax.persistence.*;


@MappedSuperclass
public class Module extends Item {




    @Column(name = "isActive")
    private boolean isActive;


    private boolean canActivate, canOverheat;
    private long cycleTime;//In millis

    private double structureHitPointModifier, hullHitPointModifier, shieldHitPointModifier;





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









    public Module(String name, double baseVolume, int quantity) {
        super(name, baseVolume, quantity);
    }


    public void activate(){





    }






    public static class ExtraSmallModule extends Module{
        public ExtraSmallModule(String name, double baseVolume, int quantity) {
            super(name, baseVolume, quantity);


        }
    }



    public static class SmallModule extends Module{


        public SmallModule(String name, double baseVolume, int quantity) {
            super(name, baseVolume, quantity);
        }
    }

    public static class MediumModule extends Module{


        public MediumModule(String name, double baseVolume, int quantity) {
            super(name, baseVolume, quantity);
        }
    }


    public static class LargeModule extends Module{


        public LargeModule(String name, double baseVolume, int quantity) {
            super(name, baseVolume, quantity);
        }
    }




    public static class CapitalModule extends Module{


        public CapitalModule(String name, double baseVolume, int quantity) {
            super(name, baseVolume, quantity);
        }
    }


    public static class SuperCapitalModule extends Module{


        public SuperCapitalModule(String name, double baseVolume, int quantity) {
            super(name, baseVolume, quantity);
        }
    }

    public static class StationModule extends Module{


        public StationModule(String name, double baseVolume, int quantity) {
            super(name, baseVolume, quantity);
        }
    }














}
