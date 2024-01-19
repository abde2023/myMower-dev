package com.mymower.automower.exceptions;

public class EmptyFileException extends RuntimeException {
    public EmptyFileException() {
        super("An empty file is provided");
    }
}
