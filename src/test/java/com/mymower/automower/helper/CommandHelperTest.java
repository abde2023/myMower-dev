package com.mymower.automower.helper;

import com.mymower.automower.model.Command;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CommandHelperTest {

    @Test
    @DisplayName("Should return true when it's a valid command line")
    public void shouldReturnTrue_whenValidcommand() {
        //Given
        String validCommand = "GAGAGAGAA";
        //When
        boolean validCommandLine = CommandHelper.isValidCommandLine(validCommand);
        //Then
        assertTrue(validCommandLine);
    }

    @Test
    @DisplayName("Should return false when it's not a valid command line")
    public void shouldReturnFalse_whenNotValidCommand() {
        //Given
        String notValidCommand = "XGAGAGAGAA";
        //When
        boolean notValidCommandLine = CommandHelper.isValidCommandLine(notValidCommand);
        //Then
        assertFalse(notValidCommandLine);
    }

    @Test
    @DisplayName("Should return list of valid command when it's a valid command line")
    public void shouldReturnListOfValidCommand_whenValidCommandLine() {
        //Given
        String validCommandLine = "12N GAGAGAGAA";

        //When
        List<Command> commandsOfMower = CommandHelper.getCommandsOfMower(validCommandLine);

        //Then
        List<Command> expected = Arrays.asList(Command.Gauche, Command.Avance, Command.Gauche, Command.Avance, Command.Gauche, Command.Avance, Command.Gauche, Command.Avance, Command.Avance);

        assertEquals(expected, commandsOfMower);

    }


}
