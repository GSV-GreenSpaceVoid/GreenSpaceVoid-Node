package com.greenspacevoidnode;

import com.greenspacevoidnode.common.core.item.industry.materials.Material;
import com.greenspacevoidnode.common.player.Player;
import com.greenspacevoidnode.server.ServerSide;
import com.greenspacevoidnode.sql.SQL;
import org.hibernate.SessionFactory;

import java.util.ArrayList;

public class GSVServer {

    public static SessionFactory HibernateFactory;
    public static ArrayList<Player> connectedPlayers = new ArrayList<>();


    public static void main(String[] args) {


        ArrayList<StarSystem> starSystems = new ArrayList<StarSystem>();










        //SQL.HibernateManager.main(null);
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



        //test = r.refine();7


        System.out.println("com.greenspacevoidsharedAPI.Test");


        try {
            ServerSide.startServer();
        }catch(Exception e){
            e.printStackTrace();
        }

        //Material.SolidMaterials.Aluminum test = new Material.SolidMaterials.Aluminum(1);



    }














}
