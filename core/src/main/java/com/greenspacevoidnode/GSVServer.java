package com.greenspacevoidnode;

import com.greenspacevoidnode.common.item.industry.materials.Material;
import com.greenspacevoidnode.common.item.industry.resources.Resource;
import com.greenspacevoidnode.server.ServerSide;
import com.greenspacevoidsharedAPI.Test;

import java.util.ArrayList;

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

        ArrayList<Material> test = new ArrayList<>();

        Resource r = new Resource.ORE.SOLID_ORE.IronOres.Magnetite(10);

        test = r.refine();

        for(int i  = 0; i < test.size(); i++){

            System.out.println(test.get(i).getName());
            System.out.println(test.get(i).getQuantity());

        }





        System.out.println("com.greenspacevoidsharedAPI.Test");


        try {
            ServerSide.startServer();
        }catch(Exception e){
            e.printStackTrace();
        }

        //Material.SolidMaterials.Aluminum test = new Material.SolidMaterials.Aluminum(1);



    }














}
