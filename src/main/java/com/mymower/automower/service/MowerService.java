package com.mymower.automower.service;

import com.mymower.automower.domain.Mower;
import com.mymower.automower.helper.CommandHelper;
import com.mymower.automower.helper.GardenLimitHelper;
import com.mymower.automower.helper.InitialPositionHelper;
import com.mymower.automower.model.Position;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MowerService {
    private List<Mower> mowers = new ArrayList<>();

    public void initialGardenWithMowers(final List<String> lines) {
        if (lines == null || lines.size() == 0) {
        }
        String gardenLimit = lines.get(0);
        List<String> linesWithoutHeader = lines.stream().skip(1).collect(Collectors.toList());

        for (String line : linesWithoutHeader) {
            String[] splittedlines = line.split(" ");

            Mower mower = new Mower(GardenLimitHelper.getGardenLimitFromLine(gardenLimit), InitialPositionHelper.getInitialPosition(line), CommandHelper.getCommandsOfMower(line));
            this.mowers.add(mower);
        }

    }

    public List<Position> process() {
        List<Position> position = new ArrayList<>();
        for (Mower mower : mowers) {
            position.add(mower.getPositionFromCommands());
        }
        return position;
    }
}
