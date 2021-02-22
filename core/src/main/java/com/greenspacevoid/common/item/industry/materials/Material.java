package com.greenspacevoid.common.item.industry.materials;

import com.greenspacevoid.common.item.Item;

public class Material extends Item {


    public Material(String name, double baseVolume, double baseMass, int quantity) {
        super(name, baseVolume, baseMass, quantity);
    }




    //Refined Materials below:


    public static class SolidMaterials {

        

        public static class Steel extends SolidMaterials{


        }

        public static class Aluminum extends SolidMaterials{


        }

        public static class Titanium extends SolidMaterials{


        }

        public static class Rhodium extends SolidMaterials{


        }

        public static class Uranium extends SolidMaterials{


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
