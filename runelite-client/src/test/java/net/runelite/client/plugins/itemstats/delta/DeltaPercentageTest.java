package net.runelite.client.plugins.itemstats.delta;

import org.junit.Test;

import static org.junit.Assert.*;

public class DeltaPercentageTest {

    @Test
    public void calculateDelta() {
        DeltaPercentage dp = new DeltaPercentage(50, 3);
        DeltaPercentage dp2 = new DeltaPercentage(80, -2);
        DeltaPercentage dp3 = new DeltaPercentage(20, 0);

        assertEquals(3503, dp.calculateDelta(70));
        assertEquals(-3202, dp2.calculateDelta(40));
        assertEquals(400, dp3.calculateDelta(20));
    }
}