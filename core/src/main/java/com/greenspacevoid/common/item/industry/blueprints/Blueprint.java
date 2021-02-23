package com.greenspacevoid.common.item.industry.blueprints;

import com.greenspacevoid.common.item.Item;

public class Blueprint extends Item {
    private static final double baseVolume = 1;

    public Blueprint(String name, int quantity) {
        super(name,baseVolume, quantity);
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
