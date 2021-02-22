package com.greenspacevoid.server.shared.network.messages;




public abstract class SharedMessage {

    /**
     * This value is used for debugging purposes only at the moment.
     * It is instantiated in the {@code SharedMessage} constructor.
     */
    //String timeSent;

    /**
     * This value is used for debugging purposed only at the moment.
     * It is instantiated in the {@code received()} method.
     *
     * @implNote the {@code received()} method must be called when
     * the message is parsed by an {@link EndPoint}
     */
    //String timeReceived;

    /**
     * Instantiates a new {@code SharedMessage} object and sets the
     * {@code timeSent} variable.
     */
    public SharedMessage(){

        //timeSent = Instant.now().toString();
    }

    /**
     * Called when a {@code SharedMessage} is received and parsed by
     * an {@link EndPoint}
     */
    public void received(){

        //timeReceived = Instant.now().toString();
    }
}





