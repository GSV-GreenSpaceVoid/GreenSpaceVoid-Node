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


        }



        return this.getId();





    }





    long getId();
    void setId(long id);















}
