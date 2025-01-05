package cn.leolezury.eternalstarlight.common.block;

import cn.leolezury.eternalstarlight.common.registry.ESBlocks;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class BlazingAtalphaiteBlock extends Block {
	public static final MapCodec<BlazingAtalphaiteBlock> CODEC = simpleCodec(BlazingAtalphaiteBlock::new);

	public BlazingAtalphaiteBlock(Properties properties) {
		super(properties);
	}

	@Override
	protected MapCodec<BlazingAtalphaiteBlock> codec() {
		return CODEC;
	}

	@Override
	protected ItemInteractionResult useItemOn(ItemStack itemStack, BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
		if (itemStack.is(ItemTags.PICKAXES)) {
			level.setBlockAndUpdate(blockPos, ESBlocks.ATALPHAITE_LIGHT.get().defaultBlockState());
			itemStack.hurtAndBreak(1, player, player.getEquipmentSlotForItem(itemStack));
			return ItemInteractionResult.sidedSuccess(level.isClientSide);
		}
		return super.useItemOn(itemStack, blockState, level, blockPos, player, interactionHand, blockHitResult);
	}
}
