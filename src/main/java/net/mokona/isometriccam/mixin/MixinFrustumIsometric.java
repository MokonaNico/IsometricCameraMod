package net.mokona.isometriccam.mixin;

import net.minecraft.client.renderer.culling.Frustum;
import net.mokona.isometriccam.utils.IsometricProjection;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Frustum.class)
public class MixinFrustumIsometric {
    // avoid dead loop
    @Inject(
            method = "offsetToFullyIncludeCameraCube", at = @At("HEAD"), cancellable = true
    )
    private void onOffsetToFullyIncludeCameraCube(int i, CallbackInfoReturnable<Frustum> cir) {
        if (IsometricProjection.isometric) {
            cir.setReturnValue((Frustum) (Object) this);
        }
    }
}