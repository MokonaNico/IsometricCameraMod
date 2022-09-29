package net.mokona.isometriccam.mixin;

import com.mojang.math.Matrix4f;
import net.minecraft.client.renderer.GameRenderer;
import net.mokona.isometriccam.utils.IsometricProjection;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GameRenderer.class)
public class IsometricMixin {

    @Inject(
            method = "getProjectionMatrix(D)Lcom/mojang/math/Matrix4f;",
            at = @At("HEAD"),
            cancellable = true
    )
    private void onGetBasicProjectionMatrix(double pFov, CallbackInfoReturnable<Matrix4f> cir) {
        if (IsometricProjection.isometric){
            cir.setReturnValue(IsometricProjection.getIsometricProjection());
        }
    }
}
