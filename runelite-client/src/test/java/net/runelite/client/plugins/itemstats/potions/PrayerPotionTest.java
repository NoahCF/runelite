package net.runelite.client.plugins.itemstats.potions;

import org.junit.Test;

import static org.junit.Assert.*;

public class PrayerPotionTest {

    @Test
    public void healsTest() {
        int delta = 0;
        int max = 80;
        double perc = 0.25;

        //Can't call heals() method as it takes Client as param
        int healValue = (((int) (max * perc)) * (delta >= 0 ? 1 : -1)) + delta;
        assertEquals(20, healValue);
    }
}