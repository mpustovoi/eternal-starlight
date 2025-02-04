package cn.leolezury.eternalstarlight.common.block;

import cn.leolezury.eternalstarlight.common.handler.CommonHandlers;
import cn.leolezury.eternalstarlight.common.util.ESEntityUtil;
import cn.leolezury.eternalstarlight.common.util.ESTags;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

public class AbyssalFireBlock extends BaseFireBlock implements SimpleWaterloggedBlock {
	public static final MapCodec<AbyssalFireBlock> CODEC = simpleCodec(AbyssalFireBlock::new);
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public AbyssalFireBlock(Properties properties) {
		super(properties, 3.0F);
		this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, false));
	}

	@Override
	protected MapCodec<AbyssalFireBlock> codec() {
		return CODEC;
	}

	@Override
	protected boolean canBurn(BlockState blockState) {
		return true;
	}

	@Override
	public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
		return canSurviveOnBlock(levelReader.getBlockState(blockPos.below()));
	}

	public static boolean canSurviveOnBlock(BlockState blockState) {
		return blockState.is(ESTags.Blocks.ABYSSAL_FIRE_SURVIVES_ON);
	}

	@Override
	protected BlockState updateShape(BlockState blockState, LevelReader levelReader, ScheduledTickAccess scheduledTickAccess, BlockPos blockPos, Direction direction, BlockPos blockPos2, BlockState blockState2, RandomSource randomSource) {
		if (this.canSurvive(blockState, levelReader, blockPos)) {
			return blockState;
		}
		return Blocks.AIR.defaultBlockState();
	}

	@Override
	public FluidState getFluidState(BlockState blockState) {
		return blockState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(WATERLOGGED);
	}

	@Override
	public void entityInside(BlockState blockState, Level level, BlockPos blockPos, Entity entity) {
		if (!entity.getType().is(ESTags.EntityTypes.ABYSSAL_FIRE_IMMUNE) && entity.tickCount % 30 == 0) {
			entity.hurt(level.damageSources().inFire(), 3.0F);
		}
		ESEntityUtil.getPersistentData(entity).putInt(CommonHandlers.TAG_IN_ABYSSAL_FIRE_TICKS, 5);
	}
}
