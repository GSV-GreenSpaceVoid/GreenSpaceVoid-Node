package com.greenspacevoid.server.shared.network.messages.login;

import com.greenspacevoid.server.shared.network.messages.SharedMessage;

public class NetworkedLogin {
    //Stub class...Might be good for something.





    public static class CLIENT_SEND{

        public static class LoginMessage extends SharedMessage {

            public String username;
            public byte[] password;

            public LoginMessage(){


                super();

            }
        }


        public static class CLIENT_RECEIVE_LoginStatusMessage extends SharedMessage{
            //When this message is received, or isn't. Log the player in and get things going B)

            boolean loginAccepted;
            String lastLoggedIn;



            public CLIENT_RECEIVE_LoginStatusMessage(){
                super();

            }
        }









    }





}
