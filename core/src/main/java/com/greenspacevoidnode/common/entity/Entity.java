package com.greenspacevoidnode.common.entity;

import com.greenspacevoidnode.common.system.StarSystem;
import com.greenspacevoidnode.sql.SQL;
import org.hibernate.*;
import org.hibernate.SessionFactory;

import javax.persistence.*;


@MappedSuperclass
public class Entity {
    @Id @GeneratedValue
    @Column(name = "id")
    private long id; //Database Key BigInteger

    //Non-Database needed as this value is stored within the Jar
    private int rendererID; //Renderer Specific ID (ex. What texture to tell the client renderer to rend)

    @Column(name = "name")
    private String name; //Some entities may have a custom name so it may be worth jamming in the database.

    @Column(name = "positionX")
    private double x;

    @Column(name = "positionY")
    private double y;

    @Column(name = "direction")
    private double direction;

    @Column(name = "isInvincible")
    private boolean isInvincible;//Think of as being invincible...

    @Column(name = "isTargetable")
    private boolean isTargetable;//Whether it cannot be targeted (ex. navpoints, cloaked vessels)

    @Column(name = "isVisible")
    private boolean isVisible; //Renderer specific. Cloaked ships/navpoints again.

    @Column(name = "canMove")
    private boolean canMove;//General integration to prevent spoof











    //Literally anything!





    //Todo: Update constructor in include rendererID and database values
    public Entity(String name, double x, double y,  boolean isInvincible, boolean isTargetable, boolean canMove){
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

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setInvincible(boolean invincible) {
        this.isInvincible = invincible;
    }

    public String getName() {
        return name;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getDirection() {
        return direction;
    }

    public boolean isInvincible() {
        return isInvincible;
    }


    public long getId() {
        return id;
    }

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

    //Todo: Physics
    public void move(double x, double y){//Called whenever the physics engine says so..or if an admin needs to yeet something into oblivion.
        //Mmmm yes physics
        if(canMove) {
            this.x = x;
            this.y = y;
        }


    }



   public void forceMove(double x, double y){
        boolean previousState = this.canMove;
        this.canMove = true;
        move(x,y);
        this.canMove = previousState;

   }

   public void setDirection(double direction){
        this.direction = direction;
   }



   public void updateS(){






   }


   public void saveToDatabase(){
        //Todo: Implement Hibernate Save!!!!!
        Session factory = SQL.HibernateManager.factory.openSession();









   }




    public void destroy(){
        //Destroys this object from the database
        //this = null;




    }






}
