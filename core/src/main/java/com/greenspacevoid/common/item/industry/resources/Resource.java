package com.greenspacevoid.common.item.industry.resources;

import com.greenspacevoid.common.item.Item;

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







            public static class IronOre {
                //From least density of Iron to the greatest. Gets refined into steel
                public static class Magnetite extends IronOre {






                }

                public static class ConcentratedMagnetite extends IronOre{









                }

                public static class DenseMagnetite extends IronOre{





                }

            }






            public static class TitaniumOre {

                public static class Ilmenite extends TitaniumOre{






                }

                public static class HardenedIlmenite extends TitaniumOre{






                }

                public static class SuperdenseIlmenite extends TitaniumOre{






                }



            }

            public static class AluminumOre {
                public static class Bauxite extends AluminumOre{

                }




                public static class ConcentratedBauxite extends AluminumOre{

                }


                public static class DenseBauxite extends AluminumOre{

                }


            }

            public static class LeadOre{

                public static class Galena extends LeadOre{





                }

                public static class SoftGalena extends LeadOre{





                }

                public static class VerySoftGalena extends LeadOre{





                }






            }

            public static class UraniumOre{

                public static class Uraninite extends UraniumOre{




                }

                public static class HeavyUraninite extends UraniumOre{



                }

                public static class SuperHeavyUraninite extends UraniumOre{





                }

            }


            public static class RhodiumOre {

                public static class Cuprorhodsite extends RhodiumOre{

                }

                public static class ShinyCuprorhodsite extends RhodiumOre{

                }

                public static class PristineCuprorhodsite extends RhodiumOre{

                }

            }


            public static class SiliconOre{

                public static class Feldspar extends SiliconOre{






                }

                public static class ThickFeldspar extends SiliconOre{






                }

                public static class RichFeldspar extends SiliconOre{






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

            public static class GlacialOre{

                public static class GlacialSnow extends GlacialOre{


                }

                public static class DenseGlacialSnow extends GlacialOre{

                }

                public static class PureGlacialSnow extends GlacialOre{


                }



            }

            public static class IceCrystalOre{

                public static class CrystallineIceShard extends IceCrystalOre{



                }

                public static class RefinedCrystallineIceShard extends IceCrystalOre{




                }
                public static class PristineCrystallinIceeShard extends IceCrystalOre{


                }




            }








        }



        public static class GAS_ORE extends ORE{


            public GAS_ORE(String name, double baseVolume, double baseMass, int quantity) {
                super(name, baseVolume, baseMass, quantity);
            }



            public static class Hydrogen{




            }

            public static class Oxygen{



            }

            public static class Nitrogen{



            }

            public static class Argon{






            }


            public static class Xenon{






            }









        }












    }
















}
