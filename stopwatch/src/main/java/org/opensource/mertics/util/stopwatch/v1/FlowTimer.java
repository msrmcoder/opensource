package org.opensource.mertics.util.stopwatch.v1;

import org.opensource.mertics.util.stopwatch.StopWatch;

public class FlowTimer implements StopWatch {
    private long start;
    private long end;
    private boolean status;

    public void start() {
        if(status)
            throw new IllegalStateException("Already started!");
        start = System.currentTimeMillis();
        status = true;
    }

    public void stop() {
        if(!status)
            throw new IllegalStateException("Start before stop");
        end = System.currentTimeMillis();
        status = false;
    }

    public long elapsedTime() {
        if(status)
            throw new IllegalStateException("FlowTimer is running, stop before computing elapsed time.");
        return end - start;
    }

    public static void main(String[] args) {
        FlowTimer timer = new FlowTimer();
        timer.start();
        timer.stop();
        System.out.println(timer.elapsedTime());
    }
}
