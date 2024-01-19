package com.mymower.automower.helper;

import com.mymower.automower.exceptions.NotValidGardenLimitException;
import com.mymower.automower.model.GardenLimit;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GardenLimitHelper {
    public static boolean isValidGardenLimitLine(String line) {
        return line != null && !line.isBlank() && line.matches("^\\d{2}$");
    }

    public static GardenLimit getGardenLimitFromLine(String line) {
        String[] pos = line.split("");
        if (!isValidGardenLimitLine(line)) {
            log.error("Invalid garden limit : {} is provided in the file", line);
            throw new NotValidGardenLimitException();
        }
        return GardenLimit.builder().x(Integer.valueOf(pos[0])).y(Integer.valueOf(pos[1])).build();
    }
}
