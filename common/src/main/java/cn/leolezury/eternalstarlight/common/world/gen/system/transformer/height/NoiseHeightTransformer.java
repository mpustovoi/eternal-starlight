package cn.leolezury.eternalstarlight.common.world.gen.system.transformer.height;

import cn.leolezury.eternalstarlight.common.registry.ESDataTransformerTypes;
import cn.leolezury.eternalstarlight.common.world.gen.system.BiomeData;
import cn.leolezury.eternalstarlight.common.world.gen.system.WorldGenProvider;
import cn.leolezury.eternalstarlight.common.world.gen.system.transformer.DataTransformerType;
import cn.leolezury.eternalstarlight.common.world.gen.system.transformer.SkippingIterationTransformer;
import com.mojang.serialization.MapCodec;

import java.util.Random;

public class NoiseHeightTransformer extends SkippingIterationTransformer {
	public static final MapCodec<NoiseHeightTransformer> CODEC = MapCodec.unit(NoiseHeightTransformer::new);

	@Override
	public int transform(int[][] original, int[][] related, WorldGenProvider provider, Random random, int x, int z, int areaX, int areaZ, int size) {
		BiomeData data = provider.getBiomeDataById(related[x][z]);
		int variance = data.variance();
		int height = original[x][z];
		int worldX = getWorldCoord(x, areaX, size);
		int worldZ = getWorldCoord(z, areaZ, size);
		if (variance > 0) {
			height += (int) ((0.95 * provider.noises[0].getValue(worldX * 0.004, worldZ * 0.004, false) + 0.05 * provider.noises[1].getValue(worldX * 0.04, worldZ * 0.04, true)) * (double) variance);
		}
		return height;
	}

	@Override
	public DataTransformerType<?> type() {
		return ESDataTransformerTypes.NOISE_HEIGHT.get();
	}
}
