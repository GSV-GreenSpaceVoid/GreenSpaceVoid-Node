package com.greenspacevoidnode.common.core.item.industry.materials;

import com.greenspacevoidnode.common.core.item.Item;

public class Material extends Item {
    public Material(String name, double basevolume, int quantity) {
        super(name,basevolume, quantity);
    }


    //Refined Materials below:


    public static class SolidMaterials extends Material {

        public SolidMaterials(String name, double baseVolume, int quantity) {
            super(name, baseVolume, quantity);
        }


        public static class Steel extends SolidMaterials{
            private static final String name = "Steel";
            private static final double baseVolume = 1; //m^3

            public Steel(int quantity){
                super(name, baseVolume, quantity);
            }
        }

        public static class Aluminum extends SolidMaterials{
            private static final String name = "Aluminum";
            private static final double baseVolume = 1; //m^3



            public Aluminum(int quantity) {
                super(name, baseVolume, quantity);
            }
        }

        public static class Titanium extends SolidMaterials{
            private static final String name = "Titanium";
            private static final double baseVolume = 1; //m^3


            public Titanium(int quantity) {
                super(name, baseVolume, quantity);
            }
        }

        public static class Rhodium extends SolidMaterials{
            private static final String name = "Rhodium";
            private static final double baseVolume = 1; //m^3

            public Rhodium(int quantity) {
                super(name, baseVolume, quantity);
            }
        }

        public static class Uranium extends SolidMaterials{
            private static final String name = "Uranium";
            private static final double baseVolume = 1; //m^3


            public Uranium(int quantity) {
                super(name, baseVolume, quantity);
            }

        }

        public static class Lead extends SolidMaterials{
            private static final String name = "Lead";
            private static final double baseVolume = 1; //m^3


            public Lead(int quantity) {
                super(name, baseVolume, quantity);
            }
        }

        public static class Silicon extends SolidMaterials{
            private static final String name = "Silicon";
            private static final double baseVolume = 1; //m^3

            public Silicon(int quantity) {
                super(name, baseVolume, quantity);
            }


        }





    }


    public static class IceMaterials extends Material{

        public IceMaterials(String name, double baseVolume, int quantity) {
            super(name, baseVolume, quantity);
        }


        public static class Permafrost extends IceMaterials{
            private static final String name = "Silicon";
            private static final double baseVolume = 3; //m^3


            public Permafrost(int quantity) {
                super(name, baseVolume, quantity);
            }
        }

        public static class IceCrystal extends IceMaterials{

                private static final String name = "Silicon";
                private static final double baseVolume = 25; //m^3


            public IceCrystal(int quantity) {
                    super(name, baseVolume, quantity);
                }

        }







    }



    public static class GasMaterials extends Material{


        public GasMaterials(String name, double baseVolume, int quantity) {
            super(name, baseVolume, quantity);
        }

        public static class LiquidHelium extends GasMaterials{
            private static final String name = "Liquid Helium";
            private static final double baseVolume = 1;

            public LiquidHelium(int quantity) {
                super(name, baseVolume, quantity);
            }
        }

        public static class LiquidHelium3 extends GasMaterials{
            private static final String name = "Liquid Helium-3";
            private static final double baseVolume = 1;

            public LiquidHelium3(int quantity) {
                super(name, baseVolume, quantity);
            }
        }


        public static class LiquidHydrogen extends GasMaterials{
            private static final String name = "Liquid Hydrogen";
            private static final double baseVolume = 1;

            public LiquidHydrogen(int quantity) {
                super(name, baseVolume, quantity);
            }




        }



        public static class LiquidHydrogen2 extends GasMaterials{
            private static final String name = "Liquid Hydrogen-2";
            private static final double baseVolume = 1;


            public LiquidHydrogen2(int quantity) {
                super(name, baseVolume, quantity);
            }




        }

        public static class LiquidHydrogen3 extends GasMaterials{
            private static final String name = "Liquid Hydrogen-3";
            private static final double baseVolume = 1;

            public LiquidHydrogen3(int quantity) {
                super(name, baseVolume, quantity);
            }




        }




        public static class Water extends GasMaterials{
            private static final String name = "Water";
            private static final double baseVolume = 1;

            public Water(int quantity) {
                super(name, baseVolume, quantity);
            }
        }





    }












}
