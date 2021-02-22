package com.greenspacevoid.common.item.industry.materials;

import com.greenspacevoid.common.item.Item;

public class Material extends Item {


    public Material(String name, double baseVolume, double baseMass, int quantity) {
        super(name, baseVolume, baseMass, quantity);
    }




    //Refined Materials below:


    public static class SolidMaterials extends Material {

        public SolidMaterials(String name, double baseVolume, double baseMass, int quantity) {
            super(name, baseVolume, baseMass, quantity);
        }


        public static class Steel extends SolidMaterials{
            private static final String name = "Steel";
            private static final double baseVolume = 0.1; //m^3
            private static final double baseMass = 805; //8050 kg/m3

            public Steel(int quantity){
                super(name, baseVolume, baseMass, quantity);
            }
        }

        public static class Aluminum extends SolidMaterials{
            private static final String name = "Aluminum";
            private static final double baseVolume = 0.1; //m^3
            private static final double baseMass = 271; //kg/m^3


            public Aluminum(int quantity) {
                super(name, baseVolume, baseMass, quantity);
            }
        }

        public static class Titanium extends SolidMaterials{
            private static final String name = "Titanium";
            private static final double baseVolume = 0.5; //m^3
            private static final double baseMass = 2210 ; //kg/m^3

            public Titanium(int quantity) {
                super(name, baseVolume, baseMass, quantity);
            }
        }

        public static class Rhodium extends SolidMaterials{
            private static final String name = "Rhodium";
            private static final double baseVolume = 0.2; //m^3
            private static final double baseMass = 2482; //kg/m^3

            public Rhodium(int quantity) {
                super(name, baseVolume, baseMass, quantity);
            }
        }

        public static class Uranium extends SolidMaterials{
            private static final String name = "Uranium";
            private static final double baseVolume = 2; //m^3
            private static final double baseMass = 38100; //kg/m^3

            public Uranium(int quantity) {
                super(name, baseVolume, baseMass, quantity);
            }

        }

        public static class Lead extends SolidMaterials{


        }

        public static class Silicon extends SolidMaterials{



        }





    }


    public static class IceMaterials{

        public static class Ice extends IceMaterials{

        }

        public static class GlacialSnow extends IceMaterials{


        }

        public static class IceCrystal extends IceMaterials{


        }


    }



    public static class GasMaterials {

        public static class Water extends GasMaterials{

        }





    }












}
