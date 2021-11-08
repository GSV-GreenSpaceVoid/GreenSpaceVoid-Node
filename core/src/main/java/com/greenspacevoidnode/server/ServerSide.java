package com.greenspacevoidnode.server;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.greenspacevoidnode.GSVServer;
import com.greenspacevoidnode.common.player.Player;
import com.greenspacevoidnode.sql.SQL;
import com.greenspacevoidnode.sql.Saveable;
import com.greenspacevoidsharedAPI.networking.network.Networking;
import com.greenspacevoidsharedAPI.networking.network.messages.login.NetworkedLogin;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.loader.custom.sql.SQLCustomQuery;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.List;

public class ServerSide {




    public static void startServer() throws IOException {

        Server server = new Server();
        Networking.syncRegisters(server.getKryo());
        server.bind(30000);
        server.start();
        //Add listeners here


        server.addListener(new Listener(){
           @Override
           public void disconnected(Connection connection) {
               for(Player player : GSVServer.connectedPlayers){
                   if(player.getConnection() == connection){
                       player.save();
                       System.out.println("Player " + player.getUsername() + " disconnected!");
                       GSVServer.connectedPlayers.remove(player);
                   }
               }
               super.disconnected(connection);
           }
        });

        server.addListener(new Listener(){
            public void received(Connection c, Object object){

                //Todo: Implement SQL compare
                if(object instanceof NetworkedLogin.CLIENT.CLIENT_SEND_LoginMessage){
                    /*
                    System.out.println(((NetworkedLogin.CLIENT_SEND.LoginMessage) object).username);
                    System.out.println(Arrays.toString(((NetworkedLogin.CLIENT_SEND.LoginMessage) object).password));
                    System.out.println("Yuh!");
                    */
                    login_user((NetworkedLogin.CLIENT.CLIENT_SEND_LoginMessage) object, c);



                }






            }




        });


    }





    public static void login_user(NetworkedLogin.CLIENT.CLIENT_SEND_LoginMessage message, Connection connection){

        Player player;
        Session session = SQL.HibernateManager.factory.openSession();
        Transaction tx = session.beginTransaction();
        NetworkedLogin.CLIENT.CLIENT_RECEIVE_LoginStatusMessage sendableMessage = new NetworkedLogin.CLIENT.CLIENT_RECEIVE_LoginStatusMessage();
        try{

            System.out.println(message.username);
            System.out.println(new String(message.password));

            String hqlQueryString = "FROM Player p WHERE p.username = :username AND p.password = :password";
            Query query = session.createQuery(hqlQueryString);
            query.setParameter("username", message.username);
            query.setParameter("password", new String (message.password));
            Player p = (Player) query.uniqueResult();
            if (p != null) {
                if (!GSVServer.connectedPlayers.contains(p)) { //Make sure it doesnt contain a player thats already connected.
                    player = session.get(Player.class, p.getId());
                    GSVServer.connectedPlayers.add(player);
                    System.out.println("Player " + player.getUsername() + " connected!");

                } else {
                    sendableMessage.loginAccepted = false;
                    connection.sendTCP(sendableMessage);
                }
                tx.commit();

            }else{
                sendableMessage.loginAccepted = false;
            }
            connection.sendTCP(sendableMessage);
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally{
            session.close();
        }

    }

}
