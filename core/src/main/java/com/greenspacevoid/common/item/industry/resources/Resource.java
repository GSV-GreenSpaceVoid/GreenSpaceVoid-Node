package com.greenspacevoid.common.item.industry.resources;

import com.greenspacevoid.common.item.Item;
import com.greenspacevoid.common.item.industry.materials.Material;

import java.util.ArrayList;

public class Resource extends Item {

    private ArrayList<RefinementData> data;
    //All resources must be refinable...Unless they refine into nothing :)
    public Resource(String name, double baseVolume, int quantity, ArrayList<RefinementData> data) {
        super(name, baseVolume, quantity);
        this.data = data;
    }



    public static class ORE extends Resource{

        private ORE(String name, double baseVolume, int quantity, ArrayList<RefinementData> data) {
            super(name, baseVolume, quantity, data);
        }




        public static class SOLID_ORE extends ORE{


            public SOLID_ORE(String name, double baseVolume, int quantity, ArrayList<RefinementData> data) {
                super(name, baseVolume, quantity, data);
            }







            public static class IronOres extends SOLID_ORE {
                private static final double baseVolume = 0.2;

                public  IronOres(String name, int quantity, ArrayList<RefinementData> data) {
                    super(name, baseVolume, quantity, data);
                }

                //From least density of Iron to the greatest. Gets refined into steel
                public static class Magnetite extends IronOres {
                    private static final String name = "Magnetite";
                    private static final double baseMass = 6021;
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};



                    public Magnetite(int quantity) {
                        super(name, quantity, data);
                    }


                }

                public static class ConcentratedMagnetite extends IronOres {
                    private static final String name = "Concentrated Magnetite";
                    private static final double baseMass = 9055;
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};

                    public ConcentratedMagnetite(int quantity) {
                        super(name, quantity, data);
                    }
                }

                public static class DenseMagnetite extends IronOres {
                    private static final String name = "Concentrated Magnetite";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};

