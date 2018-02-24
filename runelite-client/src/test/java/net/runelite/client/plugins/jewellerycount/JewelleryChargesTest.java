package net.runelite.client.plugins.jewellerycount;

import org.junit.Assert;
import org.junit.Test;
import static net.runelite.api.ItemID.*;
import static net.runelite.client.plugins.jewellerycount.JewelleryType.*;

public class JewelleryChargesTest {

    @Test
    public void getChargesTest(){

        JewelleryCharges jewelTest = JewelleryCharges.getCharges(AMULET_OF_GLORY1);
        Assert.assertTrue(jewelTest.getType() != null);
    }

    @Test
    public void getChargesTest2(){
        JewelleryCharges jewelTest = JewelleryCharges.getCharges(AMULET_OF_GLORY1);
        Assert.assertEquals(jewelTest.getCharges(), 1);
    }

    @Test
    public void getIDTest(){
        JewelleryCharges jewelTest = JewelleryCharges.getCharges(AMULET_OF_GLORY1);
        Assert.assertEquals(jewelTest.getId(), 1706);
        Assert.assertEquals(jewelTest.getId(), AMULET_OF_GLORY1);
    }

    @Test
    public void getTypeTest(){
        JewelleryCharges jewelTest = JewelleryCharges.getCharges(AMULET_OF_GLORY1);
        Assert.assertEquals(jewelTest.getType(), GLORY);
    }
}
