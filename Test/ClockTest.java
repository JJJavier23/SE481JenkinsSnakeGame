import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.psnbtech.Clock;
import org.psnbtech.SnakeGame;

public class ClockTest {
	
	private Clock clock;

    @Before
    public void setUp() {
        clock = new Clock(60.0f);
    }

    @Test
    public void testConstructor() {
        assertEquals(1000.0f / 60.0f, clock.millisPerCycle, 0.001f);
        assertFalse(clock.isPaused());
    }

    @Test
    public void testSetCyclesPerSecond() {
        clock.setCyclesPerSecond(30.0f);
        assertEquals(1000.0f / 30.0f, clock.millisPerCycle, 0.001f);
    }

    @Test
    public void testReset() {
        clock.elapsedCycles = 10;
        clock.excessCycles = 0.5f;
        clock.isPaused = true;

        clock.reset();

        assertEquals(0, clock.elapsedCycles);
        assertEquals(0.0f, clock.excessCycles, 0.001f);
        assertFalse(clock.isPaused());
    }

    @Test
    public void testUpdate() {
        clock.lastUpdate = System.nanoTime() / 1000000L - 100;
        clock.elapsedCycles = 0;
        clock.excessCycles = 0.0f;

        clock.update();

        assertTrue(clock.elapsedCycles > 0);
        assertTrue(clock.excessCycles > 0.0f);
    }

    @Test
    public void testUpdatePaused() {
        clock.lastUpdate = System.nanoTime() / 1000000L - 100;
        clock.elapsedCycles = 0;
        clock.excessCycles = 0.0f;
        clock.isPaused = true;

        clock.update();

        assertEquals(0, clock.elapsedCycles);
        assertEquals(0.0f, clock.excessCycles, 0.001f);
    }

    @Test
    public void testSetPaused() {
        clock.setPaused(true);
        assertTrue(clock.isPaused());

        clock.setPaused(false);
        assertFalse(clock.isPaused());
    }

    @Test
    public void testIsPaused() {
        clock.isPaused = true;
        assertTrue(clock.isPaused());

        clock.isPaused = false;
        assertFalse(clock.isPaused());
    }

    @Test
    public void testHasElapsedCycle() {
        clock.elapsedCycles = 0;
        assertFalse(clock.hasElapsedCycle());

        clock.elapsedCycles = 1;
        assertTrue(clock.hasElapsedCycle());
        assertEquals(0, clock.elapsedCycles);
    }

    @Test
    public void testPeekElapsedCycle() {
        clock.elapsedCycles = 0;
        assertFalse(clock.peekElapsedCycle());

        clock.elapsedCycles = 1;
        assertTrue(clock.peekElapsedCycle());
        assertEquals(1, clock.elapsedCycles);
    }
}
