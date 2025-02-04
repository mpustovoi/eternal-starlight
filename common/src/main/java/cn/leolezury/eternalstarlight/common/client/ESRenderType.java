package cn.leolezury.eternalstarlight.common.client;

import cn.leolezury.eternalstarlight.common.EternalStarlight;
import cn.leolezury.eternalstarlight.common.client.shader.ESShaders;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.Util;
import net.minecraft.client.renderer.CoreShaders;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.TriState;

import java.util.function.Function;

@Environment(EnvType.CLIENT)
public abstract class ESRenderType extends RenderType {
	public static final RenderType GUI_CREST_SELECTION = create(EternalStarlight.ID + ":gui_crest_selection", DefaultVertexFormat.POSITION_COLOR, VertexFormat.Mode.QUADS, SMALL_BUFFER_SIZE, true, true, RenderType.CompositeState.builder()
		.setShaderState(new ShaderStateShard(ESShaders.RENDERTYPE_GUI_CREST_SELECTION))
		.setTransparencyState(TRANSLUCENT_TRANSPARENCY)
		.setDepthTestState(LEQUAL_DEPTH_TEST)
		.createCompositeState(false));

	public static final RenderType PORTAL = create(EternalStarlight.ID + ":starlight_portal", DefaultVertexFormat.BLOCK, VertexFormat.Mode.QUADS, TRANSIENT_BUFFER_SIZE, true, true, RenderType.CompositeState.builder()
		.setShaderState(new ShaderStateShard(ESShaders.RENDERTYPE_STARLIGHT_PORTAL))
		.setTextureState(NO_TEXTURE)
		.setTransparencyState(TRANSLUCENT_TRANSPARENCY)
		.setCullState(NO_CULL)
		.setLightmapState(LIGHTMAP)
		.setOverlayState(OVERLAY)
		.createCompositeState(true));

	public static final RenderType ECLIPSE = create(EternalStarlight.ID + ":eclipse", DefaultVertexFormat.BLOCK, VertexFormat.Mode.QUADS, TRANSIENT_BUFFER_SIZE, true, true, RenderType.CompositeState.builder()
		.setShaderState(new ShaderStateShard(ESShaders.RENDERTYPE_ECLIPSE))
		.setTextureState(NO_TEXTURE)
		.setTransparencyState(LIGHTNING_TRANSPARENCY)
		.setCullState(NO_CULL)
		.setLightmapState(LIGHTMAP)
		.setOverlayState(OVERLAY)
		.createCompositeState(true));

	public static final RenderType PARTICLE = create(EternalStarlight.ID + ":particle", DefaultVertexFormat.PARTICLE, VertexFormat.Mode.QUADS, TRANSIENT_BUFFER_SIZE, true, true, RenderType.CompositeState.builder()
		.setShaderState(new ShaderStateShard(CoreShaders.PARTICLE))
		.setTextureState(new TextureStateShard(TextureAtlas.LOCATION_PARTICLES, TriState.FALSE, false))
		.setTransparencyState(TRANSLUCENT_TRANSPARENCY)
		.setCullState(NO_CULL)
		.setLightmapState(LIGHTMAP)
		.setOverlayState(OVERLAY)
		.setWriteMaskState(COLOR_WRITE)
		.createCompositeState(true));

	public static final RenderType GLOW_PARTICLE = create(EternalStarlight.ID + ":glow_particle", DefaultVertexFormat.PARTICLE, VertexFormat.Mode.QUADS, TRANSIENT_BUFFER_SIZE, true, true, RenderType.CompositeState.builder()
		.setShaderState(new ShaderStateShard(CoreShaders.PARTICLE))
		.setTextureState(new TextureStateShard(TextureAtlas.LOCATION_PARTICLES, TriState.FALSE, false))
		.setTransparencyState(LIGHTNING_TRANSPARENCY)
		.setCullState(NO_CULL)
		.setLightmapState(LIGHTMAP)
		.setOverlayState(OVERLAY)
		.setWriteMaskState(COLOR_WRITE)
		.createCompositeState(true));

	public static final Function<ResourceLocation, RenderType> TRANSLUCENT_GLOW = Util.memoize(location ->
		create(EternalStarlight.ID + ":entity_translucent_glow", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, TRANSIENT_BUFFER_SIZE, true, true, RenderType.CompositeState.builder()
			.setShaderState(RENDERTYPE_ENTITY_TRANSLUCENT_EMISSIVE_SHADER)
			.setTextureState(new RenderStateShard.TextureStateShard(location, TriState.FALSE, false))
			.setTransparencyState(LIGHTNING_TRANSPARENCY)
			.setCullState(NO_CULL)
			.setWriteMaskState(COLOR_WRITE)
			.setOverlayState(OVERLAY)
			.createCompositeState(true)));

	public static final Function<ResourceLocation, RenderType> TRANSLUCENT_NO_DEPTH = Util.memoize(location ->
		create(EternalStarlight.ID + ":entity_translucent_no_depth", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, TRANSIENT_BUFFER_SIZE, true, true, RenderType.CompositeState.builder()
			.setShaderState(RENDERTYPE_ENTITY_TRANSLUCENT_EMISSIVE_SHADER)
			.setTextureState(new RenderStateShard.TextureStateShard(location, TriState.FALSE, false))
			.setTransparencyState(TRANSLUCENT_TRANSPARENCY)
			.setCullState(NO_CULL)
			.setWriteMaskState(COLOR_WRITE)
			.setOverlayState(OVERLAY)
			.createCompositeState(true)));

	public static final Function<ResourceLocation, RenderType> ENTITY_GLOW = Util.memoize(location ->
		create(EternalStarlight.ID + ":entity_glow", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 256, true, true, RenderType.CompositeState.builder()
			.setTextureState(new RenderStateShard.TextureStateShard(location, TriState.FALSE, false))
			.setShaderState(RENDERTYPE_BEACON_BEAM_SHADER)
			.setTransparencyState(TRANSLUCENT_TRANSPARENCY)
			.setCullState(NO_CULL)
			.setOverlayState(OVERLAY)
			.setWriteMaskState(COLOR_WRITE)
			.createCompositeState(false)));

	public ESRenderType(String string, VertexFormat vertexFormat, VertexFormat.Mode mode, int bufferSize, boolean affectsCrumbling, boolean sortOnUpload, Runnable setupState, Runnable clearState) {
		super(string, vertexFormat, mode, bufferSize, affectsCrumbling, sortOnUpload, setupState, clearState);
	}

	public static RenderType entityTranslucentGlow(ResourceLocation location) {
		return TRANSLUCENT_GLOW.apply(location);
	}

	public static RenderType entityTranslucentNoDepth(ResourceLocation location) {
		return TRANSLUCENT_NO_DEPTH.apply(location);
	}

	public static RenderType entityGlow(ResourceLocation location) {
		return ENTITY_GLOW.apply(location);
	}
}
