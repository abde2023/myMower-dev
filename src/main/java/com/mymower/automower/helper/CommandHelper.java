package com.mymower.automower.helper;

import com.mymower.automower.model.Command;
import io.micrometer.common.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandHelper
{
    public static boolean isValidLine(String line) {
        return StringUtils.isNotBlank(line);
    }

    public static List<Command> getCommandsOfMower(String line) {
        String[] split = line.split(" ");

        List<Command> cmds = new ArrayList<Command>();
        char [] listeCmds = split[1].toCharArray();

        for (char c : listeCmds) {
            cmds.add(Command.getCommandeFromCode(String.valueOf(c)));
        }

        return cmds;
    }
}
