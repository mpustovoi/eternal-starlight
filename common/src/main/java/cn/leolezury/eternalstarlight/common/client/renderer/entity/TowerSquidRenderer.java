package cn.leolezury.eternalstarlight.common.client.renderer.entity;

import cn.leolezury.eternalstarlight.common.EternalStarlight;
import cn.leolezury.eternalstarlight.common.client.model.entity.TowerSquidModel;
import cn.leolezury.eternalstarlight.common.entity.living.animal.TowerSquid;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@Environment(EnvType.CLIENT)
public class TowerSquidRenderer<T extends TowerSquid> extends MobRenderer<T, TowerSquidModel<T>> {
	private static final ResourceLocation ENTITY_TEXTURE = EternalStarlight.id("textures/entity/tower_squid.png");

	public TowerSquidRenderer(EntityRendererProvider.Context context) {
		super(context, new TowerSquidModel<>(context.bakeLayer(TowerSquidModel.LAYER_LOCATION)), 0.2f);
	}

	@Override
	public ResourceLocation getTextureLocation(T entity) {
		return ENTITY_TEXTURE;
	}
}
