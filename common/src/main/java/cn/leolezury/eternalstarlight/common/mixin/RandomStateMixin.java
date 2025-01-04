package cn.leolezury.eternalstarlight.common.mixin;

import cn.leolezury.eternalstarlight.common.world.gen.chunkgenerator.IRandomState;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.SurfaceSystem;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(RandomState.class)
public class RandomStateMixin implements IRandomState {

	@Mutable
	@Shadow
	@Final
	private SurfaceSystem surfaceSystem;

	@Unique
	@Override
	public void setSurfaceSystem(SurfaceSystem surfaceSystem) {
		this.surfaceSystem = surfaceSystem;
	}

	@Override
	public RandomState clone() {
		try {
			return (RandomState) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

}
