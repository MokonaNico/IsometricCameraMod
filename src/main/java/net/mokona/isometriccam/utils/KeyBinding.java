package net.mokona.isometriccam.utils;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mokona.isometriccam.IsometricCamMod;
import org.lwjgl.glfw.GLFW;


public class KeyBinding {

    @Mod.EventBusSubscriber(modid = IsometricCamMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event){
            event.register(KeyBinding.ENABLE_ISO_KEY);
            event.register(KeyBinding.ZOOM_IN_KEY);
            event.register(KeyBinding.ZOOM_OUT_KEY);
            event.register(KeyBinding.VERTICAL_ROTATION_UP_KEY);
            event.register(KeyBinding.VERTICAL_ROTATION_DOWN_KEY);
            event.register(KeyBinding.HORIZONTAL_ROTATION_LEFT_KEY);
            event.register(KeyBinding.HORIZONTAL_ROTATION_RIGHT_KEY);
        }
    }

    public static final String KEY_CATEGORY_ISOMETRIC = "key.category.isometriccam";

    public static final String KEY_ENABLE_ISO = "key.isometriccam.enable_iso";
    public static final KeyMapping ENABLE_ISO_KEY = new KeyMapping(KEY_ENABLE_ISO, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_F10, KEY_CATEGORY_ISOMETRIC);

    public static final String KEY_ZOOM_IN = "key.isometriccam.zoom_in";
    public static final KeyMapping ZOOM_IN_KEY = new KeyMapping(KEY_ZOOM_IN, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_KP_9, KEY_CATEGORY_ISOMETRIC);

    public static final String KEY_ZOOM_OUT = "key.isometriccam.zoom_out";
    public static final KeyMapping ZOOM_OUT_KEY = new KeyMapping(KEY_ZOOM_OUT, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_KP_7, KEY_CATEGORY_ISOMETRIC);

    public static final String KEY_VERTICAL_ROTATION_UP = "key.isometriccam.vertical_rotation_up";
    public static final KeyMapping VERTICAL_ROTATION_UP_KEY = new KeyMapping(KEY_VERTICAL_ROTATION_UP, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_KP_8, KEY_CATEGORY_ISOMETRIC);

    public static final String KEY_VERTICAL_ROTATION_DOWN = "key.isometriccam.vertical_rotation_down";
    public static final KeyMapping VERTICAL_ROTATION_DOWN_KEY = new KeyMapping(KEY_VERTICAL_ROTATION_DOWN, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_KP_2, KEY_CATEGORY_ISOMETRIC);

    public static final String KEY_HORIZONTAL_ROTATION_LEFT = "key.isometriccam.horizontal_rotation_left";
    public static final KeyMapping HORIZONTAL_ROTATION_LEFT_KEY = new KeyMapping(KEY_HORIZONTAL_ROTATION_LEFT, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_KP_4, KEY_CATEGORY_ISOMETRIC);

    public static final String KEY_HORIZONTAL_ROTATION_RIGHT = "key.isometriccam.horizontal_rotation_right";
    public static final KeyMapping HORIZONTAL_ROTATION_RIGHT_KEY = new KeyMapping(KEY_HORIZONTAL_ROTATION_RIGHT, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_KP_6, KEY_CATEGORY_ISOMETRIC);
}
