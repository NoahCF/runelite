package net.runelite.client.plugins.cannon;

import com.google.inject.Inject;
import com.google.inject.testing.fieldbinder.Bind;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.Player;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameObjectSpawned;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static net.runelite.api.ChatMessageType.SERVER;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class connontest {
    @Mock
    @Bind
    CannonConfig cannonconfig;

    @Inject
    CannonPlugin plugin;

    @Mock
    @Bind
    CannonOverlay overlay;

    @Mock
    @Bind
    GameObject object;

    @Mock
    @Bind
    ChatMessage message;

    @Mock
    @Bind
    ChatMessage message2;

    @Mock
    @Bind
    ChatMessage message3;

    @Mock
    @Bind
    GameObjectSpawned event;

    @Mock
    @Bind
    Player player;

    @Mock
    @Bind
    Client client;

    private static final String MESSAGE  = "You load the cannon with";
    private static final String MESSAGE2  = "A Cannon ball was dropped on my foot";
    private static final String MESSAGE3  = "My foot is now flat";

    @Before
    public void before() {
        message = new ChatMessage(SERVER, "Marc", MESSAGE, null);
        message2 = new ChatMessage(SERVER, "Marc", MESSAGE2, null);
        message3 = new ChatMessage(SERVER, "Marc", MESSAGE3, null);
        event = new GameObjectSpawned();
        player = client.getLocalPlayer();
    }

    @Test
    public void testMessage() {
        assertEquals(message.getMessage(), MESSAGE);
        assertEquals(message2.getMessage(), MESSAGE2);
        assertEquals(message3.getMessage(), MESSAGE3);
    }

    @Test
    public void testGameObjectSpawn() {
       object =  event.getGameObject();
       assertNull(object);
    }

}
