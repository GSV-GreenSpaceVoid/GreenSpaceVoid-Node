package com.greenspacevoidnode.sql;

import com.greenspacevoidsharedAPI.Test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SQL {




    public static class HibernateManager {
        private static SessionFactory factory;

        public static void main(String[] args) {
            try{
                factory = new Configuration().configure().buildSessionFactory();
            }catch(Exception e){
                e.printStackTrace();

            }


            HibernateManager manager = new HibernateManager();

            Integer testClassID1 = manager.addTestClass(1234,1234,1234,"Test #1");
            System.out.println(testClassID1);




        }



        public Integer addTestClass (int hullHP, int armorHP, int shieldHP, String name){
            Session session = factory.openSession();
            Transaction tx = null;
            Integer testClassID = null;


            try{
                tx = session.beginTransaction();
                TestClass testClass = new TestClass(name, hullHP, armorHP, shieldHP);
                testClassID = (Integer) session.save(testClass);
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







    }















































}
