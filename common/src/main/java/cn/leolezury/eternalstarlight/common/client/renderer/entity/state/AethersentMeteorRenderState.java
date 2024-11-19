package cn.leolezury.eternalstarlight.common.client.renderer.entity.state;

import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.EmptyBlockAndTintGetter;

public class AethersentMeteorRenderState extends EntityRenderState {
	public int size;
	public BlockAndTintGetter level = EmptyBlockAndTintGetter.INSTANCE;
}
