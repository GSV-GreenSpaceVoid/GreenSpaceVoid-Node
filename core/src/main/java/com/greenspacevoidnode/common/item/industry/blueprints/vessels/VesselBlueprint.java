package com.greenspacevoidnode.common.item.industry.blueprints.vessels;

import com.greenspacevoidnode.common.entity.Entity;
import com.greenspacevoidnode.common.item.industry.blueprints.Blueprint;

public class VesselBlueprint extends Blueprint {
    private Class<Entity> entityClass;

    public VesselBlueprint(String name, int quantity, Class entityClass) {
        super(name, quantity);
        this.entityClass = entityClass;


    }

    public Entity unPack(){
        //We gon build a ship right here B)







        return null;

    }





}
