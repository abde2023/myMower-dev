package com.mymower.automower.helper;

import com.mymower.automower.model.Direction;
import com.mymower.automower.model.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InitialPositionHelperTest {

    @Test
    @DisplayName("Should return true when it's a valid initialPostion")
    public void shouldReturnTrue_whenValidPosition() {
        //Given
        String validPositionLine = "12N";
        //When
        boolean valid = InitialPositionHelper.isValidInitialPosition(validPositionLine);
        //Then
        assertTrue(valid);
    }

    @Test
    @DisplayName("Should return false when it's not a valid initialPostion")
    public void shouldReturnFalse_whenNotValidPosition() {
        //Given
        String positionLine = "100N";
        //When
        boolean result = InitialPositionHelper.isValidInitialPosition(positionLine);
        //Then
        assertFalse(result);
    }

    @Test
    @DisplayName("Should return valid Position when it's Ok")
    public void shouldReturnListOfValidCommand_whenValidCommandLine() {
        //Given
        String validLine = "12N GAGAGAGAA";

        //When
        Position position = InitialPositionHelper.getInitialPosition(validLine);

        //Then
        Position expected = new Position(1, 2, Direction.North);
        assertEquals(expected, position);

    }


}
