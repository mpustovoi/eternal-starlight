package cn.leolezury.eternalstarlight.common.world.gen.chunkgenerator;

import cn.leolezury.eternalstarlight.common.world.gen.biomesource.IESBiomeSource;
import net.minecraft.world.level.levelgen.SurfaceSystem;

public interface StarlightSurfaceSystem extends Cloneable {
	void setStarlightChunkGenerator(ESChunkGenerator generator);

	void setCachedStarlightBiomeSource(IESBiomeSource biomeSource);

	ESChunkGenerator getStarlightChunkGenerator();

	IESBiomeSource getCachedStarlightBiomeSource();

	SurfaceSystem clone();
}
