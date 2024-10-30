package cn.leolezury.eternalstarlight.common.client.renderer.entity;

import cn.leolezury.eternalstarlight.common.client.renderer.entity.state.AethersentMeteorRenderState;
import cn.leolezury.eternalstarlight.common.entity.projectile.AethersentMeteor;
import cn.leolezury.eternalstarlight.common.platform.ESPlatform;
import cn.leolezury.eternalstarlight.common.registry.ESBlocks;
import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;

@Environment(EnvType.CLIENT)
public class AethersentMeteorRenderer extends EntityRenderer<AethersentMeteor, AethersentMeteorRenderState> {
	private final BlockRenderDispatcher dispatcher;

	public AethersentMeteorRenderer(EntityRendererProvider.Context context) {
		super(context);
		this.shadowRadius = 0.5F;
		this.dispatcher = context.getBlockRenderDispatcher();
	}

	@Override
	public AethersentMeteorRenderState createRenderState() {
		return new AethersentMeteorRenderState();
	}

	@Override
	public void extractRenderState(AethersentMeteor entity, AethersentMeteorRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.size = entity.getSize();
		state.level = entity.level();
	}

	@Override
	public void render(AethersentMeteorRenderState state, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {
		BlockState blockstate = ESBlocks.RAW_AETHERSENT_BLOCK.get().defaultBlockState();
		if (blockstate.getRenderShape() == RenderShape.MODEL) {
			stack.pushPose();
			float scale = state.size / 10f;
			stack.translate(-0.5D * scale, 0.0D, -0.5D * scale);
			stack.scale(scale, scale, scale);
			BlockPos pos = BlockPos.containing(state.x, state.y, state.z);
			ESPlatform.INSTANCE.renderBlock(dispatcher, stack, bufferSource, state.level, blockstate, pos, blockstate.getSeed(pos));
			stack.popPose();
			super.render(state, stack, bufferSource, packedLight);
		}
	}
}
