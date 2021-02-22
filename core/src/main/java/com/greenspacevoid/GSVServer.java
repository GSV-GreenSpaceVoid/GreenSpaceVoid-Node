package com.greenspacevoid;

import com.greenspacevoid.server.ServerSide;

public class GSVServer {


    public static void main(String[] args) {
        System.out.println("Test");


        try {
            ServerSide.startServer();
        }catch(Exception e){
            e.printStackTrace();
        }
    }














}
