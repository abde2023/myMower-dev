package com.mymower.automower.exceptions;

public class NotValidGardenLimitException extends RuntimeException {
    public NotValidGardenLimitException() {
        super("Not valid Garden limit coordinates provided in the file");
    }
}
