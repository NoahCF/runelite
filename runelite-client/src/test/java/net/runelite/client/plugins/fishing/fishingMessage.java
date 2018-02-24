package net.runelite.client.plugins.fishing;

import com.google.inject.testing.fieldbinder.Bind;
import net.runelite.api.events.ChatMessage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.inject.Inject;

import static net.runelite.api.ChatMessageType.SERVER;
import static org.junit.Assert.assertEquals;

package net.runelite.client.plugins.fishing;


import com.google.inject.testing.fieldbinder.Bind;

import javax.inject.Inject;

import static net.runelite.api.ChatMessageType.FILTERED;
import static net.runelite.api.ChatMessageType.SERVER;

import net.runelite.api.ChatMessageType;
import net.runelite.api.events.ChatMessage;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import org.mockito.runners.MockitoJUnitRunner;


    @RunWith(MockitoJUnitRunner.class)
    public class fishingMessage {

        @Mock
        @Bind
        FishingConfig fishConfig;

        @Inject
        FishingPlugin fishingplugin;

        @Mock
        @Bind
        FishingOverlay overlay;

        @Mock
        @Bind
        FishingSession fishingsession;

        @Mock
        @Bind
        ChatMessage chatMessage;

        @Mock
        @Bind
        ChatMessage chatMessage2;


        @Mock
        @Bind
        ChatMessage chatMessage3;


        public static final String MESSAGE = "You catch a";
        public static final String MESSAGE2 = "You catch some";
        public static final String MESSAGE3 = "";

        @Before
        public void before()
        {

        }
        //Test constructor
        @Test
        public void testOnChatMessageConstructor(){
            new ChatMessage(SERVER, "Micho", MESSAGE, null);
        }

        @Test
        public void testonChatMessages(){
            chatMessage = new ChatMessage(SERVER, "Micho", MESSAGE, null);
            chatMessage2 = new ChatMessage(SERVER, "Micho", MESSAGE2, null);
            chatMessage3 = new ChatMessage(SERVER, "Micho", MESSAGE3, null);

            assertEquals(chatMessage.getMessage(), "You catch a");
            assertEquals(chatMessage2.getMessage(), "You catch some");
            assertEquals(chatMessage3.getMessage(), "");

        }

    }


