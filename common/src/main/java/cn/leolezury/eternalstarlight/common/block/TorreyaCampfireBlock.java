package cn.leolezury.eternalstarlight.common.block;

import cn.leolezury.eternalstarlight.common.block.entity.ESCampfireBlockEntity;
import cn.leolezury.eternalstarlight.common.registry.ESBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.crafting.CampfireCookingRecipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.CampfireBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class TorreyaCampfireBlock extends CampfireBlock {
	public TorreyaCampfireBlock(boolean spawnParticles, int fireDamage, Properties properties) {
		super(spawnParticles, fireDamage, properties);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
		return new ESCampfireBlockEntity(blockPos, blockState);
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
		if (level instanceof ServerLevel serverLevel) {
			if (blockState.getValue(LIT)) {
				RecipeManager.CachedCheck<SingleRecipeInput, CampfireCookingRecipe> cachedCheck = RecipeManager.createCheck(RecipeType.CAMPFIRE_COOKING);
				return createTickerHelper(
					blockEntityType,
					ESBlockEntities.CAMPFIRE.get(),
					(level1, blockPos, state, campfireBlockEntity) -> ESCampfireBlockEntity.serverTick(serverLevel, blockPos, state, campfireBlockEntity, cachedCheck)
				);
			} else {
				return createTickerHelper(blockEntityType, BlockEntityType.CAMPFIRE, CampfireBlockEntity::cooldownTick);
			}
		} else {
			return blockState.getValue(LIT) ? createTickerHelper(blockEntityType, ESBlockEntities.CAMPFIRE.get(), ESCampfireBlockEntity::particleTick) : null;
		}
	}
}
