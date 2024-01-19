package com.mymower.automower.exceptions;

public class CannotReadFileException extends RuntimeException {
    public CannotReadFileException() {
        super("Cannot read provided file");
    }
}
