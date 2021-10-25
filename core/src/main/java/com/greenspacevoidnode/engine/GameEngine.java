package com.greenspacevoidnode.engine;

import com.greenspacevoidnode.GSVServer;
import com.greenspacevoidnode.common.core.entity.Entity;
import com.greenspacevoidnode.common.core.entity.vessel.Vessel;
import com.greenspacevoidnode.common.player.Player;
import com.greenspacevoidnode.common.system.StarSystem;
import com.greenspacevoidsharedAPI.networking.network.messages.gameEntity.NetworkedEntity;

import java.awt.geom.Point2D;


public class GameEngine {


    public static final long PLAYER_RENDER_DISTANCE = 100000;











    public GameEngine(){










    }
    public void run(){
        System.out.println("Game loop started....");
        long initialTime = System.nanoTime();

        final double TimePerFrame = 1000000000f / 2f;
        double deltaF = 0;
        int frames = 0, ticks = 0;
        long timer = System.currentTimeMillis();

        while (true) {
            try {
                long curTime = System.nanoTime();
                deltaF += (curTime - initialTime) / TimePerFrame;
                initialTime = curTime;

                if (deltaF >= 1) {
                    updateMovement();
                    updatePlayerCulling();
                    //ShipPhysics.updateMovement();
                    //GameState.updateClients();
                    ticks++;
                    frames++;
                    deltaF--;
                }

                if (System.currentTimeMillis() - timer > 1000) {
                    System.out.printf("UPS: %s, FPS: %s%n", ticks, frames);
                    //for (int i = 0; i < InGameObject.inGameObjects.size(); i++) {
                    //InGameObject object = InGameObject.inGameObjects.get(i);
                    //System.out.println("OBJECT: " + object.getName() + " POSITION: "+ object.getXPosition() + "," + object.getYPosition());
                    //}
                    frames = 0;
                    ticks = 0;
                    timer += 1000;
                }
            }catch(Exception e){
                e.printStackTrace();
            }

        }
    }




    //Ran at prescribed tickrate
    private void updateMovement(){

        for(StarSystem s : GSVServer.starSystems) {


            for (Entity e : s.getEntities()) {
                if(e instanceof Vessel){
                    ((Vessel) e).move();
                }
            }


        }
    }


    private void updatePlayerCulling(){
        for(Player player : GSVServer.connectedPlayers) {
            if (player.isInitialized()) {
                NetworkedEntity.CLIENT_RECEIVE.AddEntitiesMessage addedEntities = new NetworkedEntity.CLIENT_RECEIVE.AddEntitiesMessage();
                NetworkedEntity.CLIENT_RECEIVE.UpdateEntitiesMessage updatedEntitiesMessage = new NetworkedEntity.CLIENT_RECEIVE.UpdateEntitiesMessage();
                NetworkedEntity.CLIENT_RECEIVE.RemoveEntitiesMessage removedEntities = new NetworkedEntity.CLIENT_RECEIVE.RemoveEntitiesMessage();


                for (Entity entity : player.getCurrentSystem().getEntities()) {

                    double distance = calculateDistanceBetweenEntities(player.getCurrentVessel(), entity);

                    if (distance < PLAYER_RENDER_DISTANCE && entity.isVisible()) {

                        if (!player.getRenderedEntities().contains(entity)) {
                            player.getRenderedEntities().add(entity);


                            NetworkedEntity networkedEntity = new NetworkedEntity();
                            networkedEntity.model = entity.getModel();
                            networkedEntity.entityIDString = entity.getIDString();
                            networkedEntity.x = entity.getX() - player.getCurrentVessel().getX();
                            networkedEntity.y = entity.getY() - player.getCurrentVessel().getY();
                            networkedEntity.direction = entity.getDirection();
                            networkedEntity.distance = distance;
                            networkedEntity.name = entity.getName();
                            if (entity instanceof Vessel) {
                                networkedEntity.hasHealthPool = true;
                                networkedEntity.currentHull = ((Vessel) entity).getCurrentHullHP();
                                networkedEntity.currentHealth = ((Vessel) entity).getCurrentStructureHP();
                                networkedEntity.currentShield = ((Vessel) entity).getCurrentShieldHP();
                                networkedEntity.maxHealth = ((Vessel) entity).getMaxHullHP();
                                networkedEntity.maxHull = ((Vessel) entity).getMaxHullHP();
                                networkedEntity.maxShield = ((Vessel) entity).getMaxShieldHP();


                            }

                            addedEntities.entities.add(networkedEntity);


                        } else {

                            NetworkedEntity networkedEntity = new NetworkedEntity();
                            networkedEntity.model = entity.getModel();
                            networkedEntity.entityIDString = entity.getIDString();
                            networkedEntity.x = entity.getX() - player.getCurrentVessel().getX();
                            networkedEntity.y = entity.getY() - player.getCurrentVessel().getY();
                            networkedEntity.direction = entity.getDirection();
                            networkedEntity.distance = distance;
                            networkedEntity.name = entity.getName();
                            if (entity instanceof Vessel) {
                                networkedEntity.hasHealthPool = true;
                                networkedEntity.currentHull = ((Vessel) entity).getCurrentHullHP();
                                networkedEntity.currentHealth = ((Vessel) entity).getCurrentStructureHP();
                                networkedEntity.currentShield = ((Vessel) entity).getCurrentShieldHP();
                                networkedEntity.maxHealth = ((Vessel) entity).getMaxHullHP();
                                networkedEntity.maxHull = ((Vessel) entity).getMaxHullHP();
                                networkedEntity.maxShield = ((Vessel) entity).getMaxShieldHP();


                            }

                            updatedEntitiesMessage.entities.add(networkedEntity);

                        }


                    } else if (player.getRenderedEntities().contains(entity)) {
                        player.getRenderedEntities().remove(entity);

                        NetworkedEntity.CLIENT_RECEIVE.RemoveEntitiesMessage removeEntitiesMessage = new NetworkedEntity.CLIENT_RECEIVE.RemoveEntitiesMessage();
                        removeEntitiesMessage.ids.add(entity.getIDString());


                    }
                }


                player.getConnection().sendTCP(addedEntities);
                player.getConnection().sendTCP(updatedEntitiesMessage);
                player.getConnection().sendTCP(removedEntities);

            }
        }
    }

    public static double calculateDistanceBetweenEntities(Entity e1, Entity e2){
        return Point2D.distance(e1.getX(),e1.getY(),e2.getX(), e2.getY());
    }



}
