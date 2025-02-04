package cn.leolezury.eternalstarlight.common.block.fluid;

import cn.leolezury.eternalstarlight.common.EternalStarlight;
import cn.leolezury.eternalstarlight.common.registry.ESBlocks;
import cn.leolezury.eternalstarlight.common.registry.ESFluids;
import cn.leolezury.eternalstarlight.common.registry.ESItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

public abstract class EtherFluid extends FlowingFluid {
	public static final ResourceLocation ARMOR_MODIFIER_ID = EternalStarlight.id("armor.ether");

	public static AttributeModifier armorModifier(float amount) {
		return new AttributeModifier(ARMOR_MODIFIER_ID, amount, AttributeModifier.Operation.ADD_VALUE);
	}

	@Override
	public Fluid getFlowing() {
		return ESFluids.ETHER_FLOWING.get();
	}

	@Override
	public Fluid getSource() {
		return ESFluids.ETHER_STILL.get();
	}

	@Override
	protected boolean canConvertToSource(ServerLevel serverLevel) {
		return true;
	}

	@Override
	protected void beforeDestroyingBlock(LevelAccessor levelAccessor, BlockPos blockPos, BlockState blockState) {
		final BlockEntity blockEntity = blockState.hasBlockEntity() ? levelAccessor.getBlockEntity(blockPos) : null;
		Block.dropResources(blockState, levelAccessor, blockPos, blockEntity);
	}

	@Override
	protected int getSlopeFindDistance(LevelReader levelReader) {
		return 4;
	}

	@Override
	protected int getDropOff(LevelReader levelReader) {
		return 1;
	}

	@Override
	public Item getBucket() {
		return ESItems.ETHER_BUCKET.get();
	}

	@Override
	protected boolean canBeReplacedWith(FluidState fluidState, BlockGetter blockGetter, BlockPos blockPos, Fluid fluid, Direction direction) {
		return direction == Direction.DOWN && !fluidState.is(FluidTags.WATER);
	}

	@Override
	public int getTickDelay(LevelReader levelReader) {
		return 5;
	}

	@Override
	protected float getExplosionResistance() {
		return 100;
	}

	@Override
	protected BlockState createLegacyBlock(FluidState fluidState) {
		return ESBlocks.ETHER.get().defaultBlockState().setValue(BlockStateProperties.LEVEL, getLegacyLevel(fluidState));
	}

	@Override
	public boolean isSame(Fluid fluid) {
		return fluid == ESFluids.ETHER_STILL.get() || fluid == ESFluids.ETHER_FLOWING.get();
	}

	@Override
	protected void spreadTo(LevelAccessor levelAccessor, BlockPos blockPos, BlockState blockState, Direction direction, FluidState fluidState) {
		if (!blockState.getFluidState().isEmpty() && !isSame(blockState.getFluidState().getType())) {
			if (blockState.getBlock() instanceof LiquidBlock) {
				levelAccessor.setBlock(blockPos, ESBlocks.THIOQUARTZ_BLOCK.get().defaultBlockState(), 3);
			}
			levelAccessor.levelEvent(1501, blockPos, 0);
			return;
		}

		super.spreadTo(levelAccessor, blockPos, blockState, direction, fluidState);
	}

	public static class Flowing extends EtherFluid {
		@Override
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			builder.add(LEVEL);
			super.createFluidStateDefinition(builder);
		}

		@Override
		public boolean isSource(FluidState fluidState) {
			return false;
		}

		@Override
		public int getAmount(FluidState fluidState) {
			return fluidState.getValue(LEVEL);
		}
	}

	public static class Still extends EtherFluid {
		@Override
		public boolean isSource(FluidState fluidState) {
			return true;
		}

		@Override
		public int getAmount(FluidState fluidState) {
			return 8;
		}
	}
}
