package net.mokona.isometriccam.mixin;

import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.phys.Vec3;
import net.mokona.isometriccam.events.IsometricViewHandler;
import net.mokona.isometriccam.utils.IsometricProjection;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Camera.class)
public abstract class  CameraMixin {
    @Shadow
    private float xRot;
    @Shadow
    private float yRot;
    @Shadow
    private Vec3 position;
    @Shadow
    private boolean detached;
    @Shadow
    protected void move(double pDistanceOffset, double pVerticalOffset, double pHorizontalOffset) {}
    @Shadow
    protected abstract double getMaxZoom(double pStartingDistance);

    @Inject(
            method = "setup(Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/world/entity/Entity;ZZF)V",
            at = @At("TAIL"),
            cancellable = true
    )
    private void onSetup(BlockGetter pLevel, Entity pEntity, boolean pDetached, boolean pThirdPersonReverse, float pPartialTick, CallbackInfo ci) {
        if(IsometricProjection.isometric){
            this.xRot = IsometricProjection.xRot;
            this.yRot = IsometricProjection.yRot;
        }
    }

    /*
    @ModifyVariable(
            method = "setup(Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/world/entity/Entity;ZZF)V",
            at = @At("HEAD"),
            ordinal = 2
    )
    private boolean injected(boolean x) {
        return false;
    }
    */
}
