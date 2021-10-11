package com.greenspacevoidnode.sql;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Entity
@Table(name = "persistenceobject")
public class PersistenceObject {

    @Id
    int id;


    @Column(name = "var")
    float var;


    @Column(name = "hold")
    @JoinTable
    @OneToMany()
    List<StoredObject> storedObjects = new ArrayList<>();


    public PersistenceObject(){




    }

    public float getVar() {
        return var;
    }

    public void setVar(float var) {
        this.var = var;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public List<StoredObject> getStoredObjects() {
        return storedObjects;
    }

    public static class Main {
        public static void main(String[] args) {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();
            Session session = factory.openSession();
            Transaction tx = null;
            Integer testClassID = null;


            try{

                //GENERATION CODE
                tx = session.beginTransaction();

                PersistenceObject p = new PersistenceObject();
                StoredObject s = new StoredObject();
                s.setVar(1234);
                s.setId((int) session.save(s));
                p.getStoredObjects().add(s);



                p.setId((int) session.save(p));


                tx.commit();


                //TestClass testClass = new TestClass(name, hullHP, armorHP, shieldHP, powerlevel);
                /*
                OtherGrandChildClass c = new OtherGrandChildClass("asparagus", 5678, 5678, 5678,5678);
                c.setId(9);



                session.update(c);
                tx.commit();

                c.getId();
                */

                //PersistenceObject p = new PersistenceObject();
                //p.setVar(1234f);
                //p.setId(2);


                /*


                tx = session.beginTransaction();

                PersistenceObject p = null;
                List employees = session.createQuery("FROM PersistenceObject").list();
                for (Iterator iterator = employees.iterator(); iterator.hasNext();){
                    PersistenceObject testClass = (PersistenceObject) iterator.next();
                    if(testClass.getId() == 2){
                        p = testClass;
                    }
                }

                p.setVar(1234566788);
                tx.commit();


                Thread.sleep(5000);

                tx = session.beginTransaction();
                session.persist(p);
                tx.commit();


                assert p != null;
                p.setVar(234343434);



                //p.setVar(2345);
                */


            }catch(Exception e){
                e.printStackTrace();
                if(tx!= null){
                    tx.rollback();
                }

            }finally{
                session.close();
            }







        }






    }
}
