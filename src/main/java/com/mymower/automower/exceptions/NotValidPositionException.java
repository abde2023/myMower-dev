package com.mymower.automower.exceptions;

public class NotValidPositionException extends RuntimeException {
    public NotValidPositionException(){
        super("Not a valid initial position is provided in the file ");
    }
}
