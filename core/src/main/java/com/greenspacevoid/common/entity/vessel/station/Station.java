package com.greenspacevoid.common.entity.vessel.station;

import com.greenspacevoid.common.entity.Entity;
import com.greenspacevoid.common.entity.vessel.Vessel;
import com.greenspacevoid.common.item.Item;
import com.greenspacevoid.common.system.StarSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Station extends Vessel {


    public Station(String name, double x, double y, double volume, boolean isInvincible, boolean isTargetable, boolean canMove) {
        super(name, x, y, volume, isInvincible, isTargetable, canMove);
    }


    public static class JumpGate extends Station{//World or player owned.
        private final long jumpWarmupTime = 1000;
        private JumpGate linkedJumpGate;
        private boolean isLinked;
        private double jumpDistance;

        public JumpGate(String name, double x, double y, double volume, boolean isInvincible, boolean isTargetable, boolean canMove) {
            super(name, x, y, volume, isInvincible, isTargetable, canMove);
            isLinked = false;



        }


        public void jump(Entity entity){
            //Todo: send jump beepbop to client


            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    entity.setX(linkedJumpGate.getX());
                    entity.setY(linkedJumpGate.getY());



                }
            };

            Timer timer = new Timer(true);
            timer.schedule(timerTask, jumpWarmupTime);




        }

        public void linkGate(JumpGate gate) throws IOException {
            //Todo: Advanced distance calculations
            //Todo: compute jump distance (in Lightyears)






        }



        public static class PlayerGate extends JumpGate{
            private static final boolean isInvincible = false;
            private static final boolean isTargetable = true;
            private static final boolean canMove = false; //Tractor a jumpgate into the nearest star anyone?
            private double jumpPower;

            private ArrayList<Item> cargoHold;
            double cargoHoldSpace;



            public PlayerGate(String name, double x, double y, double volume, double cargoHoldSpace) {
                super(name, x, y, volume, isInvincible, isTargetable, canMove);
                cargoHold = new ArrayList<>();
                this.cargoHoldSpace = cargoHoldSpace;


            }


            @Override
            public void jump(Entity entity) {







                super.jump(entity);
            }
        }










        public static class NPCGate extends JumpGate{
            private static final boolean canMove = false;
            private static final boolean isTargetable = false;
            private static final boolean isInvincible = true;



            public NPCGate(String name, double x, double y, double volume) {
                super(name, x, y, volume, isInvincible, isTargetable, canMove);
            }


            @Override
            public void linkGate(JumpGate gate) throws IOException {

                this.setName(gate.getStarSystem().getName());





            }
        }









    }







}











