package com.mymower.automower.exceptions;

public class NotValidCommandLineException extends RuntimeException {
    public NotValidCommandLineException() {
        super("Not valid command line provided in the file");
    }
}
