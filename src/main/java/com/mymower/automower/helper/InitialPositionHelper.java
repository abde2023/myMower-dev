package com.mymower.automower.helper;

import com.mymower.automower.model.Direction;
import com.mymower.automower.model.Position;

public class InitialPositionHelper {
    public static boolean isValidInitialPosition(String line) {
        return line != null && !line.isBlank() && line.matches("^\\d{2}[NSWE]$");
    }

    public static Position getInitialPosition(String line) {
        String[] split = line.split("");
        Direction direction = Direction.getDirectionFromCode(split[2]);
        return new Position(Integer.valueOf(split[0]), Integer.valueOf(split[1]), direction);
    }
}
