package com.greenspacevoidnode.common.item;

import com.greenspacevoidnode.common.item.industry.resources.Resource;
import com.greenspacevoidnode.engine.exceptions.ErrorMessages;

import javax.persistence.*;
import java.util.ArrayList;






@MappedSuperclass
public class Item {

    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;//This may be redundant as this is an item. But so be it...


    private double baseVolume, volume; //Computed/onJar values values. No need for database access.




    @Column(name = "quantity")
    private int quantity;


    public Item(String name, double basevolume, int quantity){
        this.name = name;
        this.baseVolume = basevolume;
        //this.baseMass = baseMass;

        if(quantity <= 0){//No zero quantities around here!
            this.quantity = 1;
        }else {
            this.quantity = quantity;
        }




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

    public double getBaseVolume() {
        return baseVolume;
    }

    public void setBaseVolume(double baseVolume) {
        this.baseVolume = baseVolume;
    }

    public double getVolume() {

        if (volume <= 0){
            return baseVolume;
        }

        return volume;
    }


    public int getQuantity() {
        return quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @MappedSuperclass
    public static class GenericHold { //Stores items
        @Id @GeneratedValue
        @Column(name = "id")
        private long id;

        @Column(name = "contents")
        private String contents;


        private ArrayList<Item> genericHold = new ArrayList<>();
        private double baseCargoHoldSpace;
        private double currentCargoHoldSpace; //Modified basevalue, not accumulated space taken by items.


        public GenericHold(double baseCargoHoldSpace){
            this.baseCargoHoldSpace = baseCargoHoldSpace;




        }

        public ArrayList<Item> getHoldAsArrayList() {
            return genericHold;
        }

        public double getHoldSpace() {
            return baseCargoHoldSpace;
        }

        public void setBaseCargoHoldSpace(double baseCargoHoldSpace) throws ErrorMessages.CargoHoldNotEmptyException {
            if (currentAvailableSpace() != baseCargoHoldSpace || genericHold.size() != 0){//May want to use ampersand for security
                throw new ErrorMessages.CargoHoldNotEmptyException();

            }else {
                this.baseCargoHoldSpace = baseCargoHoldSpace;
            }
        }

        public double currentAvailableSpace(){
            double usedCargoSpace = 0;
            for(Item item : genericHold){
                usedCargoSpace += item.getVolume();
            }
            return usedCargoSpace;
        }

        public void SQLSave(){
            //Todo: Implement save method


        }


        public void generateContentsString(){
            //Converts assets within arraylist to string format. (No need for a billion tables when you can use table name:id eh?)
            for(Item item : genericHold){
                contents += item.getClass().getSimpleName() + ":" + item.getId() + ",";
            }


        }




        public void add(Item item, ArrayList<Item> storedWhere, boolean stack){//Do not stack if false!
            if (storedWhere != null) {//Must specify valid previously stored location.
                if (item.getQuantity() * item.getVolume() < currentAvailableSpace()) {
                    if (stack) {
                        for (Item i : genericHold) {
                            if (i.getClass().equals(item.getClass())) {
                                i.setQuantity(i.getQuantity() + item.getQuantity());
                                storedWhere.remove(item);
                                break;
                            }
                        }
                    } else {//Don't stack, add new item
                        genericHold.add(item);
                        storedWhere.remove(item);
                    }
                }
            }
        }


        public void stack(Item targetItem, Item destinationItem){//Todo: Add exception

            if(genericHold.contains(targetItem) && genericHold.contains(destinationItem)) {


                //Might want to add the currentAvailableSpace method if clause for security. But otherwise, meh...
                if (targetItem.getClass().equals(destinationItem.getClass())) {
                    destinationItem.setQuantity(destinationItem.getQuantity() + targetItem.getQuantity());
                    genericHold.remove(targetItem);
                }
            }
        }


        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }
    }

    public static class CargoHold extends GenericHold{


        public CargoHold(double cargoHoldSpace) {
            super(cargoHoldSpace);
        }
    }




    public static class OreHold extends GenericHold {


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





    public static class ShipHold {//This will be useful for moving assembled ships
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
