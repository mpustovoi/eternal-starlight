package cn.leolezury.eternalstarlight.neoforge.client;

import cn.leolezury.eternalstarlight.common.client.ESDimensionSpecialEffects;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import org.joml.Matrix4f;

public class ForgeDimensionSpecialEffects extends ESDimensionSpecialEffects {
	public ForgeDimensionSpecialEffects(float cloudHeight, boolean placebo, SkyType fogType, boolean brightenLightMap, boolean entityLightingBottomsLit) {
		super(cloudHeight, placebo, fogType, brightenLightMap, entityLightingBottomsLit);
	}

	@Override
	public boolean renderSky(ClientLevel level, int ticks, float partialTick, Matrix4f modelViewMatrix, Camera camera, Matrix4f projectionMatrix, Runnable setupFog) {
		return super.renderSky(level, ticks, partialTick, modelViewMatrix, camera, projectionMatrix, setupFog);
	}

	@Override
	public boolean renderSky(ClientLevel level, int ticks, float partialTick, Matrix4f modelViewMatrix, Camera camera, Matrix4f projectionMatrix, boolean isFoggy, Runnable setupFog) {
		return ESDimensionSpecialEffects.doRenderSky(level, partialTick, modelViewMatrix, camera, projectionMatrix, isFoggy, setupFog);
	}
}
