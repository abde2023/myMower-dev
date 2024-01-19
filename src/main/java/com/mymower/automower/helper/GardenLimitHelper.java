package com.mymower.automower.helper;

import com.mymower.automower.model.GardenLimit;

public class GardenLimitHelper {
    public static boolean isValidLine() {
        return true;
    }

    public static GardenLimit process(String line) {
        String[] pos = line.split("");
        return new GardenLimit(Integer.valueOf(pos[0]), Integer.valueOf(pos[1]));
    }
}
