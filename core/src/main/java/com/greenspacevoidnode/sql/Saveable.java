package com.greenspacevoidnode.sql;

import com.greenspacevoidnode.common.core.entity.Entity;
import com.greenspacevoidnode.common.core.item.Item;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.OptimisticLockException;
import java.util.ArrayList;
import java.util.List;

public interface Saveable {

    default Long save(){
        Session session = SQL.HibernateManager.factory.openSession();
        Transaction transaction = null;
        Long i = null;



        try{//If this fails to update, save it.
            transaction = session.beginTransaction();
            session.update(this);
            transaction.commit();
            return this.getId();



        }catch(Exception e){
            e.printStackTrace();
            if(transaction!= null){
                transaction.rollback();
            }
            session.close();

            if(e instanceof OptimisticLockException){//If this object otherwise doesn't exist, save and remember the instance of it.
                session = SQL.HibernateManager.factory.openSession();
                transaction = null;
                i = null;


                try{
                    transaction = session.beginTransaction();
                    i = (Long) session.save(this);
                    transaction.commit();
                    this.setId(i);




                }catch(Exception e1){
                    if(transaction!= null){
                        transaction.rollback();
                    }
                    if(i == null){
                        return this.getId();
                    }
                }finally{
                    session.close();
                }
                return i;
            }
        }finally{
            session.close();
        }
        return this.getId();
    }

    default String generateStringFromItemList(List<Item> items){

        return "";
    }





    default ArrayList<Item> loadItemsFromString(String s){
        /**
         * @param string
         *This method pulls objects from the database of TABLE_NAME:PRIMARY_KEY followed by a comma.
         * Ex. crystal:id,module:id,cargo:id,
         */



        String name;
        String id;

        ArrayList<Item> items = new ArrayList<>();

        String temp;
        while(s.contains(",")) {//Decodes name:id into seperate strings!

            temp = s.substring(0, s.indexOf(","));
            name = temp.substring(0, temp.indexOf(":"));
            id = temp.substring(s.indexOf(":") + 1);
            s = s.substring(temp.length() + 1);


            Session session = SQL.HibernateManager.factory.openSession(); //Lotta queries eh?
            Transaction tx = null;
            try{
                tx = session.beginTransaction();
                List results = session.createQuery("from " + name + " where id = "+ id).list(); //Todo: Replace with systemID
                //System.out.println(results);
                items.addAll(results);
                tx.commit();
            }catch(Exception e){
                if(tx != null){
                    tx.rollback();
                }
            }finally{
                session.close();
            }
        }
        return items;
    }





    default void load(){






    }


    default void delete(){
        Session session = SQL.HibernateManager.factory.openSession();
        Transaction transaction = null;
        Long i = null;

        try {//If this fails to update, save it.
            transaction = session.beginTransaction();
            session.remove(this);
            transaction.commit();

        }catch(Exception e){
            if(transaction!= null){
                transaction.rollback();
            }
            System.out.println("Something persisted that otherwise wasn't deleted...");
            e.printStackTrace();

        }finally{
            session.close();
        }
    }






    long getId();
    void setId(long id);















}
