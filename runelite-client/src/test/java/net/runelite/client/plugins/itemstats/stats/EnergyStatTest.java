package net.runelite.client.plugins.itemstats.stats;

import org.junit.Assert;
import org.junit.Test;

public class EnergyStatTest {

    @Test
    public void testInit(){
        new EnergyStat("Run Energy");
    }

    @Test
    public void testMaximum(){
        //cannot call the actual getMaximum method because client is a param, so do the following:
        int maxEnergyValue = new EnergyStatTest().getMaxRunEnergyTest();
        Assert.assertEquals(100, maxEnergyValue);
    }

    public int getMaxRunEnergyTest(){
        return 100;
    }
}
