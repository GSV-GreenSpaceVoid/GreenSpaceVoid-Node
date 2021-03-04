package com.greenspacevoidnode.common.item.industry.blueprints;

import com.greenspacevoidnode.common.item.Item;

public class Blueprint extends Item {
    private static final double baseVolume = 1;

    private Recipe[] recipes;

    public Blueprint(String name, int quantity, Recipe[] recipes) {
        super(name,baseVolume, quantity);
        this.recipes = recipes;
    }




    public static class Recipe{
        private Class<Item> itemClass;
        private int quantity;

        public Recipe(Class itemClass, int quantity){
            this.itemClass = itemClass;
            this.quantity = quantity;
        }

        public Class<Item> getItemClass() {
            return itemClass;
        }

        public int getQuantity() {
            return quantity;
        }
    }























}
