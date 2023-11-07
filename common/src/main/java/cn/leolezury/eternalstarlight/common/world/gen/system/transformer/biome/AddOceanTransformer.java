package cn.leolezury.eternalstarlight.common.world.gen.system.transformer.biome;

import cn.leolezury.eternalstarlight.common.world.gen.system.provider.AbstractWorldGenProvider;
import cn.leolezury.eternalstarlight.common.world.gen.system.transformer.biome.interfaces.NoiseDataTransformer;
import net.minecraft.world.level.levelgen.synth.PerlinSimplexNoise;

import java.util.Random;

public class AddOceanTransformer implements NoiseDataTransformer {
    private final int ocean;

    public AddOceanTransformer(int ocean) {
        this.ocean = ocean;
    }

    @Override
    public int transform(AbstractWorldGenProvider provider, Random random, int original, int worldX, int worldZ, PerlinSimplexNoise noise) {
        return noise.getValue(worldX * 0.1, worldZ * 0.1, true) > 0.3 ? this.ocean : original;
    }
}
