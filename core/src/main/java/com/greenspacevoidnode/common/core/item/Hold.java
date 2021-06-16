package com.greenspacevoidnode.common.core.item;

import com.greenspacevoidnode.common.core.item.industry.resources.Resource;
import com.greenspacevoidnode.common.core.item.industry.materials.Ore;
import com.greenspacevoidnode.engine.exceptions.ErrorMessages;
import com.greenspacevoidnode.sql.Saveable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.ArrayList;

@MappedSuperclass
public class Hold implements Saveable { //Stores items
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "contents")
    private String contents;


    private ArrayList<Item> items = new ArrayList<>();
    private double baseCargoHoldSpace;
    private double currentCargoHoldSpace; //Modified basevalue, not accumulated space taken by items.


    public Hold(double baseCargoHoldSpace) {
        this.baseCargoHoldSpace = baseCargoHoldSpace;


    }


    @Override
    public Long save() {

        for(Item item : items ){
            item.update();
        }

        this.generateContentsString();//Convert our stored mapped objects into a string (Format: TABLENAME/CLASSNAME:ID,)
        return Saveable.super.save();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public double getHoldSpace() {
        return baseCargoHoldSpace;
    }

    public void setBaseCargoHoldSpace(double baseCargoHoldSpace) throws ErrorMessages.CargoHoldNotEmptyException {
        if (currentAvailableSpace() != baseCargoHoldSpace || items.size() != 0) {//May want to use ampersand for security
            throw new ErrorMessages.CargoHoldNotEmptyException();

        } else {
            this.baseCargoHoldSpace = baseCargoHoldSpace;
        }
    }






    public void refineMaterial(Resource resource){



        items.addAll(resource.refine());
        items.remove(resource);
        this.save();
    }

    public void refineMaterial(ArrayList<Resource> resources){
        //Creates new materials from resources, deletes references from resources, and saves this cargohold to the database.

        //Todo: Implement stack to keep things tidy!

        for(Resource resource : resources) {
            items.addAll(resource.refine());
            items.remove(resource);
            this.save();
        }
    }





    public double currentAvailableSpace() {
        double usedCargoSpace = 0;
        for (Item item : items) {
            usedCargoSpace += item.getVolume();
        }
        return usedCargoSpace;
    }


    public void generateContentsString() {
        //Converts assets within arraylist to string format. (No need for a billion tables when you can use table name:id eh?)
        contents = "";
        for (Item item : items) {
            contents += item.getClass().getSimpleName() + ":" + item.getId() + ",";
        }


    }


    public void add(Item item, ArrayList<Item> storedWhere, boolean stack) {//Do not stack if false!
        if (storedWhere != null) {//Must specify valid previously stored location.
            if (item.getQuantity() * item.getVolume() < currentAvailableSpace()) {
                if (stack) {
                    for (Item i : items) {
                        if (i.getClass().equals(item.getClass())) {
                            i.setQuantity(i.getQuantity() + item.getQuantity());
                            storedWhere.remove(item);
                            break;
                        }
                    }
                } else {//Don't stack, add new item
                    items.add(item);
                    storedWhere.remove(item);
                }
            }
        }
    }


    public void stack(Item targetItem, Item destinationItem) {//Todo: Add exception

        if (items.contains(targetItem) && items.contains(destinationItem)) {


            //Might want to add the currentAvailableSpace method if clause for security. But otherwise, meh...
            if (targetItem.getClass().equals(destinationItem.getClass())) {
                destinationItem.setQuantity(destinationItem.getQuantity() + targetItem.getQuantity());
                items.remove(targetItem);
            }
        }
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public static class CargoHold extends Hold {


        public CargoHold(double cargoHoldSpace) {
            super(cargoHoldSpace);
        }
    }



























    public static class OreHold extends Hold {


        public OreHold(double cargoHoldSpace) {
            super(cargoHoldSpace);
        }


        @Override
        public void add(Item item, ArrayList<Item> storedWhere, boolean stack) {
            if(item instanceof Ore){
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
