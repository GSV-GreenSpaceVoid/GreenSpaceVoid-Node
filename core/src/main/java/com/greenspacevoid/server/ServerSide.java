package com.greenspacevoid.server;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.greenspacevoid.server.shared.network.Networking;
import com.greenspacevoid.server.shared.network.messages.login.NetworkedLogin;

import java.io.IOException;
import java.util.Arrays;

public class ServerSide {




    public static void startServer() throws IOException {

        Server server = new Server();
        Networking.syncRegisters(server.getKryo());
        server.bind(30000);
        server.start();
        //Add listeners here



        server.addListener(new Listener(){
            public void received(Connection c, Object object){

                //Todo: Implement SQL compare
                if(object instanceof NetworkedLogin.CLIENT_SEND.LoginMessage){
                    System.out.println(((NetworkedLogin.CLIENT_SEND.LoginMessage) object).username);
                    System.out.println(Arrays.toString(((NetworkedLogin.CLIENT_SEND.LoginMessage) object).password));
                    System.out.println("Yuh!");
                }






            }




        });


    }













}
