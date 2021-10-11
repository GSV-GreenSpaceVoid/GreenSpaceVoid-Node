package com.greenspacevoidnode.sql;

import javax.persistence.*;

@Entity
@Table(name = "storedobject")
public class StoredObject {
    @Id
    int id;

    @Column(name = "var")
    float var;

    @ManyToOne
    PersistenceObject persistenceObject;



    public StoredObject(){
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getVar() {
        return var;
    }

    public void setVar(float var) {
        this.var = var;
    }
}
