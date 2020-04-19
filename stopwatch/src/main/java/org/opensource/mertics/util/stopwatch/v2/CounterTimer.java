package org.opensource.mertics.util.stopwatch.v2;

import org.opensource.mertics.util.stopwatch.StopWatch;

public class CounterTimer implements StopWatch {
    private long start;
    private long end;
    private long delta;
    private boolean status;

    public void start() {
        if(status)
            throw new IllegalStateException("Already started!");
        start = System.currentTimeMillis();
        status = true;
    }

    public void stop() {
        if(!status)
            throw new IllegalStateException("Start before stop.");
        end = System.currentTimeMillis();
        delta += end - start;
        status = false;
    }

    public long elapsedTime() {
        if(status)
            throw new IllegalStateException("CounterTimer is running, stop before calculating elapsed time.");
        return delta;
    }

    public static void main(String[] args) throws InterruptedException {
        StopWatch timer = new CounterTimer();
        timer.start();
        Thread.sleep(100);
        timer.stop();
        timer.start();
        Thread.sleep(200);
        timer.stop();
        System.out.println(timer.elapsedTime());
    }
}
