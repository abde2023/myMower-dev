package com.mymower.automower.model;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Builder
public class GardenLimit {

    private final Integer x;
    private final Integer y;
}
