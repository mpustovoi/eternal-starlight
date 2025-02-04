package cn.leolezury.eternalstarlight.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.SnowyDirtBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.LightEngine;

public abstract class ESSpreadingSnowyDirtBlock extends SnowyDirtBlock {
	protected final Block spreadsOn;

	protected ESSpreadingSnowyDirtBlock(Block spreadsOn, BlockBehaviour.Properties properties) {
		super(properties);
		this.spreadsOn = spreadsOn;
	}

	private static boolean canBeGrass(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
		BlockPos blockPos2 = blockPos.above();
		BlockState blockState2 = levelReader.getBlockState(blockPos2);
		if (blockState2.is(Blocks.SNOW) && blockState2.getValue(SnowLayerBlock.LAYERS) == 1) {
			return true;
		} else if (blockState2.getFluidState().getAmount() == 8) {
			return false;
		} else {
			int i = LightEngine.getLightBlockInto(blockState, blockState2, Direction.UP, blockState2.getLightBlock());
			return i < 15;
		}
	}

	private static boolean canPropagate(BlockState state, LevelReader levelReader, BlockPos pos) {
		BlockPos blockpos = pos.above();
		return canBeGrass(state, levelReader, pos) && !levelReader.getFluidState(blockpos).is(FluidTags.WATER);
	}

	@Override
	public void randomTick(BlockState state, ServerLevel serverLevel, BlockPos pos, RandomSource randomSource) {
		if (!canBeGrass(state, serverLevel, pos)) {
			serverLevel.setBlockAndUpdate(pos, spreadsOn.defaultBlockState());
		} else {
			if (serverLevel.getMaxLocalRawBrightness(pos.above()) >= 9) {
				BlockState blockstate = this.defaultBlockState();

				for (int i = 0; i < 4; ++i) {
					BlockPos blockpos = pos.offset(randomSource.nextInt(3) - 1, randomSource.nextInt(5) - 3, randomSource.nextInt(3) - 1);
					if (serverLevel.getBlockState(blockpos).is(spreadsOn) && canPropagate(blockstate, serverLevel, blockpos)) {
						serverLevel.setBlockAndUpdate(blockpos, blockstate.setValue(SNOWY, serverLevel.getBlockState(blockpos.above()).is(Blocks.SNOW)));
					}
				}
			}

		}
	}
}
