package com.greenspacevoidnode.common.core.entity.world.resources;

import com.greenspacevoidnode.common.core.entity.world.WorldEntity;
import com.greenspacevoidnode.common.core.item.industry.materials.Ore;

public class ResourceNode extends WorldEntity {

    private static final boolean isInvincible = true;
    private static final boolean isTargetable = true;
    private static final boolean canMove = true;

    Ore ore; //Refine the ores system




    public ResourceNode(String name, long systemID,long x, long y) {
        super(name, systemID, x, y, isInvincible, isTargetable, canMove);


        //Create generator code


    }











    public enum Resources{
        //Asteroid
        TITANIUM,
        STEEL,
        DILITHIUM,
    }

    public Ore getOre() {
        return ore;
    }

    public Ore mine(int quantity){

        if(this.ore.getQuantity() - quantity > 0){
            ore.setQuantity(this.ore.getQuantity() - quantity);
        }else {
            this.delete();
        }
        return this.ore;

    }




}
