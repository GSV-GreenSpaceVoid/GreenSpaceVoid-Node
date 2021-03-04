package com.greenspacevoidnode.common.item.modules;

import com.greenspacevoidnode.common.item.Item;

public class Module extends Item {

    protected Sizes size;
    protected ModuleType type;



    private boolean canActivate, canOverheat, isActive;
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
            this.size = Sizes.EXTRA_SMALL;
            this.type = ModuleType.VESSEL;



        }
    }



    public static class SmallModule extends Module{


        public SmallModule(String name, double baseVolume, int quantity) {
            super(name, baseVolume, quantity);
            this.size = Sizes.SMALL;
            this.type = ModuleType.VESSEL;
        }
    }

    public static class MediumModule extends Module{


        public MediumModule(String name, double baseVolume, int quantity) {
            super(name, baseVolume, quantity);
            this.size = Sizes.MEDIUM;
            this.type = ModuleType.VESSEL;
        }
    }


    public static class LargeModule extends Module{


        public LargeModule(String name, double baseVolume, int quantity) {
            super(name, baseVolume, quantity);
            this.size = Sizes.LARGE;
            this.type = ModuleType.VESSEL;
        }
    }




    public static class CapitalModule extends Module{


        public CapitalModule(String name, double baseVolume, int quantity) {
            super(name, baseVolume, quantity);
            this.size = Sizes.CAPITAL;
            this.type = ModuleType.VESSEL;
        }
    }


    public static class SuperCapitalModule extends Module{


        public SuperCapitalModule(String name, double baseVolume, int quantity) {
            super(name, baseVolume, quantity);
            this.size = Sizes.SUPER_CAPITAL;
            this.type = ModuleType.VESSEL;
        }
    }

    public static class StationModule extends Module{


        public StationModule(String name, double baseVolume, int quantity) {
            super(name, baseVolume, quantity);
            this.size = Sizes.STATION;
            this.type = ModuleType.STATION;
        }
    }




    public enum Sizes{
        EXTRA_SMALL,
        SMALL,
        MEDIUM,
        LARGE,
        CAPITAL,
        SUPER_CAPITAL,
        STATION,

    }

    public enum ModuleType{
        VESSEL,
        STATION,
        DOOMSDAY,







    }













}
