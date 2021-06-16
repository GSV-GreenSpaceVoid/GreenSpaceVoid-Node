package com.greenspacevoidnode.common.core.entity.world.resources;

import com.greenspacevoidnode.common.core.entity.world.WorldEntity;
import com.greenspacevoidnode.common.core.item.industry.materials.Ore;

public class ResourceNode extends WorldEntity {

    private static final String name = "Asteroid";
    private static final boolean isInvincible = true;
    private static final boolean isTargetable = true;
    private static final boolean canMove = true;

    Ore ore; //Refine the ores system




    public ResourceNode(String name, long x, long y) {
        super(name + "" + ResourceNode.name, x, y, isInvincible, isTargetable, canMove);



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
}
