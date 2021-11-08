package com.greenspacevoidnode.common.core.entity.vessel.ship;

import com.greenspacevoidnode.common.core.entity.Entity;
import com.greenspacevoidnode.common.core.entity.vessel.Vessel;
import com.greenspacevoidnode.common.player.Player;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Ship extends Vessel {




    private Class blueprintClass;

    public Ship(){
        super("Pending", 0,0,0,0,true,false, false, 0);

    }

    public Ship(String name, long systemID, long x, long y, double volume, boolean isInvincible, boolean isTargetable, boolean canMove, double baseCargoCapacity) {
        super(name, systemID, x, y, volume, isInvincible, isTargetable, canMove, baseCargoCapacity);
    }

    boolean warping;
    float baseWarpSpeed, currentWarpSpeed, maxWarpSpeed;
    double baseAlignTime, currentAlignTime; //Todo: Implement acceleration curves


    public void warpTo(Entity target){
        setDestination(target);
        setMoving(true);
        setWarping(true);






    }

    @Override
    public void move() {
        if(isWarping()){
            //Todo: Acceleration stuff






        }
        super.move();
    }

    public Class getBlueprintClass() {
        return blueprintClass;
    }

    public void setBlueprintClass(Class blueprintClass) {
        this.blueprintClass = blueprintClass;
    }

    public boolean isWarping() {
        return warping;
    }

    public void setWarping(boolean warping) {
        this.warping = warping;
    }

    public float getBaseWarpSpeed() {
        return baseWarpSpeed;
    }

    public void setBaseWarpSpeed(float baseWarpSpeed) {
        this.baseWarpSpeed = baseWarpSpeed;
    }

    public float getCurrentWarpSpeed() {
        return currentWarpSpeed;
    }

    public void setCurrentWarpSpeed(float currentWarpSpeed) {
        this.currentWarpSpeed = currentWarpSpeed;
    }

    public float getMaxWarpSpeed() {
        return maxWarpSpeed;
    }

    public void setMaxWarpSpeed(float maxWarpSpeed) {
        this.maxWarpSpeed = maxWarpSpeed;
    }

    public double getBaseAlignTime() {
        return baseAlignTime;
    }

    public void setBaseAlignTime(double baseAlignTime) {
        this.baseAlignTime = baseAlignTime;
    }

    public double getCurrentAlignTime() {
        return currentAlignTime;
    }

    public void setCurrentAlignTime(double currentAlignTime) {
        this.currentAlignTime = currentAlignTime;
    }
}
