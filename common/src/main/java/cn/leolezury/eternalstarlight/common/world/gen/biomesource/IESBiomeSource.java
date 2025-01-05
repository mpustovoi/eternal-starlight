package cn.leolezury.eternalstarlight.common.world.gen.biomesource;

import cn.leolezury.eternalstarlight.common.world.gen.system.BiomeData;

public interface IESBiomeSource {
	BiomeData getBiomeData(int x, int z);

	int getBiome(int x, int z);

	int getHeight(int x, int z);
}
