package com.mymower.automower.helper;

import com.mymower.automower.model.Command;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommandHelper {
    public static boolean isValidCommandLine(String line) {
        return line != null && !line.isBlank() && line.matches("^[ADG]+$");
    }

    public static List<Command> getCommandsOfMower(String line) {
        String[] split = line.split(" ");
        return Arrays.stream(split[1].split("")).map(c -> Command.getCommandeFromCode(c)).collect(Collectors.toList());
    }
}
