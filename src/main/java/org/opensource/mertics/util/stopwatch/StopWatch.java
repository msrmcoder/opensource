package org.opensource.mertics.util.stopwatch;

public interface StopWatch {
    void start();
    void stop();
    long elapsedTime();
}
