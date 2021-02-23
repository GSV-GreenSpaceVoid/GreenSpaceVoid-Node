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
            private static final double baseVolume = 1; //m^3
            private static final double baseMass = 8050; //8050 kg/m3

            public Steel(int quantity){
                super(name, baseVolume, baseMass, quantity);
            }
        }

        public static class Aluminum extends SolidMaterials{
            private static final String name = "Aluminum";
            private static final double baseVolume = 1; //m^3
            private static final double baseMass = 2710; //kg/m^3


            public Aluminum(int quantity) {
                super(name, baseVolume, baseMass, quantity);
            }
        }

        public static class Titanium extends SolidMaterials{
            private static final String name = "Titanium";
            private static final double baseVolume = 1; //m^3
            private static final double baseMass = 4507 ; //kg/m^3

            public Titanium(int quantity) {
                super(name, baseVolume, baseMass, quantity);
            }
        }

        public static class Rhodium extends SolidMaterials{
            private static final String name = "Rhodium";
            private static final double baseVolume = 1; //m^3
            private static final double baseMass = 12390; //kg/m^3

            public Rhodium(int quantity) {
                super(name, baseVolume, baseMass, quantity);
            }
        }

        public static class Uranium extends SolidMaterials{
            private static final String name = "Uranium";
            private static final double baseVolume = 1; //m^3
            private static final double baseMass = 19050; //kg/m^3

            public Uranium(int quantity) {
                super(name, baseVolume, baseMass, quantity);
            }

        }

        public static class Lead extends SolidMaterials{
            private static final String name = "Lead";
            private static final double baseVolume = 1; //m^3
            private static final double baseMass = 11342; //kg/m^3

            public Lead(String name, double baseVolume, double baseMass, int quantity) {
                super(name, baseVolume, baseMass, quantity);
            }
        }

        public static class Silicon extends SolidMaterials{
            private static final String name = "Silicon";
            private static final double baseVolume = 1; //m^3
            private static final double baseMass = 2330; //kg/m^3

            public Silicon(String name, double baseVolume, double baseMass, int quantity) {
                super(name, baseVolume, baseMass, quantity);
            }


        }





    }


    public static class IceMaterials extends Material{

        public IceMaterials(String name, double baseVolume, double baseMass, int quantity) {
            super(name, baseVolume, baseMass, quantity);
        }


        public static class Permafrost extends IceMaterials{
            private static final String name = "Silicon";
            private static final double baseVolume = 3; //m^3
            private static final double baseMass = 550; //kg/m^3


            public Permafrost(int quantity) {
                super(name, baseVolume, baseMass, quantity);
            }
        }

        public static class IceCrystal extends IceMaterials{

                private static final String name = "Silicon";
                private static final double baseVolume = 25; //m^3
                private static final double baseMass = 900; //kg/m^3


                public IceCrystal(int quantity) {
                    super(name, baseVolume, baseMass, quantity);
                }

        }


    }



    public static class GasMaterials {

        public static class Water extends GasMaterials{

        }





    }












}
