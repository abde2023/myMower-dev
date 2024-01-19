package com.mymower.automower.helper;

import com.mymower.automower.model.GardenLimit;

public class GardenLimitHelper {
    public static boolean isValidGardenLimitLine(String line) {
        return line != null && !line.isBlank() && line.matches("^\\d{2}$");
    }

    public static GardenLimit getGardenLimitFromLine(String line) {
        String[] pos = line.split("");
        return GardenLimit.builder()
                .x(Integer.valueOf(pos[0]))
                .y(Integer.valueOf(pos[1]))
                .build();
    }
}
