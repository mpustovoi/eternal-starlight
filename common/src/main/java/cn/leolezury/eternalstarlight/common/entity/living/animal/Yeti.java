package cn.leolezury.eternalstarlight.common.entity.living.animal;

import cn.leolezury.eternalstarlight.common.config.ESConfig;
import cn.leolezury.eternalstarlight.common.platform.ESPlatform;
import cn.leolezury.eternalstarlight.common.registry.ESEntities;
import cn.leolezury.eternalstarlight.common.registry.ESItems;
import com.mojang.serialization.Dynamic;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class Yeti extends Animal {
	private static final String TAG_FUR = "fur";
	private static final String TAG_FUR_GROWTH_TICKS = "fur_growth_ticks";

	protected static final EntityDataAccessor<Integer> ROLL_STATE = SynchedEntityData.defineId(Yeti.class, EntityDataSerializers.INT);
	protected static final EntityDataAccessor<Boolean> HAS_FUR = SynchedEntityData.defineId(Yeti.class, EntityDataSerializers.BOOLEAN);

	public int getRollState() {
		return this.getEntityData().get(ROLL_STATE);
	}

	public void setRollState(int rollState) {
		this.getEntityData().set(ROLL_STATE, rollState);
	}

	public boolean hasFur() {
		return this.getEntityData().get(HAS_FUR);
	}

	public void setHasFur(boolean hasFur) {
		this.getEntityData().set(HAS_FUR, hasFur);
	}

	public AnimationState idleAnimationState = new AnimationState();
	public AnimationState rollStartAnimationState = new AnimationState();
	public AnimationState rollAnimationState = new AnimationState();
	public AnimationState rollEndAnimationState = new AnimationState();
	private int rollTicks = 0;
	private int furGrowthTicks = 0;

	public void setRollTicks(int rollTicks) {
		this.rollTicks = rollTicks;
	}

	public int getRollTicks() {
		return rollTicks;
	}

	private int rollCooldown = 200;

	public void setRollCooldown(int rollCooldown) {
		this.rollCooldown = rollCooldown;
	}

	public int getRollCooldown() {
		return rollCooldown;
	}

	public float rollAngle, prevRollAngle;

	public Yeti(EntityType<? extends Animal> entityType, Level level) {
		super(entityType, level);
		this.getNavigation().setCanFloat(true);
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes()
			.add(Attributes.MAX_HEALTH, ESConfig.INSTANCE.mobsConfig.yeti.maxHealth())
			.add(Attributes.ARMOR, ESConfig.INSTANCE.mobsConfig.yeti.armor())
			.add(Attributes.MOVEMENT_SPEED, 0.25D);
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(ROLL_STATE, 0)
			.define(HAS_FUR, true);
	}

	@Override
	protected Brain<?> makeBrain(Dynamic<?> dynamic) {
		return YetiAi.makeBrain(this.brainProvider().makeBrain(dynamic));
	}

	@Override
	public Brain<Yeti> getBrain() {
		return (Brain<Yeti>) super.getBrain();
	}

	@Override
	protected Brain.Provider<Yeti> brainProvider() {
		return Brain.provider(YetiAi.MEMORY_TYPES, YetiAi.SENSOR_TYPES);
	}

	@Override
	protected void customServerAiStep() {
		this.level().getProfiler().push("YetiBrain");
		this.getBrain().tick((ServerLevel) this.level(), this);
		this.level().getProfiler().popPush("YetiActivityUpdate");
		YetiAi.updateActivity(this);
		this.level().getProfiler().pop();
		super.customServerAiStep();
	}

	@Override
	public void aiStep() {
		super.aiStep();
		if (rollTicks > 0) {
			rollTicks--;
		}
		if (rollCooldown > 0) {
			rollCooldown--;
		}
		if (!level().isClientSide) {
			if (!hasFur()) {
				if (furGrowthTicks < 3600) {
					furGrowthTicks++;
				}
				if (furGrowthTicks >= 3600) {
					setHasFur(true);
					furGrowthTicks = 0;
				}
			}
		} else {
			idleAnimationState.startIfStopped(tickCount);
			prevRollAngle = rollAngle;
			rollAngle += (float) (position().subtract(new Vec3(xOld, yOld, zOld)).length() / (3f / 260f));
			rollAngle = Mth.wrapDegrees(rollAngle);
		}
	}

	public void stopAllAnimStates() {
		rollStartAnimationState.stop();
		rollAnimationState.stop();
		rollEndAnimationState.stop();
	}

	@Override
	public void onSyncedDataUpdated(EntityDataAccessor<?> accessor) {
		super.onSyncedDataUpdated(accessor);
		if (accessor.equals(ROLL_STATE) && getRollState() != 0) {
			stopAllAnimStates();
			switch (getRollState()) {
				case 1 -> {
					rollAngle = 0;
					prevRollAngle = 0;
					rollStartAnimationState.start(tickCount);
				}
				case 2 -> rollAnimationState.start(tickCount);
				case 3 -> rollEndAnimationState.start(tickCount);
			}
		}
	}

	@Override
	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack itemStack = player.getItemInHand(hand);
		if (ESPlatform.INSTANCE.isShears(itemStack) && hasFur()) {
			if (!level().isClientSide) {
				this.level().playSound(null, this, SoundEvents.SHEEP_SHEAR, SoundSource.PLAYERS, 1.0F, 1.0F);
				this.gameEvent(GameEvent.SHEAR, player);
				itemStack.hurtAndBreak(1, player, getSlotForHand(hand));

				int i = 1 + getRandom().nextInt(3);
				for (int j = 0; j < i; ++j) {
					ItemEntity itemEntity = this.spawnAtLocation(ESItems.WHITE_YETI_FUR.get(), 1);
					if (itemEntity != null) {
						itemEntity.setDeltaMovement(itemEntity.getDeltaMovement().add((getRandom().nextFloat() - getRandom().nextFloat()) * 0.1F, getRandom().nextFloat() * 0.05F, (getRandom().nextFloat() - getRandom().nextFloat()) * 0.1F));
					}
				}

				furGrowthTicks = getRandom().nextInt(1200);
				setHasFur(false);
			}
			return InteractionResult.sidedSuccess(level().isClientSide);
		}
		return super.mobInteract(player, hand);
	}

	@Override
	public boolean isFood(ItemStack itemStack) {
		return YetiAi.getTemptations().test(itemStack);
	}

	@Nullable
	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
		return new Yeti(ESEntities.YETI.get(), serverLevel);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compoundTag) {
		super.addAdditionalSaveData(compoundTag);
		compoundTag.putBoolean(TAG_FUR, hasFur());
		compoundTag.putInt(TAG_FUR_GROWTH_TICKS, furGrowthTicks);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compoundTag) {
		super.readAdditionalSaveData(compoundTag);
		if (compoundTag.contains(TAG_FUR, CompoundTag.TAG_BYTE)) {
			setHasFur(compoundTag.getBoolean(TAG_FUR));
		}
		furGrowthTicks = compoundTag.getInt(TAG_FUR_GROWTH_TICKS);
	}

	public static boolean checkYetiSpawnRules(EntityType<? extends Yeti> type, LevelAccessor level, EntitySpawnReason spawnReason, BlockPos pos, RandomSource random) {
		return level.getBlockState(pos.below()).is(BlockTags.DIRT) && ESConfig.INSTANCE.mobsConfig.yeti.canSpawn();
	}
}
