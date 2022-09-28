package net.mokona.isometriccam.events;

import net.minecraft.client.Minecraft;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RenderLevelLastEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.mokona.isometriccam.utils.IsometricProjection;

import static org.lwjgl.glfw.GLFW.*;

public class IsometricViewHandler {
    public static final Minecraft MC = Minecraft.getInstance();

    private float zoomTarget = IsometricProjection.isometricViewLength;
    private float xRotTarget = IsometricProjection.xRot;
    private float yRotTarget = IsometricProjection.yRot;

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (event.getAction() == GLFW_PRESS) {
            if (event.getKey() == GLFW_KEY_F10) {
                IsometricProjection.isometric = !IsometricProjection.isometric;
                MC.smartCull = !IsometricProjection.isometric;
            }
            if (IsometricProjection.isometric) {
                if (event.getKey() == GLFW_KEY_KP_8) {
                    xRotTarget += 5;
                } else if (event.getKey() == GLFW_KEY_KP_2) {
                    xRotTarget -= 5;
                } else if (event.getKey() == GLFW_KEY_KP_7) {
                    zoom(5);
                } else if (event.getKey() == GLFW_KEY_KP_9) {
                    zoom(-5);
                } else if (event.getKey() == GLFW_KEY_KP_4) {
                    yRotTarget += 45;
                } else if (event.getKey() == GLFW_KEY_KP_6) {
                    yRotTarget -= 45;
                }
            }
        }
    }

    @SubscribeEvent
    public void onMouseScrollInput(InputEvent.MouseScrollEvent event) {
        if (IsometricProjection.isometric) {
            zoom(-event.getScrollDelta());
        }
    }

    @SubscribeEvent
    public void onRenderLevelLastEvent(RenderLevelLastEvent event){
        if(IsometricProjection.isometric){
            if(Math.abs(IsometricProjection.isometricViewLength - zoomTarget) >= 0.01){
                IsometricProjection.isometricViewLength = lerp(IsometricProjection.isometricViewLength, zoomTarget,0.1f);
                event.getLevelRenderer().needsUpdate();
            }
            if(Math.abs(IsometricProjection.xRot - xRotTarget) >= 0.01){
                IsometricProjection.xRot = lerp(IsometricProjection.xRot, xRotTarget,0.1f);
            }
            if(Math.abs(IsometricProjection.yRot - yRotTarget) >= 0.01){
                IsometricProjection.yRot = lerp(IsometricProjection.yRot, yRotTarget,0.1f);
            }

        }
    }

    public static float lerp(float position, float target, float amount)
    {
        float d = (target - position) * amount;
        return position + d;
    }

    private void zoom(double amount){
        double v = amount * 2;
        if(zoomTarget + v >= 20){
            zoomTarget += v;
        }
        System.out.println(zoomTarget);
    }
}
