package com.greenspacevoidnode.common.core.item.industry.resources;

import com.greenspacevoidnode.common.core.item.Item;
import com.greenspacevoidnode.common.core.item.industry.materials.Material;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
//Todo: Balance the refinement values B)
public class Resource extends Item {

    private RefinementData[] data;

    public Resource(String name, double basevolume, int quantity, RefinementData[] data) {
        super(name, basevolume, quantity);
        this.data = data;
    }

    @Override
    public void initialize() {

    }


    //All resources must be refinable...Unless they refine into nothing :)








    public static class RefinementData{
        private Class<Material> material;
        private int yieldQuantity;

        public RefinementData(Class c, int yieldQuantity){
            this.material = c;
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

        ArrayList<Material> materials = new ArrayList<>();


        for(int i = 0; i < data.length; i++){
            try {
                Constructor constructor = data[i].material.getDeclaredConstructor(int.class);
                materials.add((Material) constructor.newInstance(data[i].getYieldQuantity()));
            }catch(Exception e){
                e.printStackTrace();
            }


        }
        return materials;

    }














}



