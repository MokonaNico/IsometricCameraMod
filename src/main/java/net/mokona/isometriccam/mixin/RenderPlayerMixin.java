package net.mokona.isometriccam.mixin;

import net.minecraft.client.CameraType;
import net.minecraft.client.Options;
import net.mokona.isometriccam.utils.IsometricProjection;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Options.class)
public class RenderPlayerMixin {
    @Inject(
            method = "getCameraType()Lnet/minecraft/client/CameraType;",
            at = @At("HEAD"),
            cancellable = true
    )
    public void onGetCameraType(CallbackInfoReturnable<CameraType> cir) {
        if(IsometricProjection.isometric){
            cir.setReturnValue(CameraType.THIRD_PERSON_BACK);
        }
    }
}
