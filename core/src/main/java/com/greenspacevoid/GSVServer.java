package com.greenspacevoid;

import com.greenspacevoid.common.item.industry.materials.Material;
import com.greenspacevoid.common.item.industry.resources.Resource;
import com.greenspacevoid.server.ServerSide;
import com.greenspacevoid.system.StarSystem;

public class GSVServer {


    public static void main(String[] args) {
        /*
        Todo: SQL. SQL should be top priority for whenever the server starts. SQL will contain all player information, data,
        Todo: ship data, world data, and the works.


        SQL Heirarchy as follows:
        Two datasets

        Player - > playerinfo
        Playerinfo must be treasured. No Database corruption here.

        An "entity" can be defined as any object that manifests itself in the world physically.
        World - > Star sectors - > Entities - > Entity data (Modules, cargoholds, dockedplayers etc.)



         */




        System.out.println("Test");


        try {
            ServerSide.startServer();
        }catch(Exception e){
            e.printStackTrace();
        }

        Material.SolidMaterials.Aluminum test = new Material.SolidMaterials.Aluminum(1);




    }














}
