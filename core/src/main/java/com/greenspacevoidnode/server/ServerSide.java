package com.greenspacevoidnode.server;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.greenspacevoidnode.GSVServer;
import com.greenspacevoidnode.common.player.Player;
import com.greenspacevoidnode.sql.SQL;
import com.greenspacevoidnode.sql.Saveable;
import com.greenspacevoidsharedAPI.networking.network.messages.login.NetworkedLogin;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ServerSide {




    public static void startServer() throws IOException {

        Server server = new Server();
        //Networking.syncRegisters(server.getKryo());
        server.bind(30000);
        server.start();
        //Add listeners here


        server.addListener(new Listener(){
           @Override
           public void disconnected(Connection connection) {
               for(Player player : GSVServer.connectedPlayers){
                   if(player.getConnection() == connection){
                       player.save();
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
        List players = null;
        Player player;
        Session session = SQL.HibernateManager.factory.openSession();
        Transaction tx = session.beginTransaction();
        try{


            players = session.createSQLQuery("SELECT * FROM player WHERE PASSWORD = " + Arrays.toString(message.password) + " AND username = " + message.username).list();
            if(players.get(0) instanceof Player && players.size() == 1 && !GSVServer.connectedPlayers.contains((Player) players.get(0))) { //Make sure it doesnt contain a player thats already connected.
                player = session.get(Player.class, ((Player) players.get(0)).getId());
                GSVServer.connectedPlayers.add(player);
            }
            tx.commit();

            try {

                if(players.size() == 1){
                    NetworkedLogin.CLIENT.CLIENT_RECEIVE_LoginStatusMessage sendableMessage = new NetworkedLogin.CLIENT.CLIENT_RECEIVE_LoginStatusMessage();
                    sendableMessage.loginAccepted = true;

                    connection.sendTCP(sendableMessage);

                }else{
                    NetworkedLogin.CLIENT.CLIENT_RECEIVE_LoginStatusMessage sendableMessage = new NetworkedLogin.CLIENT.CLIENT_RECEIVE_LoginStatusMessage();
                    sendableMessage.loginAccepted = false;
                    connection.sendTCP(sendableMessage);
                    connection.close();
                }
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("Something bad has happened in the LoginManager class");
            }
        }catch(Exception e){
            tx.rollback();
        }finally{
            session.close();
        }




    }







}
