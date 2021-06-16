package com.greenspacevoidnode.engine;

import com.greenspacevoidnode.common.core.entity.Entity;
import com.greenspacevoidnode.sql.SQL;
import com.greenspacevoidnode.sql.Saveable;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.*;


import java.util.ArrayList;
import java.util.List;

@javax.persistence.Entity
@Table(name = "systemInfo")
public class StarSystem implements Saveable {//It's actually a database B)
    //public static ArrayList<StarSystem> StarSystems = new ArrayList<>();

    public static StarSystem starSystem;




    @Id@GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "isLoaded")
    private boolean isLoaded;

    @Column(name = "name")
    String name;
    @Column(name = "securityLevel")
    private double securityLevel;

    @Column(name = "galacticX")
    private long galacticX;

    @Column(name = "galacticY")
    private long galacticY;

    ArrayList<Entity> entities; //List by which we store all pointers to our entities.
    //Galactic coordinates


    //Todo: Starcharts B)

    public StarSystem(String name, double securityLevel){
        this.name = name;
        this.securityLevel = securityLevel;
        entities = new ArrayList<>();
    }

    public StarSystem(){
        entities = new ArrayList<>();


    }






    public void start(){




    }




    public void load(){

        Session session = SQL.HibernateManager.factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            List entities = session.createQuery("").list();








        }catch(Exception e){
            if(tx != null){
                tx.rollback();
            }


        }finally{
            session.close();
        }





    }



























    @Override
    public long getId() {
        return id;
    }
    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(double securityLevel) {
        this.securityLevel = securityLevel;
    }

    public long getGalacticX() {
        return galacticX;
    }

    public void setGalacticX(long galacticX) {
        this.galacticX = galacticX;
    }

    public long getGalacticY() {
        return galacticY;
    }

    public void setGalacticY(long galacticY) {
        this.galacticY = galacticY;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }
}
