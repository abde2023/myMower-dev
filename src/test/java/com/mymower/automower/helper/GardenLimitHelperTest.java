package com.mymower.automower.helper;

import com.mymower.automower.model.GardenLimit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GardenLimitHelperTest {

    @Test
    @DisplayName("Should return true when it's  a valid garden limit")
    public void shouldReturnTrue_whenNotValidLimit() {
        //Given
        String limit = "55";
        //When
        boolean result = GardenLimitHelper.isValidGardenLimitLine(limit);
        //Then
        assertTrue(result);
    }

    @Test
    @DisplayName("Should return false when it's not a valid garden limit")
    public void shouldReturnFalse_whenNotValidLimit() {
        //Given
        String limit = "600";
        //When
        boolean result = GardenLimitHelper.isValidGardenLimitLine(limit);
        //Then
        assertFalse(result);
    }

    @Test
    @DisplayName("Should return valid GardenLimit when it's Ok")
    public void shouldReturnListOfValidCommand_whenValidCommandLine() {
        //Given
        String validLine = "55";

        //When
        GardenLimit gardenLimit = GardenLimitHelper.getGardenLimitFromLine(validLine);

        //Then
        GardenLimit expected = GardenLimit.builder()
                .x(5)
                .y(5).build();
        assertEquals(expected, gardenLimit);

    }
}
