package com.austinwc.testutils;

public class ApproxTimeElapsed {
    private long startTime = -1;

    public final void setStartTime() {
        startTime = System.currentTimeMillis();
    }

    public final long getElapsedTime() {
        if (startTime == -1) return -1;

        long elapsedTime = System.currentTimeMillis();
        elapsedTime -= startTime;
        startTime = -1;

        return elapsedTime;
    }
}
