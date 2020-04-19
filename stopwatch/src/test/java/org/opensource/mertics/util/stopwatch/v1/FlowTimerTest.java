package org.opensource.mertics.util.stopwatch.v1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opensource.mertics.util.stopwatch.StopWatch;

import static org.junit.jupiter.api.Assertions.*;

class FlowTimerTest {
    private StopWatch stopWatch;

    @BeforeEach
    void setUp() {
        stopWatch = new FlowTimer();
    }

    @Test
    void testStop_when_without_start_timer_then_thrown_exception() {
        assertThrows(IllegalStateException.class, () -> {
            stopWatch.stop();
        });
    }

    @Test
    void test_start_when_twice_started_then_thrown_exception() {
        assertThrows(IllegalStateException.class, () -> {
            stopWatch.start();
            stopWatch.start();
        });
    }

    @Test
    void test_elapseTime_when_without_stop_then_thrown_exception() {
        assertThrows(IllegalStateException.class, () -> {
            stopWatch.start();
            // not stopped yet
            stopWatch.elapsedTime();
        });
    }

    @Test
    void test_() {
    }
}