package com.mymower.automower.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Position {

    private Integer x;
    private Integer y;
    private Direction direction;

    public void turnRightDirection() {
        direction = direction.getRightDirection();
    }

    public void turnLeftDirection() {
        direction = direction.getLeftDirection();
    }

    public void aheadIfPossible(final GardenLimit limit) {
        switch (direction) {
            case North:
                if (y < limit.getY()) {
                    y += 1;
                }
                break;
            case South:
                if (y > 0) {
                    y -= 1;
                }
                break;
            case East:
                if (x < limit.getX()) {
                    x += 1;
                }
                break;
            case West:
                if (x > 0) {
                    x -= 1;
                }
                break;
        }
    }

    public boolean isValidPosition(final GardenLimit limit) {
        return x >= 0 && x <= limit.getX() && y >= 0 && y <= limit.getY();
    }

}
