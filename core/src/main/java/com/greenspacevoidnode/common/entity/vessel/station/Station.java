package com.greenspacevoidnode.common.entity.vessel.station;

import com.greenspacevoidnode.common.entity.Entity;
import com.greenspacevoidnode.common.entity.vessel.Vessel;
import com.greenspacevoidnode.common.item.Item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Station extends Vessel {
    //Todo: Cargo capacities.
    private static int baseCargoCapacity = 10000;
    public Station(String name, double x, double y, double volume, boolean isInvincible, boolean isTargetable, boolean canMove) {
        super(name, x, y, volume, isInvincible, isTargetable, canMove, baseCargoCapacity);
    }

    public static class JumpGate extends Station{//World or player owned.
        private long jumpWarmupTime;
        private JumpGate linkedJumpGate;
        private boolean isLinked;
        private double jumpDistance;

        public JumpGate(String name, double x, double y, double volume, boolean isInvincible, boolean isTargetable, boolean canMove, long baseJumpWarmupTime) {
            super(name, x, y, volume, isInvincible, isTargetable, canMove);
            isLinked = false;
            this.jumpWarmupTime = baseJumpWarmupTime;


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
            private double jumpPower, shipSize;

            private ArrayList<Item> cargoHold;
            double cargoHoldSpace;



            public PlayerGate(String name, double x, double y, double volume, double cargoHoldSpace, long baseJumpWarmupTime) {
                super(name, x, y, volume, isInvincible, isTargetable, canMove, baseJumpWarmupTime);
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



            public NPCGate(String name, double x, double y, double volume, long baseJumpWarmupTime) {
                super(name, x, y, volume, isInvincible, isTargetable, canMove, baseJumpWarmupTime);
            }


            @Override
            public void linkGate(JumpGate gate) throws IOException {

                this.setName(gate.getStarSystem().getName());





            }
        }









    }







}











