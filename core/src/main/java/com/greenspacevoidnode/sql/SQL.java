package com.greenspacevoidnode.sql;

import com.greenspacevoidsharedAPI.Test;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

public class SQL {




    public static class HibernateManager {
        public static SessionFactory factory;

        public static void main(String[] args) {
            try{
                factory = new Configuration().configure().buildSessionFactory();
            }catch(Exception e){
                e.printStackTrace();

            }


            HibernateManager manager = new HibernateManager();
            /*
            Integer testClassID1 = manager.addTestClass(1234,1234,1234,"Test #1", 1234);
            manager.addTestClass(1234,1234,1234,"Test #1", 1234);
            manager.addTestClass(1234,1234,1234,"Test #1", 1234);
             manager.addTestClass(1234,1234,1234,"Test #1", 1234);
            manager.addTestClass(1234,1234,1234,"Test #1", 1234);
            System.out.println(testClassID1);
            */

            manager.updateClasses();

            //manager.listClasses();



        }



        public Integer addTestClass (int hullHP, int armorHP, int shieldHP, String name, int powerlevel){
            Session session = factory.openSession();
            Transaction tx = null;
            Integer testClassID = null;


            try{
                tx = session.beginTransaction();
                //TestClass testClass = new TestClass(name, hullHP, armorHP, shieldHP, powerlevel);
                OtherGrandChildClass c = new OtherGrandChildClass(name, hullHP, armorHP, shieldHP, powerlevel);

                testClassID = (Integer) session.save(c);
                tx.commit();






            }catch(Exception e){
                e.printStackTrace();
                if(tx!= null){
                    tx.rollback();
                }

            }finally{
                session.close();
            }
            return testClassID;





        }

        public void listClasses( ){
            Session session = factory.openSession();
            Transaction tx = null;



            try {
                tx = session.beginTransaction();
                List employees = session.createQuery("FROM TestClass").list();
                for (Iterator iterator = employees.iterator(); iterator.hasNext();){
                    TestClass testClass = (TestClass) iterator.next();
                    System.out.println("Name: " + testClass.getName());
                    System.out.println("  HullHP: " + testClass.getHullHP());
                    System.out.println("  ShieldHP: " + testClass.getShieldHP());
                }
                tx.commit();
            } catch (HibernateException e) {
                if (tx!=null) tx.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }
        }

        public void updateClasses(){
            Session session = factory.openSession();
            Transaction tx = null;

            try{
                tx = session.beginTransaction();
                List employees = session.createQuery("FROM OtherGrandChildClass").list();
                for (Iterator iterator = employees.iterator(); iterator.hasNext();){
                    OtherGrandChildClass testClass = (OtherGrandChildClass) iterator.next();

                    testClass.setPowerlevel(999999);
                    session.save(testClass);



                }
                tx.commit();



            }catch(Exception e) {
                if (tx != null) tx.rollback();
                e.printStackTrace();
            }finally{
                session.close();
            }


        }



    }















































}
