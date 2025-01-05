package cn.leolezury.eternalstarlight.common.world.gen.biomesource;

import cn.leolezury.eternalstarlight.common.world.gen.system.BiomeData;
import cn.leolezury.eternalstarlight.common.world.gen.system.WorldArea;
import cn.leolezury.eternalstarlight.common.world.gen.system.WorldGenProvider;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.longs.Long2ReferenceArrayMap;
import it.unimi.dsi.fastutil.longs.Long2ReferenceFunction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistryCodecs;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate;

import java.util.stream.Stream;

public class ESBiomeSource extends BiomeSource implements IESBiomeSource {
	public static final MapCodec<ESBiomeSource> CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(
		WorldGenProvider.CODEC.fieldOf("worldgen_provider").forGetter(o -> o.provider),
		RegistryCodecs.homogeneousList(Registries.BIOME).fieldOf("biomes").forGetter(o -> o.biomeHolderSet)
	).apply(instance, instance.stable(ESBiomeSource::new)));

	private final WorldGenProvider provider;
	private final HolderSet<Biome> biomeHolderSet;

	public ESBiomeSource(WorldGenProvider provider, HolderSet<Biome> biomeHolderSet) {
		this.provider = provider;
		this.biomeHolderSet = biomeHolderSet;
	}

	public void setSeed(long seed) {
		this.provider.setSeed(seed);
	}

	public void setRegistryAccess(RegistryAccess access) {
		this.provider.setRegistryAccess(access);
	}

	public void setCacheSize(int size) {
		this.provider.setCacheSize(size);
	}

	@Override
	protected MapCodec<? extends BiomeSource> codec() {
		return CODEC;
	}

	@Override
	protected Stream<Holder<Biome>> collectPossibleBiomes() {
		return biomeHolderSet.stream();
	}

	@Override
	public BiomeData getBiomeData(int x, int z) {
		return this.provider.getWorldArea(x, z).getBiomeData(x, z);
	}

	@Override
	public int getBiome(int x, int z) {
		return this.provider.getWorldArea(x, z).getBiome(x, z);
	}

	@Override
	public int getHeight(int x, int z) {
		return this.provider.getWorldArea(x, z).getHeight(x, z);
	}

	@Override
	public Holder<Biome> getNoiseBiome(int x, int y, int z, Climate.Sampler sampler) {
		return provider.getBiomeDataById(getBiome(x * 4, z * 4)).biome();
	}

	public Cached cache() {
		return new Cached();
	}

	/**
	 * Only meant to be used for a single thread
	 */
	public class Cached extends BiomeSource implements IESBiomeSource {
		private final Long2ReferenceArrayMap<WorldArea> cachedAreas = new Long2ReferenceArrayMap<>(); // using array map because it usually only contain one element
		private final Long2ReferenceFunction<WorldArea> getWorldAreaUncachedFunction = this::getWorldAreaUncached;

		private WorldArea getWorldArea(int x, int z) {
			int areaX = x >> 10;
			int areaZ = z >> 10;
			long areaPos = ChunkPos.asLong(areaX, areaZ);
			return this.cachedAreas.computeIfAbsent(areaPos, getWorldAreaUncachedFunction);
		}

		private WorldArea getWorldAreaUncached(long pos) {
			int x = ChunkPos.getX(pos);
			int z = ChunkPos.getZ(pos);
			return ESBiomeSource.this.provider.getWorldArea(x << 10, z << 10);
		}

		@Override
		protected MapCodec<? extends BiomeSource> codec() {
			return ESBiomeSource.this.codec();
		}

		@Override
		protected Stream<Holder<Biome>> collectPossibleBiomes() {
			return ESBiomeSource.this.collectPossibleBiomes();
		}

		@Override
		public Holder<Biome> getNoiseBiome(int x, int y, int z, Climate.Sampler sampler) {
			return provider.getBiomeDataById(getBiome(x * 4, z * 4)).biome();
		}

		@Override
		public BiomeData getBiomeData(int x, int z) {
			return this.getWorldArea(x, z).getBiomeData(x, z);
		}

		@Override
		public int getBiome(int x, int z) {
			return this.getWorldArea(x, z).getBiome(x, z);
		}

		@Override
		public int getHeight(int x, int z) {
			return this.getWorldArea(x, z).getHeight(x, z);
		}
	}
}
