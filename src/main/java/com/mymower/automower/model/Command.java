package com.mymower.automower.model;

public enum Command {
    Avance("A"),
    Droite("D"),
    Gauche("G");
    private String code;

    private Command(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }

    public static Command getCommandFromCode(final String code) {
        for (Command command : Command.values()) {
            if (command.getCode().equals(code)) {
                return command;
            }
        }
        return null;
    }

}
