package com.mymower.automower.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class GardenLimit {

    private final Integer x;
    private final Integer y;
}
