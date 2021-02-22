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
                public  IronOres(String name, double baseVolume, double baseMass, int quantity) {
                    super(name, baseVolume, baseMass, quantity);
                }

                //From least density of Iron to the greatest. Gets refined into steel
                public static class Magnetite extends IronOres {


                    public Magnetite(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }

                public static class ConcentratedMagnetite extends IronOres {


                    public ConcentratedMagnetite(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }

                public static class DenseMagnetite extends IronOres {


                    public DenseMagnetite(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }

            }






            public static class TitaniumOres extends SOLID_ORE{

                public TitaniumOres(String name, double baseVolume, double baseMass, int quantity) {
                    super(name, baseVolume, baseMass, quantity);
                }

                public static class Ilmenite extends TitaniumOres {


                    public Ilmenite(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }

                public static class HardenedIlmenite extends TitaniumOres {


                    public HardenedIlmenite(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }

                public static class SuperdenseIlmenite extends TitaniumOres {


                    public SuperdenseIlmenite(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }



            }

            public static class AluminumOres extends SOLID_ORE {
                public AluminumOres(String name, double baseVolume, double baseMass, int quantity) {
                    super(name, baseVolume, baseMass, quantity);
                }

                public static class Bauxite extends AluminumOres {

                    public Bauxite(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }




                public static class ConcentratedBauxite extends AluminumOres {

                    public ConcentratedBauxite(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }


                public static class DenseBauxite extends AluminumOres {

                    public DenseBauxite(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }


            }

            public static class LeadOres extends SOLID_ORE{

                public LeadOres(String name, double baseVolume, double baseMass, int quantity) {
                    super(name, baseVolume, baseMass, quantity);
                }

                public static class Galena extends LeadOres {


                    public Galena(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }

                public static class SoftGalena extends LeadOres {


                    public SoftGalena(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }

                public static class VerySoftGalena extends LeadOres {


                    public VerySoftGalena(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }






            }

            public static class UraniumOres extends SOLID_ORE{

                public UraniumOres(String name, double baseVolume, double baseMass, int quantity) {
                    super(name, baseVolume, baseMass, quantity);
                }

                public static class Uraninite extends UraniumOres {


                    public Uraninite(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }

                public static class HeavyUraninite extends UraniumOres {


                    public HeavyUraninite(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }

                public static class SuperHeavyUraninite extends UraniumOres {


                    public SuperHeavyUraninite(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }

            }


            public static class RhodiumOres extends SOLID_ORE {

                public RhodiumOres(String name, double baseVolume, double baseMass, int quantity) {
                    super(name, baseVolume, baseMass, quantity);
                }

                public static class Cuprorhodsite extends RhodiumOres {

                    public Cuprorhodsite(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }

                public static class ShinyCuprorhodsite extends RhodiumOres {

                    public ShinyCuprorhodsite(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }

                public static class PristineCuprorhodsite extends RhodiumOres {

                    public PristineCuprorhodsite(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }

            }


            public static class SiliconOres extends SOLID_ORE {

                public SiliconOres(String name, double baseVolume, double baseMass, int quantity) {
                    super(name, baseVolume, baseMass, quantity);
                }

                public static class Feldspar extends SiliconOres {


                    public Feldspar(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }

                public static class ThickFeldspar extends SiliconOres {


                    public ThickFeldspar(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }

                public static class RichFeldspar extends SiliconOres {


                    public RichFeldspar(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }


            }



















        }


        public static class ICE_ORE extends ORE{


            public ICE_ORE(String name, double baseVolume, double baseMass, int quantity) {
                super(name, baseVolume, baseMass, quantity);
            }


            public static class IceOre extends ICE_ORE{

                public IceOre(String name, double baseVolume, double baseMass, int quantity) {
                    super(name, baseVolume, baseMass, quantity);
                }

                public static class Ice extends IceOre{

                    public Ice(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }

                public static class ThickIce extends IceOre{


                    public ThickIce(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }

                public static class PackedIce extends IceOre{

                    public PackedIce(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }

            }

            public static class GlacialOres extends ICE_ORE{

                public GlacialOres(String name, double baseVolume, double baseMass, int quantity) {
                    super(name, baseVolume, baseMass, quantity);
                }

                public static class GlacialSnow extends GlacialOres {


                    public GlacialSnow(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }

                public static class DenseGlacialSnow extends GlacialOres {

                    public DenseGlacialSnow(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }

                public static class PureGlacialSnow extends GlacialOres {


                    public PureGlacialSnow(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }



            }

            public static class IceCrystalOres extends ICE_ORE{

                public IceCrystalOres(String name, double baseVolume, double baseMass, int quantity) {
                    super(name, baseVolume, baseMass, quantity);
                }

                public static class CrystallineIceShard extends IceCrystalOres{


                    public CrystallineIceShard(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }

                public static class RefinedCrystallineIceShard extends IceCrystalOres{


                    public RefinedCrystallineIceShard(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }
                public static class PristineCrystallinIceeShard extends IceCrystalOres{


                    public PristineCrystallinIceeShard(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }




            }








        }



        public static class GAS_ORE extends ORE{


            public GAS_ORE(String name, double baseVolume, double baseMass, int quantity) {
                super(name, baseVolume, baseMass, quantity);
            }


            public static class TritiumOres extends GAS_ORE{
                public TritiumOres(String name, double baseVolume, double baseMass, int quantity) {
                    super(name, baseVolume, baseMass, quantity);
                }

                public static class TritiumOre extends TritiumOres{

                    public TritiumOre(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }
                public static class CondensedTritiumOre extends TritiumOres{


                    public CondensedTritiumOre(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }
                public static class DenseTritiumOre extends TritiumOres{


                    public DenseTritiumOre(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }



            }

            public static class DeuteriumOres extends GAS_ORE{

                public DeuteriumOres(String name, double baseVolume, double baseMass, int quantity) {
                    super(name, baseVolume, baseMass, quantity);
                }

                public static class DeuteriumOre extends DeuteriumOres{


                    public DeuteriumOre(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }

                public static class CondensedDeuteriumOre extends DeuteriumOres{


                    public CondensedDeuteriumOre(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }

                public static class DenseDeuteriumOre extends DeuteriumOres{

                    public DenseDeuteriumOre(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }


            }









            public static class HydrogenOres extends GAS_ORE{
                public HydrogenOres(String name, double baseVolume, double baseMass, int quantity) {
                    super(name, baseVolume, baseMass, quantity);
                }

                public static class HydrogenOre extends HydrogenOres{


                    public HydrogenOre(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }

                public static class CondensedHydrogenOre extends HydrogenOres{


                    public CondensedHydrogenOre(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }

                public static class DenseHydrogenOre extends HydrogenOres{


                    public DenseHydrogenOre(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }

            }

            public static class HeliumOres extends GAS_ORE{
                public HeliumOres(String name, double baseVolume, double baseMass, int quantity) {
                    super(name, baseVolume, baseMass, quantity);
                }

                public static class HeliumOre extends HeliumOres{


                    public HeliumOre(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }

                public static class CondensedHeliumOre extends HeliumOres{


                    public CondensedHeliumOre(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }
                public static class DenseHeliumOre extends HeliumOres{


                    public DenseHeliumOre(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }


            }

            public static class WaterVaporOres extends GAS_ORE{
                public WaterVaporOres(String name, double baseVolume, double baseMass, int quantity) {
                    super(name, baseVolume, baseMass, quantity);
                }

                public static class WaterVaporOre extends WaterVaporOres{

                    public WaterVaporOre(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }

                public static class CondensedWaterVaporOre extends WaterVaporOres{


                    public CondensedWaterVaporOre(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
                }

                public static class SteamingWaterVaporOre extends WaterVaporOres{


                    public SteamingWaterVaporOre(String name, double baseVolume, double baseMass, int quantity) {
                        super(name, baseVolume, baseMass, quantity);
                    }
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
