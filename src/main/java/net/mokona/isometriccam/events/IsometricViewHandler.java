package net.mokona.isometriccam.events;

import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.mokona.isometriccam.utils.IsometricProjection;

import static org.lwjgl.glfw.GLFW.*;

public class IsometricViewHandler {
    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event){
        if (event.getKey() == GLFW_KEY_F10 && event.getAction() == GLFW_PRESS){
            IsometricProjection.isometric = !IsometricProjection.isometric;
        }
    }
}
