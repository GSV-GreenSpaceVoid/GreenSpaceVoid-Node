package com.greenspacevoidnode.common.player;

import com.esotericsoftware.kryonet.Connection;
import com.greenspacevoidnode.GSVServer;
import com.greenspacevoidnode.common.core.entity.vessel.Vessel;
import com.greenspacevoidnode.common.system.StarSystem;
import com.greenspacevoidnode.sql.Saveable;
import com.greenspacevoidsharedAPI.networking.network.messages.gameEntity.NetworkedEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;


@Entity
@Table(name = "Player")
public class Player implements PlayerTells, Saveable {
    @Id @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "emailAddress")
    private String emailAddress;

    @Column(name = "currency")
    private BigDecimal currency;

    private Vessel currentVessel;
    @Column(name = "ship")
    private String currentVesselString;

    private StarSystem currentSystem;
    @Column(name = "currentSystem")
    private long currentSystemID;

    ArrayList<com.greenspacevoidnode.common.core.entity.Entity> renderedEntities = new ArrayList<>();
    ArrayList<NetworkedEntity> networkedEntitiesPair = new ArrayList<>();


    private Connection connection; //Mapped on player login!


    public Player(){

    }


    public void initializePlayer(){
        for(StarSystem s : GSVServer.starSystems){//This figures out which starsystem the player is in as well as the ship they're piloting.
            if(s.getId() == currentSystemID){
                this.setCurrentSystem(s);
                for(com.greenspacevoidnode.common.core.entity.Entity e : s.getEntities()){
                    if(e instanceof Vessel){
                        if(e.getIDString().equals(currentVesselString)){
                            this.setCurrentVessel((Vessel) e);
                            ((Vessel) e).setPilot(this);
                            break;
                        }
                    }
                }
                break;
            }
        }
        if(this.getCurrentVessel() == null){
            System.out.println("PLAYER DOES NOT HAVE A VESSEL CURRENTLY");
            //Todo: Give the player a vessel if they spawn in destroyed
        }
        if(this.getCurrentSystem() == null){
            System.out.println("PLAYER DOESN'T HAVE A CURRENT SYSTEM THEY DWELL IN");
            //Todo: Give the player a new life?
        }







    }

    @Override
    public Long save() {
        this.setCurrentSystemID(currentSystem.getId());
        this.setCurrentVesselString(currentVessel.getIDString());
        return Saveable.super.save();
    }


    public ArrayList<NetworkedEntity> getNetworkedEntitiesPair() {
        return networkedEntitiesPair;
    }

    public ArrayList<com.greenspacevoidnode.common.core.entity.Entity> getRenderedEntities() {
        return renderedEntities;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public BigDecimal getCurrency() {
        return currency;
    }

    public void setCurrency(BigDecimal currency) {
        this.currency = currency;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Vessel getCurrentVessel() {
        return currentVessel;
    }

    public void setCurrentVessel(Vessel currentVessel) {
        this.currentVessel = currentVessel;
    }

    public String getCurrentVesselString() {
        return currentVesselString;
    }

    public void setCurrentVesselString(String currentVesselString) {
        this.currentVesselString = currentVesselString;
    }

    public StarSystem getCurrentSystem() {
        return currentSystem;
    }

    public void setCurrentSystem(StarSystem currentSystem) {
        this.currentSystem = currentSystem;
    }

    public long getCurrentSystemID() {
        return currentSystemID;
    }

    public void setCurrentSystemID(long currentSystemID) {
        this.currentSystemID = currentSystemID;
    }

    public void warn(String str){

    }



}
