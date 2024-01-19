package com.mymower.automower.helper;

import com.mymower.automower.exceptions.NotValidCommandLineException;
import com.mymower.automower.exceptions.NotValidPositionException;
import com.mymower.automower.model.Command;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class CommandHelper {
    public static boolean isValidCommandLine(String line) {
        return line != null && !line.isBlank() && line.matches("^[ADG]+$");
    }

    public static List<Command> getCommandsOfMower(String line) {
        String[] split = line.split(" ");
        if (!isValidCommandLine(split[1])) {
            log.error("Invalid commands line : {} is provided in the file", split[1]);
            throw new NotValidCommandLineException();
        }
        return Arrays.stream(split[1].split("")).map(c -> Command.getCommandeFromCode(c)).collect(Collectors.toList());
    }
}
