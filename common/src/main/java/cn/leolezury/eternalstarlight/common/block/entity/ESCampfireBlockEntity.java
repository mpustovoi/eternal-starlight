package cn.leolezury.eternalstarlight.common.block.entity;

import cn.leolezury.eternalstarlight.common.registry.ESBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.item.crafting.CampfireCookingRecipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.CampfireBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ESCampfireBlockEntity extends CampfireBlockEntity {
	public ESCampfireBlockEntity(BlockPos blockPos, BlockState blockState) {
		super(blockPos, blockState);
	}

	@Override
	public boolean isValidBlockState(BlockState blockState) {
		return this.getType().isValid(blockState);
	}

	public static void serverTick(ServerLevel level, BlockPos blockPos, BlockState blockState, CampfireBlockEntity campfireBlockEntity, RecipeManager.CachedCheck<SingleRecipeInput, CampfireCookingRecipe> cachedCheck) {
		if (blockState.getValue(BlockStateProperties.LIT)) {
			cookTick(level, blockPos, blockState, campfireBlockEntity, cachedCheck);
			AABB box = AABB.unitCubeFromLowerCorner(Vec3.atLowerCornerOf(blockPos)).inflate(10);
			for (LivingEntity living : level.getEntitiesOfClass(LivingEntity.class, box)) {
				if (!(living instanceof Enemy) && !living.hasEffect(MobEffects.REGENERATION)) {
					living.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100));
				}
			}
		} else {
			cooldownTick(level, blockPos, blockState, campfireBlockEntity);
		}
	}

	@Override
	public BlockEntityType<?> getType() {
		return ESBlockEntities.CAMPFIRE.get();
	}
}
