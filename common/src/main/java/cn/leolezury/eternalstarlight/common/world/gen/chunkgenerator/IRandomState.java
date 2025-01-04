package cn.leolezury.eternalstarlight.common.world.gen.chunkgenerator;

import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.SurfaceSystem;

public interface IRandomState extends Cloneable {

	void setSurfaceSystem(SurfaceSystem surfaceSystem);

	RandomState clone();

}
