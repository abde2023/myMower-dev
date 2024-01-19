package com.mymower.automower.helper.service;

import com.mymower.automower.domain.Mower;
import com.mymower.automower.model.Command;
import com.mymower.automower.model.Direction;
import com.mymower.automower.model.GardenLimit;
import com.mymower.automower.model.Position;
import com.mymower.automower.service.MowerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class MowerServiceTest {

    @Autowired
    MowerService mowerService;

    @Test
    @DisplayName("Should get Positions list when given a list of mowers")
    public void shouldReturnList_whenGivenListOfString() {
        //Given
        GardenLimit gardenLimit = GardenLimit.builder()
                .x(5)
                .y(5)
                .build();
        List<Command> commands1 = Arrays.asList(Command.Gauche, Command.Avance, Command.Gauche, Command.Avance, Command.Gauche, Command.Avance, Command.Gauche, Command.Avance, Command.Avance);
        List<Command> commands2 = Arrays.asList(Command.Avance, Command.Avance, Command.Droite, Command.Avance, Command.Avance, Command.Droite, Command.Avance, Command.Droite, Command.Droite, Command.Avance);

        Position position1 = new Position(1, 2, Direction.North);
        Position position2 = new Position(3, 3, Direction.East);
        Mower mower1 = new Mower(gardenLimit, position1, commands1);

        Mower mower2 = new Mower(gardenLimit, position2, commands2);


        List<Mower> mowerList = Arrays.asList(mower1,mower2);
        //when
        List<Position> positionForMowers = this.mowerService.getPositionForMowers(mowerList);

        //Then
        Position finalPosition1 = new Position(1, 3, Direction.North);
        Position finalPosition2 = new Position(5, 1, Direction.East);
        List<Position> expectedPositions = Arrays.asList(finalPosition1,finalPosition2);

        assertEquals(expectedPositions, positionForMowers);


    }
}
