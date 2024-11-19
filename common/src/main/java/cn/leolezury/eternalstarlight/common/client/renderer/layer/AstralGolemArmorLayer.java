package cn.leolezury.eternalstarlight.common.client.renderer.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EquipmentLayerRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.world.entity.EquipmentSlot;

@Environment(EnvType.CLIENT)
public class AstralGolemArmorLayer<S extends HumanoidRenderState, M extends HumanoidModel<S>, A extends HumanoidModel<S>> extends HumanoidArmorLayer<S, M, A> {
	public AstralGolemArmorLayer(RenderLayerParent<S, M> parent, A inner, A outer, EquipmentLayerRenderer renderer) {
		super(parent, inner, outer, renderer);
	}

	@Override
	public void render(PoseStack poseStack, MultiBufferSource buffer, int i, S state, float f, float g) {
		this.renderArmorPiece(
			poseStack, buffer, state.chestItem, EquipmentSlot.CHEST, i, this.getArmorModel(state, EquipmentSlot.CHEST)
		);
		this.renderArmorPiece(
			poseStack, buffer, state.headItem, EquipmentSlot.HEAD, i, this.getArmorModel(state, EquipmentSlot.HEAD)
		);
	}
}