                    public DenseMagnetite(int quantity) {
                        super(name, quantity, data);
                    }
                }

            }






            public static class TitaniumOres extends SOLID_ORE{
                private static final double baseVolume = 0.2;

                public TitaniumOres(String name, int quantity, ArrayList<RefinementData> data) {
                    super(name, baseVolume, quantity, data);
                }

                public static class Ilmenite extends TitaniumOres {
                    private static final String name = "Ilmenite";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};

                    public Ilmenite(int quantity) {
                        super(name, quantity, data);
                    }
                }

                public static class HardenedIlmenite extends TitaniumOres {
                    private static final String name = "Hardened Ilmenite";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};


                    public HardenedIlmenite(int quantity) {
                        super(name, quantity, data);
                    }
                }

                public static class SuperdenseIlmenite extends TitaniumOres {
                    private static final String name = "Superdense Ilmenite";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add(new RefinementData(Material.SolidMaterials.Titanium.class, 2));
                        add("B");
                        add("C");
                    }};

                    public SuperdenseIlmenite(int quantity) {
                        super(name, quantity, data);
                    }
                }



            }

            public static class AluminumOres extends SOLID_ORE {
                private static final double baseVolume = 0.1;
                public AluminumOres(String name, int quantity, ArrayList<RefinementData> data) {

                    super(name, baseVolume, quantity, data);
                }

                public static class Bauxite extends AluminumOres {
                    private static final String name = "Bauxite";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};
                    public Bauxite(int quantity) {
                        super(name, quantity, data);
                    }
                }




                public static class ConcentratedBauxite extends AluminumOres {
                    private static final String name = "Concentrated Bauxite";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};
                    public ConcentratedBauxite(int quantity) {
                        super(name, quantity, data);
                    }
                }


                public static class DenseBauxite extends AluminumOres {
                    private static final String name = "Dense Bauxite";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};

                    public DenseBauxite(int quantity) {
                        super(name, quantity, data);
                    }
                }


            }

            public static class LeadOres extends SOLID_ORE{
                private static final double baseVolume = 1.5;
                public LeadOres(String name, int quantity, ArrayList<RefinementData> data) {
                    super(name, baseVolume, quantity, data);
                }

                public static class Galena extends LeadOres {
                    private static final String name = "Galena";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};

                    public Galena(int quantity) {
                        super(name, quantity, data);
                    }
                }

                public static class SoftGalena extends LeadOres {
                    private static final String name = "Soft Galena";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};

                    public SoftGalena(int quantity) {
                        super(name, quantity, data);
                    }
                }

                public static class VerySoftGalena extends LeadOres {
                    private static final String name = "Very Soft Galena";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};

                    public VerySoftGalena(int quantity) {
                        super(name, quantity, data);
                    }
                }






            }

            public static class UraniumOres extends SOLID_ORE{
                private static final double baseVolume = 5;
                public UraniumOres(String name, int quantity, ArrayList<RefinementData> data) {
                    super(name, baseVolume, quantity, data);
                }

                public static class Uraninite extends UraniumOres {
                    private static final String name = "Uraninite";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};

                    public Uraninite(int quantity) {
                        super(name, quantity, data);
                    }
                }

                public static class HeavyUraninite extends UraniumOres {
                    private static final String name = "Heavy Uraninite";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};

                    public HeavyUraninite(int quantity) {
                        super(name, quantity, data);
                    }
                }

                public static class SuperHeavyUraninite extends UraniumOres {
                    private static final String name = "Super Heavy Uraninite";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};

                    public SuperHeavyUraninite(int quantity) {
                        super(name, quantity, data);
                    }
                }

            }


            public static class RhodiumOres extends SOLID_ORE {
                private static final double baseVolume = 3;
                public RhodiumOres(String name, int quantity, ArrayList<RefinementData> data) {
                    super(name, baseVolume, quantity, data);
                }

                public static class Cuprorhodsite extends RhodiumOres {
                    private static final String name = "Cuprorhodsite";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};

                    public Cuprorhodsite(int quantity) {
                        super(name, quantity, data);
                    }
                }

                public static class ShinyCuprorhodsite extends RhodiumOres {
                    private static final String name = "Shiny Cuprorhodsite";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};
                    public ShinyCuprorhodsite(int quantity) {
                        super(name, quantity, data);
                    }
                }

                public static class PristineCuprorhodsite extends RhodiumOres {
                    private static final String name = "Pristine Cuprorhodsite";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};
                    public PristineCuprorhodsite(int quantity) {
                        super(name, quantity, data);
                    }
                }
            }


            public static class SiliconOres extends SOLID_ORE {
                private static final double baseVolume = 0.1;

                public SiliconOres(String name, int quantity, ArrayList<RefinementData> data) {
                    super(name, baseVolume, quantity, data);
                }

                public static class Feldspar extends SiliconOres {
                    private static final String name = "Feldspar";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};

                    public Feldspar(int quantity) {
                        super(name, quantity data);
                    }
                }

                public static class ThickFeldspar extends SiliconOres {
                    private static final String name = "Thick Feldspar";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};

                    public ThickFeldspar(int quantity) {
                        super(name, quantity, data);
                    }
                }

                public static class RichFeldspar extends SiliconOres {
                    private static final String name = "Rich Feldspar";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};

                    public RichFeldspar(int quantity) {
                        super(name, quantity, data);
                    }
                }


            }



















        }


        public static class ICE_ORE extends ORE{


            public ICE_ORE(String name, double baseVolume, int quantity, ArrayList<RefinementData> data) {
                super(name, baseVolume, quantity, data);
            }


            public static class IceOre extends ICE_ORE{

                private static final double baseVolume = 1;
                public IceOre(String name, int quantity, ArrayList<RefinementData> data) {
                    super(name, baseVolume, quantity, data);
                }

                public static class IceRock extends IceOre{
                    private static final String name = "Icy Rock";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};
                    public IceRock(int quantity) {
                        super(name, quantity, data);
                    }
                }

                public static class ThickIceRock extends IceOre{
                    private static final String name = "Thick Icy Rock";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};

                    public ThickIceRock(int quantity) {
                        super(name, quantity, data);
                    }
                }

                public static class PackedIceRock extends IceOre{
                    private static final String name = "Packed Icy Rock";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};
                    public PackedIceRock(int quantity) {
                        super(name, quantity);
                    }
                }

            }

            public static class GlacialOres extends ICE_ORE{
                private static final double baseVolume = 1;
                public GlacialOres(String name, int quantity, ArrayList<RefinementData> data) {
                    super(name, baseVolume, quantity, data);
                }

                public static class GlacialSnow extends GlacialOres {
                    private static final String name = "Glacial Snow";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};
                    public GlacialSnow(int quantity) {
                        super(name, quantity, data);
                    }
                }

                public static class DenseGlacialSnow extends GlacialOres {
                    private static final String name = "Dense Glacial Snow";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};
                    public DenseGlacialSnow(int quantity) {
                        super(name, quantity, data);
                    }
                }

                public static class PureGlacialSnow extends GlacialOres {
                    private static final String name = "Pure Glacial Snow";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};

                    public PureGlacialSnow(int quantity) {
                        super(name, quantity, data);
                    }
                }



            }

            public static class IceCrystalOres extends ICE_ORE{
                private static final double baseVolume = 10;
                public IceCrystalOres(String name, int quantity, ArrayList<RefinementData> data) {
                    super(name, baseVolume, quantity, data);
                }

                public static class CrystallineIceShard extends IceCrystalOres{
                    private static final String name = "Crystalline Shard";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};

                    public CrystallineIceShard(int quantity) {
                        super(name, quantity, data);
                    }
                }

                public static class RefinedCrystallineIceShard extends IceCrystalOres{
                    private static final String name = "Refined Crystalline Shard";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};

                    public RefinedCrystallineIceShard(int quantity) {
                        super(name, quantity, data);
                    }
                }
                public static class PristineCrystallineIceShard extends IceCrystalOres{
                    private static final String name = "Pristine Crystalline Ice Shard";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};

                    public PristineCrystallineIceShard(int quantity) {
                        super(name, quantity, data);
                    }
                }




            }








        }



        public static class GAS_ORE extends ORE{


            public GAS_ORE(String name, double baseVolume, int quantity, ArrayList<RefinementData> data) {
                super(name, baseVolume, quantity, data);
            }


            public static class TritiumOres extends GAS_ORE{
                private static final double baseVolume = 0.1;




                public TritiumOres(String name, int quantity, ArrayList<RefinementData> data) {
                    super(name, baseVolume, quantity, data);
                }

                public static class TritiumGas extends TritiumOres{
                    private static final String name = "Tritium Gas";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};
                    public TritiumGas(int quantity) {
                        super(name, quantity, data);
                    }
                }
                public static class CondensedTritiumOre extends TritiumOres{
                    private static final String name = "Condensed Tritium Gas";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};

                    public CondensedTritiumOre(int quantity) {
                        super(name, quantity, data);
                    }
                }
                public static class DenseTritiumOre extends TritiumOres{
                    private static final String name = "Condensed Tritium Gas";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};

                    public DenseTritiumOre(int quantity) {
                        super(name, quantity, data);
                    }
                }



            }

            public static class DeuteriumOres extends GAS_ORE{
                private static final double baseVolume = 0.1;
                public DeuteriumOres(String name, int quantity, ArrayList<RefinementData> data) {
                    super(name, baseVolume, quantity, data);
                }

                public static class DeuteriumOre extends DeuteriumOres{
                    private static final String name = "Deuterium Gas";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};

                    public DeuteriumOre(int quantity) {
                        super(name, quantity, data);
                    }
                }

                public static class CondensedDeuteriumOre extends DeuteriumOres{
                    private static final String name = "Condensed Deuterium Gas";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};

                    public CondensedDeuteriumOre(int quantity) {
                        super(name, quantity, data);
                    }
                }

                public static class DenseDeuteriumOre extends DeuteriumOres{
                    private static final String name = "Condensed Deuterium Gas";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};

                    public DenseDeuteriumOre(int quantity) {
                        super(name, quantity, data);
                    }

                }


            }









            public static class HydrogenOres extends GAS_ORE{
                private static final double baseVolume = 0.1;
                public HydrogenOres(String name, int quantity, ArrayList<Material> data) {
                    super(name, baseVolume, quantity, data);
                }

                public static class HydrogenOre extends HydrogenOres{
                    private static final String name = "Hydrogen Gas";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};

                    public HydrogenOre(int quantity) {
                        super(name, quantity, data);
                    }
                }

                public static class CondensedHydrogenOre extends HydrogenOres{
                    private static final String name = "Condensed Hydrogen Gas";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};

                    public CondensedHydrogenOre(int quantity) {
                        super(name, quantity, data);
                    }
                }

                public static class DenseHydrogenOre extends HydrogenOres{
                    private static final String name = "Dense Hydrogen Gas";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};

                    public DenseHydrogenOre(int quantity) {
                        super(name, quantity, data);
                    }
                }

            }

            public static class HeliumOres extends GAS_ORE{
                private static final double baseVolume = 0.1;
                public HeliumOres(String name, int quantity, ArrayList<Material> data) {
                    super(name, baseVolume, quantity, data);
                }

                public static class HeliumOre extends HeliumOres{
                    private static final String name = "Helium Gas";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};

                    public HeliumOre(int quantity) {
                        super(name, quantity, data);
                    }
                }

                public static class CondensedHeliumOre extends HeliumOres{
                    private static final String name = "Condensed Helium Gas";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};

                    public CondensedHeliumOre(int quantity) {
                        super(name, quantity,data);
                    }
                }
                public static class DenseHeliumOre extends HeliumOres{
                    private static final String name = "Dense Hydrogen Gas";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};

                    public DenseHeliumOre(int quantity) {
                        super(name, quantity, data);
                    }
                }


            }

            public static class WaterVaporOres extends GAS_ORE{
                private static final double baseVolume = 50;
                public WaterVaporOres(String name, int quantity, ArrayList<RefinementData> data) {
                    super(name, baseVolume, quantity, data);
                }

                public static class SteamOre extends WaterVaporOres{
                    private static final String name = "Steam";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};

                    public SteamOre(int quantity) {
                        super(name, quantity, data);
                    }
                }

                public static class CondensedWaterVaporOre extends WaterVaporOres{
                    private static final String name = "Condensed Steam";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};

                    public CondensedWaterVaporOre(String name, double baseMass, int quantity) {
                        super(name, quantity, data);
                    }
                }

                public static class SteamingWaterVaporOre extends WaterVaporOres{
                    private static final String name = "Thick Steam";
                    private static final ArrayList<RefinementData> data = new ArrayList<>() {{
                        add("A");
                        add("B");
                        add("C");
                    }};

                    public SteamingWaterVaporOre(String name, double baseMass, int quantity) {
                        super(name, quantity, data);
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



    public static class RefinementData{
        private Class<Material> material;
        private int yieldQuantity;

        public RefinementData(Class<Material> c, int yieldQuantity){
        this.yieldQuantity = yieldQuantity;



        }

        public Class<Material> getMaterial() {
            return material;
        }

        public int getYieldQuantity() {
            return yieldQuantity;
        }
    }









    public ArrayList<Material> refine(){




        return null;

    }














}



