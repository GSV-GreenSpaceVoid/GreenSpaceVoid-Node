package com.greenspacevoid.common.item.industry.resources;

import com.greenspacevoid.common.item.Item;

import java.util.ArrayList;

public class Resource extends Item {


    public Resource(String name, double baseVolume, double baseMass, int quantity) {
        super(name, baseVolume, baseMass, quantity);
    }



    public static class ORE extends Resource{

        private ORE(String name, double baseVolume, double baseMass, int quantity) {
            super(name, baseVolume, baseMass, quantity);
        }



        public static class SOLID_ORE extends ORE{


            private SOLID_ORE(String name, double baseVolume, double baseMass, int quantity) {
                super(name, baseVolume, baseMass, quantity);
            }







            public static class IronOres {
                //From least density of Iron to the greatest. Gets refined into steel
                public static class Magnetite extends IronOres {






                }

                public static class ConcentratedMagnetite extends IronOres {









                }

                public static class DenseMagnetite extends IronOres {





                }

            }






            public static class TitaniumOres {

                public static class Ilmenite extends TitaniumOres {






                }

                public static class HardenedIlmenite extends TitaniumOres {






                }

                public static class SuperdenseIlmenite extends TitaniumOres {






                }



            }

            public static class AluminumOres {
                public static class Bauxite extends AluminumOres {

                }




                public static class ConcentratedBauxite extends AluminumOres {

                }


                public static class DenseBauxite extends AluminumOres {

                }


            }

            public static class LeadOres {

                public static class Galena extends LeadOres {





                }

                public static class SoftGalena extends LeadOres {





                }

                public static class VerySoftGalena extends LeadOres {





                }






            }

            public static class UraniumOres {

                public static class Uraninite extends UraniumOres {




                }

                public static class HeavyUraninite extends UraniumOres {



                }

                public static class SuperHeavyUraninite extends UraniumOres {





                }

            }


            public static class RhodiumOres {

                public static class Cuprorhodsite extends RhodiumOres {

                }

                public static class ShinyCuprorhodsite extends RhodiumOres {

                }

                public static class PristineCuprorhodsite extends RhodiumOres {

                }

            }


            public static class SiliconOres {

                public static class Feldspar extends SiliconOres {






                }

                public static class ThickFeldspar extends SiliconOres {






                }

                public static class RichFeldspar extends SiliconOres {






                }


            }



















        }


        public static class ICE_ORE extends ORE{


            public ICE_ORE(String name, double baseVolume, double baseMass, int quantity) {
                super(name, baseVolume, baseMass, quantity);
            }


            public static class IceOre{

                public static class Ice extends IceOre{

                }

                public static class ThickIce extends IceOre{


                }

                public static class PackedIce extends IceOre{

                }

            }

            public static class GlacialOres {

                public static class GlacialSnow extends GlacialOres {


                }

                public static class DenseGlacialSnow extends GlacialOres {

                }

                public static class PureGlacialSnow extends GlacialOres {


                }



            }

            public static class IceCrystalOres{

                public static class CrystallineIceShard extends IceCrystalOres{



                }

                public static class RefinedCrystallineIceShard extends IceCrystalOres{




                }
                public static class PristineCrystallinIceeShard extends IceCrystalOres{


                }




            }








        }



        public static class GAS_ORE extends ORE{


            public GAS_ORE(String name, double baseVolume, double baseMass, int quantity) {
                super(name, baseVolume, baseMass, quantity);
            }


            public static class TritiumOres{
                public static class TritiumOre extends TritiumOres{

                }
                public static class CondensedTritiumOre extends TritiumOres{


                }
                public static class DenseTritiumOre extends TritiumOres{



                }



            }

            public static class DeuteriumOres{

                public static class DeuteriumOre extends DeuteriumOres{



                }

                public static class CondensedDeuteriumOre extends DeuteriumOres{



                }

                public static class DenseDeuteriumOre extends DeuteriumOres{

                }


            }









            public static class HydrogenOres{
                public static class HydrogenOre extends HydrogenOres{


                }

                public static class CondensedHydrogenOre extends HydrogenOres{



                }

                public static class DenseHydrogenOre extends HydrogenOres{



                }

            }

            public static class HeliumOres{
                public static class HeliumOre extends HeliumOres{


                }

                public static class CondensedHeliumOre extends HeliumOres{



                }
                public static class DenseHeliumOre extends HeliumOres{



                }


            }

            public static class WaterVaporOres{
                public static class WaterVaporOre extends WaterVaporOres{

                }

                public static class CondensedWaterVaporOre extends WaterVaporOres{


                }

                public static class SteamingWaterVaporOre extends WaterVaporOres{


                }



            }

            public static class Argon{






            }


            public static class Xenon{






            }









        }












    }













    public ArrayList<?> refine(){




        return null;

    }














}
