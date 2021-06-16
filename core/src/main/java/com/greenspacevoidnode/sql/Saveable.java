package com.greenspacevoidnode.sql;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.OptimisticLockException;

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

            if(e instanceof OptimisticLockException){
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
