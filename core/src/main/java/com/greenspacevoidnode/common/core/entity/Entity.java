package com.greenspacevoidnode.common.core.entity;

import com.greenspacevoidnode.GSVServer;
import com.greenspacevoidnode.common.system.StarSystem;
import com.greenspacevoidnode.common.core.Identifiable;
import com.greenspacevoidnode.sql.Saveable;
import com.greenspacevoidsharedAPI.networking.renderer.EntityIndex;

import javax.persistence.*;
import java.util.ArrayList;


@MappedSuperclass
public class Entity implements Saveable, Identifiable {
    @Id @GeneratedValue
    @Column(name = "id")
    private long id; //Database Key BigInteger
    //Non-Database needed as this value is stored within the Jar
    private int rendererID; //Renderer Specific ID (ex. What texture to tell the client renderer to rend)

    @Column(name = "systemID")
    private long systemID;


    @Column(name = "name")
    private String name; //Some entities may have a custom name so it may be worth jamming in the database.

    @Column(name = "positionX")
    private long x;

    @Column(name = "positionY")
    private long y;

    @Column(name = "direction")
    private int direction;

    @Column(name = "isInvincible")
    private boolean isInvincible;//Think of as being invincible...

    @Column(name = "isTargetable")
    private boolean isTargetable;//Whether it cannot be targeted (ex. navpoints, cloaked vessels)

    @Column(name = "isVisible")
    private boolean isVisible; //Renderer specific. Cloaked ships/navpoints again.

    @Column(name = "canMove")
    private boolean canMove;//General integration to prevent spoof

    private boolean markedForDeletion = false;

    private EntityIndex model;







    //Literally anything!





    //Todo: Update constructor in include rendererID and database values
    public Entity(String name, long systemID, long x, long y, boolean isInvincible, boolean isTargetable, boolean canMove){
        this.name = name;
        this.x = x;
        this.y = y;
        this.direction = 0;
        this.isInvincible = isInvincible;
        this.isTargetable = isTargetable;
        this.canMove = canMove;
    }

    /*
    public StarSystem getStarSystem(){
        //Todo: Find which Arraylist(System) this entity exists in.
        for(StarSystem system:StarSystem.StarSystems){

            for(Entity entity : system.getEntities()){

                if(entity.equals(this)) {
                    return system;
                }
            }
        }
        System.out.println("We may have a memory leak on board...");
        return null; //Yikes if this gets here.

    }
    */







    public void setName(String name) {
        this.name = name;
    }

    public void setX(long x) {
        this.x = x;
    }

    public void setY(long y) {
        this.y = y;
    }

    public void setInvincible(boolean invincible) {
        this.isInvincible = invincible;
    }

    public String getName() {
        return name;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public int getDirection() {
        return direction;
    }

    public boolean isInvincible() {
        return isInvincible;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public int getRendererID() {
        return rendererID;
    }

    public void setRendererID(int rendererID) {
        this.rendererID = rendererID;
    }

    public boolean isTargetable() {
        return isTargetable;
    }

    public void setTargetable(boolean targetable) {
        isTargetable = targetable;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public boolean isCanMove() {
        return canMove;
    }

    public void setCanMove(boolean canMove) {
        this.canMove = canMove;
    }

    public EntityIndex getModel() {
        return model;
    }

    public void setModel(EntityIndex model) {
        this.model = model;
    }

    //Todo: Physics
    public void move(long x, long y){//Called whenever the physics engine says so..or if an admin needs to yeet something into oblivion.
        //Mmmm yes physics
        if(canMove) {
            this.x = x;
            this.y = y;
        }


    }



   public void forceMove(long x, long y){
        boolean previousState = this.canMove;
        this.canMove = true;
        move(x,y);
        this.canMove = previousState;

   }

   public void setDirection(int direction){
        this.direction = direction;
   }


    public long getSystemID() {
        return systemID;
    }

    public void setSystemID(long systemID) {
        this.systemID = systemID;
    }




    @Override
    public Long save() {


        if(!markedForDeletion) {
            return Saveable.super.save();
        }
        return null;
    }


    public void destroy(){//Todo: Implement animation/timer or whathaveyou before utter complete deletion, or produce an object of this entity's wreckage.
        //Animation of destruction!!!



        Saveable.super.delete();
    }

    public StarSystem findCurrentSystem(){


        ArrayList<StarSystem> systems = new ArrayList<>();
        for(StarSystem system : GSVServer.starSystems){
            if(system.getEntities().contains(this)){
                systems.add(system);
            }
        }


        //Todo: Implement prodding method, make it differentiate between an object migrating between systems/hosts and remove duplicates
        if(systems.size() > 1){
            for(StarSystem system : systems){
                if(system.getId() != this.getSystemID()) {
                    system.getEntities().remove(this);
                }
            }
        }

        return systems.get(0);

    }


    @Override
    public void close() {
        this.save();
        this.setMarkedForDeletion(true);
        this.remove();



        Saveable.super.close();
    }


    public void remove(){
        for (StarSystem system : GSVServer.starSystems){
            if(systemID == system.getId()){
                system.getEntities().removeIf(i -> (system.getEntities().contains(this)));
                return;
            }
        }
    }


    public boolean isMarkedForDeletion() {
        return markedForDeletion;
    }

    public void setMarkedForDeletion(boolean markedForDeletion) {
        this.markedForDeletion = markedForDeletion;
    }


    @Override
    public void delete(){
        markedForDeletion = true;




        Saveable.super.delete();


        //Destroys this object from the database
        //this = null;



    }


    public void hardDelete(){
        for(StarSystem system : GSVServer.starSystems) {
            system.getEntities().remove(this);
        }
        delete();
    }




}
