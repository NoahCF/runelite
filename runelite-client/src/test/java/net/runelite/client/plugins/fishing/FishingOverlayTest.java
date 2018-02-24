package net.runelite.client.plugins.fishing;

import com.google.inject.testing.fieldbinder.Bind;
import net.runelite.api.*;
import net.runelite.client.plugins.puzzlesolver.PuzzleSolver;
import net.runelite.client.plugins.fishing.FishingSpot;
import net.runelite.client.plugins.xptracker.XpTrackerPlugin;
import net.runelite.client.plugins.xptracker.XpTrackerService;
import net.runelite.client.ui.overlay.components.PanelComponent;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import java.time.Duration;
import java.time.Instant;

import static org.mockito.Matchers.any;

import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import java.awt.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.time.Duration;
import java.time.Instant;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.plugins.xptracker.XpTrackerService;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.PanelComponent;
import org.mockito.stubbing.OngoingStubbing;

@RunWith(MockitoJUnitRunner.class)
public class FishingOverlayTest
{

	@Mock
	@Bind
	FishingSession session;

	@Mock
	@Bind
	FishingPlugin plugin;

	@Mock
	@Bind
	FishingConfig config;

	@Mock
	@Bind
	XpTrackerService xpTrackerService;

	@Mock
	@Bind
	Graphics2D graphics;

	@Mock
	@Bind
	Point parent;

	@Mock
	@Bind
	PanelComponent panelComponent;

	@Mock
	@Bind
	Client client;


	@Mock
	@Bind
	Player player;

	@Mock
	FontMetrics fontMetrics;


	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this); // initialize all the @Mock objects
		// Setup other Static Mocks
	}

	private static final String FISHING_SPOT = "Fishing spot";


	@Test
	public void testLastFishCaught()
	{
		FishingOverlay fishingOverlay = new FishingOverlay(client, plugin, config, xpTrackerService, session);
		when(session.getLastFishCaught()).thenReturn(null);

        assertEquals(null, fishingOverlay.render(graphics, parent));

	} //returns null because player is not fishing

	@Test
	public void testOverlay()
	{
		FishingOverlay fishingOverlay = new FishingOverlay(client, plugin, config, xpTrackerService, session);
		when(session.getLastFishCaught()).thenReturn(Instant.now());

		assertEquals(null, fishingOverlay.render(graphics, parent));
	} //returns null because player is no longer fishing

	@Test
	public void testPanelComponent()
	{
		FishingOverlay fishingOverlay = new FishingOverlay(client, plugin, config, xpTrackerService, session);
		when(session.getLastFishCaught()).thenReturn(Instant.now());

		verify(panelComponent,times(1)).getLines();
		assertEquals(null, fishingOverlay.render(graphics, parent));
	} //returns null because player is no longer fishing

    @Test
    public void xpFishTracker(){


        //	PanelComponent panelComponent = mock(PanelComponent.class);

        FishingOverlay fishingOverlay = new FishingOverlay(client, plugin, config, xpTrackerService, session);

        //Mocks the player and the time for the last fish caught to both not be null
        when(client.getLocalPlayer()).thenReturn(player);
        when(client.getLocalPlayer().getInteracting()).thenReturn(player);
        when(client.getLocalPlayer().getInteracting().getName()).thenReturn("Fishing Spot");
        when(session.getLastFishCaught()).thenReturn(Instant.now().minus(Duration.ofSeconds(-10))).thenReturn(Instant.now().minus(Duration.ofSeconds(-10)));

        // this mock prevents a null error on returning a panelComponent.
        when(graphics.getFontMetrics()).thenReturn(fontMetrics);


        //Method we are testing
        fishingOverlay.render(graphics, parent);

        assertEquals(0, xpTrackerService.getActions(Skill.FISHING));

    }

}


