package net.mokona.isometriccam.utils;

import org.joml.Matrix4f;
import net.minecraft.client.Minecraft;

public class IsometricProjection {

    private static final Minecraft MC = Minecraft.getInstance();
    public static boolean isometric = false;

    public static float isometricViewLength = 75;
    public static float xRot = 45;
    public static float yRot = 135;

    public static Matrix4f getIsometricProjection() {
        int w = MC.getWindow().getWidth();
        int h = MC.getWindow().getHeight();

        float wView = (isometricViewLength / h) * w;

        float near = -2000;
        float far = 2000;

        float left = -wView / 2;
        float right = wView / 2;

        float top = isometricViewLength / 2;
        float bottom = -isometricViewLength / 2;

        return new Matrix4f(2.0f / (right - left), 0, 0, -(right + left) / (right - left),
                0, 2.0f / (top - bottom), 0, -(top + bottom) / (top - bottom),
                0, 0, -2.0f / (far - near), -(far + near) / (far - near),
                0, 0, 0, 1);
    }
}
