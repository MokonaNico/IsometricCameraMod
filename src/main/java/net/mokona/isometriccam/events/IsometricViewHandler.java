package net.mokona.isometriccam.events;

import net.minecraft.client.Minecraft;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.mokona.isometriccam.utils.IsometricProjection;

import static org.lwjgl.glfw.GLFW.*;

public class IsometricViewHandler {
    public static final Minecraft MC = Minecraft.getInstance();

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (event.getAction() == GLFW_PRESS) {
            if (event.getKey() == GLFW_KEY_F10) {
                IsometricProjection.isometric = !IsometricProjection.isometric;
                MC.smartCull = !IsometricProjection.isometric;
            }
            if (IsometricProjection.isometric) {
                if (event.getKey() == GLFW_KEY_KP_8) {
                    IsometricProjection.rotateX(1);
                } else if (event.getKey() == GLFW_KEY_KP_2) {
                    IsometricProjection.rotateX(-1);
                } else if (event.getKey() == GLFW_KEY_KP_7) {
                    IsometricProjection.zoom(-1);
                } else if (event.getKey() == GLFW_KEY_KP_9) {
                    IsometricProjection.zoom(1);
                } else if (event.getKey() == GLFW_KEY_KP_4) {
                    IsometricProjection.rotateY(-45);
                } else if (event.getKey() == GLFW_KEY_KP_6) {
                    IsometricProjection.rotateY(45);
                }
            }

        }


    }

    @SubscribeEvent
    public void onMouseScrollInput(InputEvent.MouseScrollEvent event) {
        if (IsometricProjection.isometric) {
            IsometricProjection.zoom(event.getScrollDelta());
        }
    }

    @SubscribeEvent
    public void onTickEvents(TickEvent.RenderTickEvent event){
        if(IsometricProjection.isometric){
            System.out.println("test");
        }
    }
}
