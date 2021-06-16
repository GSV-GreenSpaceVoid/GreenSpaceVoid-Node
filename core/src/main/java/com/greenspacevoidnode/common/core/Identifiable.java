package com.greenspacevoidnode.common.core;

public interface Identifiable {

    default int getSpecificID(){//Returns an ID that both the client and server see as equivalent. I.e, beam array on server displays beam array on client when viewed in inventory
        System.out.println(this.getClass().getSimpleName() + " ITEM DOES NOT HAVE A MAPPED ID BETWEEN CLIENT AND SERVER!");

        return -1;
    }











}
