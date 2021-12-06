package com.advent.of.code.daysix.model;

public class Fish {
    private int internalTimer;

    private Fish() {
        this(8);
    }

    public Fish(int internalTimer) {
        this.internalTimer = internalTimer;
    }

    public Fish reproduce() {
        return new Fish();
    }

    public void updateFishInternal() {
        if (internalTimer == 0) {
            internalTimer = 6;
        } else {
            internalTimer--;
        }
    }

    public int getInternalTimer() {
        return internalTimer;
    }

    public void setInternalTimer(int internalTimer) {
        this.internalTimer = internalTimer;
    }
}
