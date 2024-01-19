package com.mymower.automower.domain;

import com.mymower.automower.model.Command;
import com.mymower.automower.model.GardenLimit;
import com.mymower.automower.model.Position;

import java.util.List;

public class Mower {
    private final Position position;
    private final GardenLimit limit;
    private final List<Command> commands;

    public Mower(final GardenLimit limit, final Position position, final List<Command> commands) {

        if (!position.isValidPosition(limit)) {
            System.out.println("invalid");
        }

        this.position = position;
        this.limit = limit;
        this.commands = commands;
    }

    public Position getPositionFromCommands() {
        for (Command cmd : commands) {
            processCommand(cmd);
        }
        return position;
    }

    private void processCommand(final Command cmd) {
        switch (cmd) {
            case Avance -> position.aheadIfPossible(limit);
            case Droite -> position.turnRightDirection();
            case Gauche -> position.turnLeftDirection();
        }
    }
}
