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


            public SOLID_ORE(String name, double baseVolume, double baseMass, int quantity) {
                super(name, baseVolume, baseMass, quantity);
            }







            public static class IronOres extends SOLID_ORE {
                private static final double baseVolume = 0.2;

                public  IronOres(String name, double baseMass, int quantity) {
                    super(name, baseVolume, baseMass, quantity);
                }

                //From least density of Iron to the greatest. Gets refined into steel
                public static class Magnetite extends IronOres {
                    private static final String name = "Magnetite";
                    private static final double baseMass = 6021;

                    public Magnetite(int quantity) {
                        super(name, baseMass, quantity);
                    }
                }

                public static class ConcentratedMagnetite extends IronOres {
                    private static final String name = "Concentrated Magnetite";
                    private static final double baseMass = 9055;

                    public ConcentratedMagnetite(int quantity) {
                        super(name, baseMass, quantity);
                    }
                }

                public static class DenseMagnetite extends IronOres {
                    private static final String name = "Concentrated Magnetite";
                    private static final double baseMass = 13090;

                    public DenseMagnetite(int quantity) {
                        super(name, baseMass, quantity);
                    }
                }

            }






            public static class TitaniumOres extends SOLID_ORE{
                private static final double baseVolume = 0.2;

                public TitaniumOres(String name, double baseMass, int quantity) {
                    super(name, baseVolume, baseMass, quantity);
                }

                public static class Ilmenite extends TitaniumOres {
                    private static final String name = "Ilmenite";
                    private static final double baseMass = 5430;

                    public Ilmenite(int quantity) {
                        super(name, baseMass, quantity);
                    }
                }

                public static class HardenedIlmenite extends TitaniumOres {
                    private static final String name = "Hardened Ilmenite";
                    private static final double baseMass = 6740;


                    public HardenedIlmenite(int quantity) {
                        super(name, baseMass, quantity);
                    }
                }

                public static class SuperdenseIlmenite extends TitaniumOres {
                    private static final String name = "Superdense Ilmenite";
                    private static final double baseMass = 7130;

                    public SuperdenseIlmenite(int quantity) {
                        super(name, baseMass, quantity);
                    }
                }



            }

            public static class AluminumOres extends SOLID_ORE {
                private static final double baseVolume = 0.1;
                public AluminumOres(String name, double baseMass, int quantity) {

                    super(name, baseVolume, baseMass, quantity);
                }

                public static class Bauxite extends AluminumOres {
                    private static final String name = "Bauxite";
                    private static final double baseMass = 3510;
                    public Bauxite(int quantity) {
                        super(name, baseMass, quantity);
                    }
                }




                public static class ConcentratedBauxite extends AluminumOres {
                    private static final String name = "Concentrated Bauxite";
                    private static final double baseMass = 4000;
                    public ConcentratedBauxite(int quantity) {
                        super(name, baseMass, quantity);
                    }
                }


                public static class DenseBauxite extends AluminumOres {
                    private static final String name = "Dense Bauxite";
                    private static final double baseMass = 4650;

                    public DenseBauxite(int quantity) {
                        super(name, baseMass, quantity);
                    }
                }


            }

            public static class LeadOres extends SOLID_ORE{
                private static final double baseVolume = 1.5;
                public LeadOres(String name,  double baseMass, int quantity) {
                    super(name, baseVolume, baseMass, quantity);
                }

                public static class Galena extends LeadOres {
                    private static final String name = "Galena";
                    private static final double baseMass = 13000;

                    public Galena(int quantity) {
                        super(name, baseMass, quantity);
                    }
                }

                public static class SoftGalena extends LeadOres {
                    private static final String name = "Soft Galena";
                    private static final double baseMass = 15100;

                    public SoftGalena(int quantity) {
                        super(name, baseMass, quantity);
                    }
                }

                public static class VerySoftGalena extends LeadOres {
                    private static final String name = "Very Soft Galena";
                    private static final double baseMass = 17100;

                    public VerySoftGalena(int quantity) {
                        super(name, baseMass, quantity);
                    }
                }






            }

            public static class UraniumOres extends SOLID_ORE{
                private static final double baseVolume = 5;
                public UraniumOres(String name, double baseMass, int quantity) {
                    super(name, baseVolume, baseMass, quantity);
                }

                public static class Uraninite extends UraniumOres {
                    private static final String name = "Uraninite";
                    private static final double baseMass = 20000;

                    public Uraninite(int quantity) {
                        super(name, baseMass, quantity);
                    }
                }

                public static class HeavyUraninite extends UraniumOres {
                    private static final String name = "Heavy Uraninite";
                    private static final double baseMass = 23000;

                    public HeavyUraninite(int quantity) {
                        super(name, baseMass, quantity);
                    }
                }

                public static class SuperHeavyUraninite extends UraniumOres {
                    private static final String name = "Super Heavy Uraninite";
                    private static final double baseMass = 25000;

                    public SuperHeavyUraninite(int quantity) {
                        super(name, baseMass, quantity);
                    }
                }

            }


            public static class RhodiumOres extends SOLID_ORE {
                private static final double baseVolume = 3;
                public RhodiumOres(String name, double baseMass, int quantity) {
                    super(name, baseVolume, baseMass, quantity);
                }

                public static class Cuprorhodsite extends RhodiumOres {
                    private static final String name = "Cuprorhodsite";
                    private static final double baseMass = 13500;

                    public Cuprorhodsite(int quantity) {
                        super(name, baseMass, quantity);
                    }
                }

                public static class ShinyCuprorhodsite extends RhodiumOres {
                    private static final String name = "Shiny Cuprorhodsite";
                    private static final double baseMass = 15000;
                    public ShinyCuprorhodsite(int quantity) {
                        super(name, baseMass, quantity);
                    }
                }

                public static class PristineCuprorhodsite extends RhodiumOres {
                    private static final String name = "Pristine Cuprorhodsite";
                    private static final double baseMass = 16500;
                    public PristineCuprorhodsite(int quantity) {
                        super(name, baseMass, quantity);
                    }
                }
            }


            public static class SiliconOres extends SOLID_ORE {
                private static final double baseVolume = 0.1;

                public SiliconOres(String name, double baseMass, int quantity) {
                    super(name, baseVolume, baseMass, quantity);
                }

                public static class Feldspar extends SiliconOres {
                    private static final String name = "Feldspar";
                    private static final double baseMass = 3000;

                    public Feldspar(int quantity) {
                        super(name, baseMass, quantity);
                    }
                }

                public static class ThickFeldspar extends SiliconOres {
                    private static final String name = "Thick Feldspar";
                    private static final double baseMass = 4000;

                    public ThickFeldspar(int quantity) {
                        super(name, baseMass, quantity);
                    }
                }

                public static class RichFeldspar extends SiliconOres {
                    private static final String name = "Rich Feldspar";
                    private static final double baseMass = 5000;

                    public RichFeldspar(int quantity) {
                        super(name, baseMass, quantity);
                    }
                }


            }



















        }


        public static class ICE_ORE extends ORE{


            public ICE_ORE(String name, double baseVolume, double baseMass, int quantity) {
                super(name, baseVolume, baseMass, quantity);
            }


            public static class IceOre extends ICE_ORE{

                private static final double baseVolume = 1;
                public IceOre(String name, double baseMass, int quantity) {
                    super(name, baseVolume, baseMass, quantity);
                }

                public static class IceRock extends IceOre{
                    private static final String name = "Icy Rock";
                    private static final double baseMass = 1100;
                    public IceRock(int quantity) {
                        super(name, baseMass, quantity);
                    }
                }

                public static class ThickIceRock extends IceOre{
                    private static final String name = "Thick Icy Rock";
                    private static final double baseMass = 1300;

                    public ThickIceRock(int quantity) {
                        super(name, baseMass, quantity);
                    }
                }

                public static class PackedIceRock extends IceOre{
                    private static final String name = "Packed Icy Rock";
                    private static final double baseMass = 1500;
                    public PackedIceRock(int quantity) {
                        super(name, baseMass, quantity);
                    }
                }

            }

            public static class GlacialOres extends ICE_ORE{
                private static final double baseVolume = 1;
                public GlacialOres(String name, double baseMass, int quantity) {
                    super(name, baseVolume, baseMass, quantity);
                }

                public static class GlacialSnow extends GlacialOres {
                    private static final String name = "Glacial Snow";
                    private static final double baseMass = 700;

                    public GlacialSnow(int quantity) {
                        super(name,  baseMass, quantity);
                    }
                }

                public static class DenseGlacialSnow extends GlacialOres {
                    private static final String name = "Dense Glacial Snow";
                    private static final double baseMass = 900;
                    public DenseGlacialSnow(int quantity) {
                        super(name, baseMass, quantity);
                    }
                }

                public static class PureGlacialSnow extends GlacialOres {
                    private static final String name = "Pure Glacial Snow";
                    private static final double baseMass = 1100;

                    public PureGlacialSnow(int quantity) {
                        super(name, baseMass, quantity);
                    }
                }



            }

            public static class IceCrystalOres extends ICE_ORE{
                private static final double baseVolume = 10;
                public IceCrystalOres(String name, double baseMass, int quantity) {
                    super(name, baseVolume, baseMass, quantity);
                }

                public static class CrystallineIceShard extends IceCrystalOres{
                    private static final String name = "Crystalline Shard";
                    private static final double baseMass = 1500;

                    public CrystallineIceShard(int quantity) {
                        super(name, baseMass, quantity);
                    }
                }

                public static class RefinedCrystallineIceShard extends IceCrystalOres{
                    private static final String name = "Refined Crystalline Shard";
                    private static final double baseMass = 1700;

                    public RefinedCrystallineIceShard(int quantity) {
                        super(name, baseMass, quantity);
                    }
                }
                public static class PristineCrystallineIceShard extends IceCrystalOres{
                    private static final String name = "Pristine Crystalline Ice Shard";
                    private static final double baseMass = 2000;

                    public PristineCrystallineIceShard(int quantity) {
                        super(name, baseMass, quantity);
                    }
                }




            }








        }



        public static class GAS_ORE extends ORE{


            public GAS_ORE(String name, double baseVolume, double baseMass, int quantity) {
                super(name, baseVolume, baseMass, quantity);
            }


            public static class TritiumOres extends GAS_ORE{
                private static final double baseVolume = 0.1;
                public TritiumOres(String name, double baseMass, int quantity) {
                    super(name, baseVolume, baseMass, quantity);
                }

                public static class TritiumGas extends TritiumOres{
                    private static final String name = "Tritium Gas";
                    private static final double baseMass = 50;
                    public TritiumGas(int quantity) {
                        super(name, baseMass, quantity);
                    }
                }
                public static class CondensedTritiumOre extends TritiumOres{
                    private static final String name = "Condensed Tritium Gas";
                    private static final double baseMass = 70;

                    public CondensedTritiumOre(int quantity) {
                        super(name, baseMass, quantity);
                    }
                }
                public static class DenseTritiumOre extends TritiumOres{
                    private static final String name = "Condensed Tritium Gas";
                    private static final double baseMass = 100;

                    public DenseTritiumOre(int quantity) {
                        super(name, baseMass, quantity);
                    }
                }



            }

            public static class DeuteriumOres extends GAS_ORE{
                private static final double baseVolume = 0.1;
                public DeuteriumOres(String name, double baseMass, int quantity) {
                    super(name, baseVolume, baseMass, quantity);
                }

                public static class DeuteriumOre extends DeuteriumOres{
                    private static final String name = "Deuterium Gas";
                    private static final double baseMass = 30;

                    public DeuteriumOre(int quantity) {
                        super(name, baseMass, quantity);
                    }
                }

                public static class CondensedDeuteriumOre extends DeuteriumOres{
                    private static final String name = "Condensed Deuterium Gas";
                    private static final double baseMass = 50;

                    public CondensedDeuteriumOre(int quantity) {
                        super(name, baseMass, quantity);
                    }
                }

                public static class DenseDeuteriumOre extends DeuteriumOres{
                    private static final String name = "Condensed Deuterium Gas";
                    private static final double baseMass = 70;

                    public DenseDeuteriumOre(int quantity) {
                        super(name, baseMass, quantity);
                    }

                }


            }









            public static class HydrogenOres extends GAS_ORE{
                private static final double baseVolume = 0.1;
                public HydrogenOres(String name, double baseMass, int quantity) {
                    super(name, baseVolume, baseMass, quantity);
                }

                public static class HydrogenOre extends HydrogenOres{
                    private static final String name = "Hydrogen Gas";
                    private static final double baseMass = 10;

                    public HydrogenOre(int quantity) {
                        super(name, baseMass, quantity);
                    }
                }

                public static class CondensedHydrogenOre extends HydrogenOres{
                    private static final String name = "Condensed Hydrogen Gas";
                    private static final double baseMass = 15;

                    public CondensedHydrogenOre(int quantity) {
                        super(name, baseMass, quantity);
                    }
                }

                public static class DenseHydrogenOre extends HydrogenOres{
                    private static final String name = "Dense Hydrogen Gas";
                    private static final double baseMass = 25;

                    public DenseHydrogenOre(int quantity) {
                        super(name, baseMass, quantity);
                    }
                }

            }

            public static class HeliumOres extends GAS_ORE{
                private static final double baseVolume = 0.1;
                public HeliumOres(String name, double baseMass, int quantity) {
                    super(name, baseVolume, baseMass, quantity);
                }

                public static class HeliumOre extends HeliumOres{
                    private static final String name = "Helium Gas";
                    private static final double baseMass = 20;

                    public HeliumOre(int quantity) {
                        super(name, baseMass, quantity);
                    }
                }

                public static class CondensedHeliumOre extends HeliumOres{
                    private static final String name = "Condensed Helium Gas";
                    private static final double baseMass = 25;

                    public CondensedHeliumOre(int quantity) {
                        super(name, baseMass, quantity);
                    }
                }
                public static class DenseHeliumOre extends HeliumOres{
                    private static final String name = "Dense Hydrogen Gas";
                    private static final double baseMass = 30;

                    public DenseHeliumOre(int quantity) {
                        super(name, baseMass, quantity);
                    }
                }


            }

            public static class WaterVaporOres extends GAS_ORE{
                private static final double baseVolume = 50;
                public WaterVaporOres(String name, double baseMass, int quantity) {
                    super(name, baseVolume, baseMass, quantity);
                }

                public static class SteamOre extends WaterVaporOres{
                    private static final String name = "Steam";
                    private static final double baseMass = 60;

                    public SteamOre(int quantity) {
                        super(name, baseMass, quantity);
                    }
                }

                public static class CondensedWaterVaporOre extends WaterVaporOres{
                    private static final String name = "Condensed Steam";
                    private static final double baseMass = 70;

                    public CondensedWaterVaporOre(String name, double baseMass, int quantity) {
                        super(name, baseMass, quantity);
                    }
                }

                public static class SteamingWaterVaporOre extends WaterVaporOres{
                    private static final String name = "Thick Steam";
                    private static final double baseMass = 85;

                    public SteamingWaterVaporOre(String name, double baseMass, int quantity) {
                        super(name, baseMass, quantity);
                    }
                }



            }


            //Todo: May add specialty gases below
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
