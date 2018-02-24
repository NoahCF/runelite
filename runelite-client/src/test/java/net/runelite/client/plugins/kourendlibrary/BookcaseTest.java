package net.runelite.client.plugins.kourendlibrary;

import static org.junit.Assert.assertEquals;

import net.runelite.api.Point3D;
import org.junit.Test;
/**
 * Created by garrisonblair on 2018-02-23.
 */

public class BookcaseTest {

    @Test
    public void testGetLocationString() {
        // North-West middle floor
        Bookcase bookcase = new Bookcase(new Point3D(1500, 4000, 1));
        assertEquals(bookcase.getLocationString(), "Northwest middle floor");

        // North-East top floor
        Bookcase bookcase1 = new Bookcase(new Point3D(2000, 4000, 2));
        assertEquals(bookcase1.getLocationString(), "Northeast top floor");

        // South-West bottom floor
        Bookcase bookcase2 = new Bookcase(new Point3D(1500, 3500, 0));
        assertEquals(bookcase2.getLocationString(), "Southwest ground floor");

        // Center top floor
        Bookcase bookcase3 = new Bookcase(new Point3D(2000, 3500, 2));
        assertEquals(bookcase3.getLocationString(), "Center top floor");
    }
}
