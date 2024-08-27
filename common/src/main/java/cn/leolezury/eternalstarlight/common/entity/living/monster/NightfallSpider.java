package cn.leolezury.eternalstarlight.common.entity.living.monster;

import cn.leolezury.eternalstarlight.common.config.ESConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class NightfallSpider extends Spider {
	public NightfallSpider(EntityType<? extends NightfallSpider> type, Level level) {
		super(type, level);
	}

	public static AttributeSupplier.Builder createNightfallSpider() {
		return Spider.createAttributes()
			.add(Attributes.MAX_HEALTH, ESConfig.INSTANCE.mobsConfig.nightfallSpider.maxHealth())
			.add(Attributes.ARMOR, ESConfig.INSTANCE.mobsConfig.nightfallSpider.armor())
			.add(Attributes.ATTACK_DAMAGE, ESConfig.INSTANCE.mobsConfig.nightfallSpider.attackDamage())
			.add(Attributes.FOLLOW_RANGE, ESConfig.INSTANCE.mobsConfig.nightfallSpider.followRange());
	}

	@Override
	public boolean doHurtTarget(Entity entity) {
		if (super.doHurtTarget(entity)) {
			if (entity instanceof LivingEntity) {
				int effectTime = 0;
				if (this.level().getDifficulty() == Difficulty.NORMAL) {
					effectTime = 7;
				} else if (this.level().getDifficulty() == Difficulty.HARD) {
					effectTime = 15;
				}
				if (effectTime > 0) {
					((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.GLOWING, effectTime * 20, 0), this);
				}
			}
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Vec3 getVehicleAttachmentPoint(Entity entity) {
		return entity.getBbWidth() <= this.getBbWidth() ? new Vec3(0.0, 0.21875 * (double) this.getScale(), 0.0) : super.getVehicleAttachmentPoint(entity);
	}

	public static boolean checkNightfallSpiderSpawnRules(EntityType<? extends NightfallSpider> type, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
		return checkAnyLightMonsterSpawnRules(type, level, spawnType, pos, random) && ESConfig.INSTANCE.mobsConfig.nightfallSpider.canSpawn();
	}
}
