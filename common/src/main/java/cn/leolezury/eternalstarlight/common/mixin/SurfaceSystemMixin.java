package cn.leolezury.eternalstarlight.common.mixin;

import cn.leolezury.eternalstarlight.common.world.gen.biomesource.IESBiomeSource;
import cn.leolezury.eternalstarlight.common.world.gen.chunkgenerator.ESChunkGenerator;
import cn.leolezury.eternalstarlight.common.world.gen.chunkgenerator.StarlightSurfaceSystem;
import net.minecraft.world.level.levelgen.SurfaceSystem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(SurfaceSystem.class)
public abstract class SurfaceSystemMixin implements StarlightSurfaceSystem {
	@Unique
	private ESChunkGenerator starlightGenerator;

	@Unique
	private IESBiomeSource cachedStarlightBiomeSource;

	@Override
	public void setStarlightChunkGenerator(ESChunkGenerator generator) {
		starlightGenerator = generator;
	}

	@Override
	public void setCachedStarlightBiomeSource(IESBiomeSource biomeSource) {
		cachedStarlightBiomeSource = biomeSource;
	}

	@Override
	public ESChunkGenerator getStarlightChunkGenerator() {
		return starlightGenerator;
	}

	@Override
	public IESBiomeSource getCachedStarlightBiomeSource() {
		return cachedStarlightBiomeSource;
	}

	@Override
	public SurfaceSystem clone() {
		try {
			return (SurfaceSystem) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}
}
