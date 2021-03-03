package com.greenspacevoid.common.item;

import com.greenspacevoid.common.item.industry.resources.Resource;
import com.greenspacevoid.engine.exceptions.ErrorMessages;

import java.util.ArrayList;

public class Item {
    String name;
    double volume;
    int quantity;


    public Item(String name, double volume, int quantity){
        this.name = name;
        this.volume = volume;
        //this.baseMass = baseMass;

        if(quantity <= 0){
            this.quantity = 1;
        }
        this.quantity = quantity;
        //Todo: Calculate total volume/mass based on quantity!





    }


    public void update(){
        /*Todo: This method is called in every grandchild class.




         */







    }




     //public void stack(){


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getVolume() {
        return volume;
    }


    public int getQuantity() {
        return quantity;
    }









    public static class CargoHold{
        ArrayList<Item> cargoHold = new ArrayList<>();
        double cargoHoldSpace;
        public CargoHold(double cargoHoldSpace){
            this.cargoHoldSpace = cargoHoldSpace;




        }

        public ArrayList<Item> getCargoHold() {
            return cargoHold;
        }

        public double getCargoHoldSpace() {
            return cargoHoldSpace;
        }

        public void setCargoHoldSpace(double cargoHoldSpace) throws ErrorMessages.CargoHoldNotEmptyException {
            if (currentAvailableSpace() != cargoHoldSpace || cargoHold.size() != 0){//May want to use ampersand for security
                throw new ErrorMessages.CargoHoldNotEmptyException();

            }else {
                this.cargoHoldSpace = cargoHoldSpace;
            }
        }

        public double currentAvailableSpace(){
            double usedCargoSpace = 0;
            for(Item item : cargoHold){
                usedCargoSpace += item.getVolume();
            }
            return usedCargoSpace;
        }






        public void add(Item item, ArrayList<Item> storedWhere, boolean stack){//Do not stack if false!
            if (storedWhere != null) {//Must specify valid previously stored location.
                if (item.getQuantity() * item.getVolume() < currentAvailableSpace()) {
                    if (stack) {
                        for (Item i : cargoHold) {
                            if (i.getClass().equals(item.getClass())) {
                                i.setQuantity(i.getQuantity() + item.getQuantity());
                                storedWhere.remove(item);
                                break;
                            }
                        }
                    } else {//Don't stack, add new item
                        cargoHold.add(item);
                        storedWhere.remove(item);
                    }
                }
            }
        }


        public void stack(Item targetItem, Item destinationItem){//Todo: Add exception

            if(cargoHold.contains(targetItem) && cargoHold.contains(destinationItem)) {


                //Might want to add the currentAvailableSpace method if clause for security. But otherwise, meh...
                if (targetItem.getClass().equals(destinationItem.getClass())) {
                    destinationItem.setQuantity(destinationItem.getQuantity() + targetItem.getQuantity());
                    cargoHold.remove(targetItem);
                }
            }
        }









    }

    public static class OreHold extends CargoHold{


        public OreHold(double cargoHoldSpace) {
            super(cargoHoldSpace);
        }


        @Override
        public void add(Item item, ArrayList<Item> storedWhere, boolean stack) {
            if(item instanceof Resource.ORE){
                super.add(item, storedWhere, stack);


            }else{

                //Return exception.. Can't fit non-ores in the ore hold!
            }

        }
    }





    public static class ShipHold {
        double volume;


        private ShipHold (double volume){
            this.volume = volume;

        }

        //Add ships, pack ships, move ships, delete ships.




        public static class StationShipHold extends ShipHold{


            private StationShipHold(double volume) {
                super(volume);
            }
        }

        //Override methods of course. As stations have infinite storage space B)









    }


}
