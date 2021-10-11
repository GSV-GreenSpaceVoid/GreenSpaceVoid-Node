package com.greenspacevoidnode;

import com.greenspacevoidnode.common.core.entity.Entity;
import com.greenspacevoidnode.sql.SQL;
import com.greenspacevoidnode.sql.Saveable;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.*;


import java.util.ArrayList;
import java.util.List;

@javax.persistence.Entity
@Table(name = "systemInfo")
public class StarSystem implements Saveable {//It's not actually a database B)
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

    private ArrayList<Entity> entities; //List by which we store all pointers to our entities.
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





    public void loadAll(){

        Session session = SQL.HibernateManager.factory.openSession();
        Transaction tx = null;
        ArrayList<String> tables = new ArrayList<>();

        try{
            tx = session.beginTransaction();
            List tableStrings = session.createSQLQuery("select TABLE_NAME from INFORMATION_SCHEMA.COLUMNS where COLUMN_NAME like 'armorHP' ").list(); //Todo: Replace with systemID


            java.lang.System.out.println(tableStrings);
            tables.addAll(tableStrings);

            tx.commit();
            /*
            for (Iterator iterator = tableStrings.iterator(); iterator.hasNext();){
                System.out.println((String) iterator.next());
            }
            */
        }catch(Exception e){
            if(tx != null){
                tx.rollback();
            }


        }finally{
            session.close();
        }

        for(String tableName : tables){
            loadEntityTable(tableName);
        }

        for(Entity entity : entities){
            entity.updateS();




        }



    }




    private ArrayList<Entity> loadEntityTable(String name){//Loads all entities from specified table that are in THIS star system!
        Session session = SQL.HibernateManager.factory.openSession();
        Transaction tx = null;
        ArrayList<Entity> entities = new ArrayList<>();
        try{
            tx = session.beginTransaction();
            List results = session.createQuery("from " + name + " where systemID = "+ this.getId()).list(); //Todo: Replace with systemID
            java.lang.System.out.println(results);
            entities.addAll(results);
            tx.commit();
        }catch(Exception e){
            if(tx != null){
                tx.rollback();
            }
        }finally{
            session.close();
        }
        return entities;
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
