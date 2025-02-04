package cn.leolezury.eternalstarlight.common.entity.misc;

import cn.leolezury.eternalstarlight.common.registry.ESEntities;
import cn.leolezury.eternalstarlight.common.registry.ESItems;
import cn.leolezury.eternalstarlight.common.registry.ESSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class EyeOfSeeking extends Entity implements ItemSupplier {
	private static final String TAG_ITEM = "item";
	private static final String TAG_SURVIVE_AFTER_DEATH = "survive_after_death";

	private static final EntityDataAccessor<ItemStack> DATA_ITEM_STACK = SynchedEntityData.defineId(EyeOfSeeking.class, EntityDataSerializers.ITEM_STACK);
	private double tx;
	private double ty;
	private double tz;
	private int life;
	private boolean surviveAfterDeath;

	public EyeOfSeeking(EntityType<? extends EyeOfSeeking> entityType, Level level) {
		super(entityType, level);
	}

	public EyeOfSeeking(Level level, double d, double e, double f) {
		this(ESEntities.EYE_OF_SEEKING.get(), level);
		this.setPos(d, e, f);
	}

	public void setItem(ItemStack itemStack) {
		if (itemStack.isEmpty()) {
			this.getEntityData().set(DATA_ITEM_STACK, this.getDefaultItem());
		} else {
			this.getEntityData().set(DATA_ITEM_STACK, itemStack.copyWithCount(1));
		}

	}

	public ItemStack getItem() {
		return this.getEntityData().get(DATA_ITEM_STACK);
	}

	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		builder.define(DATA_ITEM_STACK, this.getDefaultItem());
	}

	public boolean shouldRenderAtSqrDistance(double d) {
		double e = this.getBoundingBox().getSize() * 4.0;
		if (Double.isNaN(e)) {
			e = 4.0;
		}

		e *= 64.0;
		return d < e * e;
	}

	public void signalTo(BlockPos blockPos) {
		double d = blockPos.getX();
		int i = blockPos.getY();
		double e = blockPos.getZ();
		double f = d - this.getX();
		double g = e - this.getZ();
		double h = Math.sqrt(f * f + g * g);
		if (h > 12.0) {
			this.tx = this.getX() + f / h * 12.0;
			this.tz = this.getZ() + g / h * 12.0;
			this.ty = this.getY() + 8.0;
		} else {
			this.tx = d;
			this.ty = i;
			this.tz = e;
		}

		this.life = 0;
		this.surviveAfterDeath = this.random.nextInt(5) > 0;
	}

	public void setSurviveAfterDeath(boolean surviveAfterDeath) {
		this.surviveAfterDeath = surviveAfterDeath;
	}

	public void lerpMotion(double d, double e, double f) {
		this.setDeltaMovement(d, e, f);
		if (this.xRotO == 0.0F && this.yRotO == 0.0F) {
			double g = Math.sqrt(d * d + f * f);
			this.setYRot((float) (Mth.atan2(d, f) * 57.2957763671875));
			this.setXRot((float) (Mth.atan2(e, g) * 57.2957763671875));
			this.yRotO = this.getYRot();
			this.xRotO = this.getXRot();
		}

	}

	protected float lerpRotation(float f, float g) {
		while (g - f < -180.0F) {
			f -= 360.0F;
		}

		while (g - f >= 180.0F) {
			f += 360.0F;
		}

		return Mth.lerp(0.2F, f, g);
	}

	public void tick() {
		super.tick();
		Vec3 vec3 = this.getDeltaMovement();
		double d = this.getX() + vec3.x;
		double e = this.getY() + vec3.y;
		double f = this.getZ() + vec3.z;
		double g = vec3.horizontalDistance();
		this.setXRot(lerpRotation(this.xRotO, (float) (Mth.atan2(vec3.y, g) * 57.2957763671875)));
		this.setYRot(lerpRotation(this.yRotO, (float) (Mth.atan2(vec3.x, vec3.z) * 57.2957763671875)));
		if (!this.level().isClientSide) {
			double h = this.tx - d;
			double i = this.tz - f;
			float j = (float) Math.sqrt(h * h + i * i);
			float k = (float) Mth.atan2(i, h);
			double l = Mth.lerp(0.0025, g, j);
			double m = vec3.y;
			if (j < 1.0F) {
				l *= 0.8;
				m *= 0.8;
			}

			int n = this.getY() < this.ty ? 1 : -1;
			vec3 = new Vec3(Math.cos(k) * l, m + ((double) n - m) * 0.014999999664723873, Math.sin(k) * l);
			this.setDeltaMovement(vec3);
		}

		if (this.isInWater()) {
			for (int p = 0; p < 4; ++p) {
				this.level().addParticle(ParticleTypes.BUBBLE, d - vec3.x * 0.25, e - vec3.y * 0.25, f - vec3.z * 0.25, vec3.x, vec3.y, vec3.z);
			}
		} else {
			this.level().addParticle(ParticleTypes.PORTAL, d - vec3.x * 0.25 + this.random.nextDouble() * 0.6 - 0.3, e - vec3.y * 0.25 - 0.5, f - vec3.z * 0.25 + this.random.nextDouble() * 0.6 - 0.3, vec3.x, vec3.y, vec3.z);
		}

		if (!this.level().isClientSide) {
			this.setPos(d, e, f);
			++this.life;
			if (this.life > 80 && !this.level().isClientSide) {
				this.playSound(ESSoundEvents.SEEKING_EYE_DEATH.get(), 1.0F, 1.0F);
				this.discard();
				if (this.surviveAfterDeath) {
					this.level().addFreshEntity(new ItemEntity(this.level(), this.getX(), this.getY(), this.getZ(), this.getItem()));
				} else if (level() instanceof ServerLevel serverLevel) {
					serverLevel.sendParticles(new ItemParticleOption(ParticleTypes.ITEM, getItem()), this.getX() + (this.random.nextFloat() - 0.5) * getBbWidth(), this.getY() + random.nextFloat() * getBbHeight(), this.getZ() + (this.random.nextFloat() - 0.5) * getBbWidth(), 5, 0.2, 0.2, 0.2, 0.0);
				}
			}
		} else {
			this.setPosRaw(d, e, f);
		}

	}

	public void addAdditionalSaveData(CompoundTag compoundTag) {
		compoundTag.put(TAG_ITEM, this.getItem().save(this.registryAccess()));
		compoundTag.putBoolean(TAG_SURVIVE_AFTER_DEATH, surviveAfterDeath);
	}

	public void readAdditionalSaveData(CompoundTag compoundTag) {
		if (compoundTag.contains(TAG_ITEM, 10)) {
			this.setItem(ItemStack.parse(this.registryAccess(), compoundTag.getCompound(TAG_ITEM)).orElse(this.getDefaultItem()));
		} else {
			this.setItem(this.getDefaultItem());
		}
		this.surviveAfterDeath = compoundTag.getBoolean(TAG_SURVIVE_AFTER_DEATH);
	}

	private ItemStack getDefaultItem() {
		return new ItemStack(ESItems.SEEKING_EYE.get());
	}

	public float getLightLevelDependentMagicValue() {
		return 1.0F;
	}

	public boolean isAttackable() {
		return false;
	}
}
