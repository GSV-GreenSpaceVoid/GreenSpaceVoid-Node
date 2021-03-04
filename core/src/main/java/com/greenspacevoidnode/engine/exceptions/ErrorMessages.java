package com.greenspacevoidnode.engine.exceptions;

public class ErrorMessages {


    public static class OofExceptionError extends Exception{






    }


    public static class CargoHoldNotEmptyException extends Exception{
        public CargoHoldNotEmptyException(){
            super("Cargo Hold is NOT empty! Empty first and try again!");
        }
    }
















}
