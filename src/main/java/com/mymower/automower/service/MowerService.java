package com.mymower.automower.service;

import com.mymower.automower.domain.Mower;
import com.mymower.automower.exceptions.EmptyFileException;
import com.mymower.automower.helper.CommandHelper;
import com.mymower.automower.helper.GardenLimitHelper;
import com.mymower.automower.helper.InitialPositionHelper;
import com.mymower.automower.model.Position;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class MowerService {

    private final FileReaderService fileReaderService;

    public List<Position> getFinalPositionOfMowersFromFile(String path) {
        List<String> processedLinesList = this.fileReaderService.readAndProcessFile(path);
        List<Mower> mowers = this.initialGardenWithMowers(processedLinesList);
        return this.getPositionForMowers(mowers);
    }

    private List<Mower> initialGardenWithMowers(final List<String> lines) {
        if (lines == null || lines.size() == 0) {
            log.error("An empty lines List is provided, Cannot process");
            throw new EmptyFileException();
        }

        String gardenLimit = lines.get(0);

        List<String> linesWithoutHeader = lines.stream().skip(1).collect(Collectors.toList());
        List<Mower> mowers = new ArrayList<>();

        for (String line : linesWithoutHeader) {
            Mower mower = new Mower(GardenLimitHelper.getGardenLimitFromLine(gardenLimit), InitialPositionHelper.getInitialPosition(line), CommandHelper.getCommandsOfMower(line));
            mowers.add(mower);
        }
        return mowers;

    }

    public List<Position> getPositionForMowers(List<Mower> mowers) {
        List<Position> position = new ArrayList<>();
        for (Mower mower : mowers) {
            position.add(mower.getPositionFromCommands());
        }
        return position;
    }

}
