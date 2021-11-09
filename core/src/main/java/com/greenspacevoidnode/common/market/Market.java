package com.greenspacevoidnode.common.market;



import com.greenspacevoidnode.common.player.Player;
import com.greenspacevoidnode.sql.Saveable;

import javax.persistence.*;

public class Market {



    @Entity
    @Table(name ="listing")
    public static class Listing implements Saveable {


        @Id @GeneratedValue
        @Column(name = "id")
        long id;

        @Column(name = "sellerID")
        String sellerID; // Determines who receives the funds
        @Column(name = "assetLocation")
        String assetLocation; //The station where the item is located
        @Column(name = "assetID")
        String assetID; //What is being sold

        @Column(name = "quantity")
        int quantity; //Quantity
        @Column(name = "price")
        float price; //Price per quantity


        public Listing(long id, String sellerID, String assetLocation, String assetID, int quantity, float price) {
            this.id = id;
            this.sellerID = sellerID;
            this.assetLocation = assetLocation;
            this.assetID = assetID;
            this.quantity = quantity;
            this.price = price;

        }




        public void purchase(Player player, int quantity){
            float total = quantity * this.getPrice();
            int totalQuantity = this.getQuantity() - quantity;
            //Todo: Stick in station hangar bay

            if(player.getCurrency() > total && totalQuantity >= 0){
                player.setCurrency(player.getCurrency() - total);
                this.setQuantity(this.getQuantity() - quantity);

            }else if(totalQuantity < 0){
                player.warn("Not enough available!");
            }else if (total < 0){
                player.warn("Not enough money!");
            }

        }

        public void removeListing(Player player){






        }

        public void removeQuantity(Player player, int quantity){





        }


        @Override
        public long getId() {
            return id;
        }

        @Override
        public void setId(long id) {
            this.id = id;
        }

        @Override
        public void initialize() {

        }

        public String getSellerID() {
            return sellerID;
        }

        public void setSellerID(String sellerID) {
            this.sellerID = sellerID;
        }

        public String getAssetLocation() {
            return assetLocation;
        }

        public void setAssetLocation(String assetLocation) {
            this.assetLocation = assetLocation;
        }

        public String getAssetID() {
            return assetID;
        }

        public void setAssetID(String assetID) {
            this.assetID = assetID;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }
    }
























}
