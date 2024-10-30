package cn.leolezury.eternalstarlight.common.util;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.joml.Matrix4f;

import java.util.function.Function;

@Environment(EnvType.CLIENT)
public class ESGuiUtil {
	// from GuiGraphics, changed int -> float
	public static void blit(GuiGraphics graphics, Function<ResourceLocation, RenderType> function, ResourceLocation resourceLocation, float x, float y, float width, float height, float texWidth, float texHeight, int color) {
		innerBlit(graphics, function, resourceLocation, x, x + width, y, y + height, width / texWidth, height / texHeight, color);
	}

	private static void innerBlit(GuiGraphics graphics, Function<ResourceLocation, RenderType> function, ResourceLocation resourceLocation, float x, float xTo, float y, float yTo, float u, float v, int color) {
		RenderType renderType = function.apply(resourceLocation);
		Matrix4f matrix4f = graphics.pose().last().pose();
		VertexConsumer vertexConsumer = graphics.bufferSource.getBuffer(renderType);
		vertexConsumer.addVertex(matrix4f, x, y, 0).setUv(0, 0).setColor(color);
		vertexConsumer.addVertex(matrix4f, x, yTo, 0).setUv(0, v).setColor(color);
		vertexConsumer.addVertex(matrix4f, xTo, yTo, 0).setUv(u, v).setColor(color);
		vertexConsumer.addVertex(matrix4f, xTo, y, 0).setUv(u, 0).setColor(color);
	}
}
