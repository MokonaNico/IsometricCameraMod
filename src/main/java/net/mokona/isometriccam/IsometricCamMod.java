package net.mokona.isometriccam;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.mokona.isometriccam.events.IsometricViewHandler;

@Mod(IsometricCamMod.MOD_ID)
public class IsometricCamMod
{
    public static final String MOD_ID = "isometriccam";

    public IsometricCamMod()
    {
        IsometricViewHandler isometricViewHandler = new IsometricViewHandler();
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(isometricViewHandler);
    }
}
