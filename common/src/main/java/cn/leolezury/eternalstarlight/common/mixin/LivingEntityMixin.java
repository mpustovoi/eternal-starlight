package cn.leolezury.eternalstarlight.common.mixin;

import cn.leolezury.eternalstarlight.common.item.interfaces.Swingable;
import cn.leolezury.eternalstarlight.common.network.ParticlePacket;
import cn.leolezury.eternalstarlight.common.particle.ExplosionShockParticleOptions;
import cn.leolezury.eternalstarlight.common.particle.GlowParticleOptions;
import cn.leolezury.eternalstarlight.common.platform.ESPlatform;
import cn.leolezury.eternalstarlight.common.registry.ESAttributes;
import cn.leolezury.eternalstarlight.common.registry.ESItems;
import cn.leolezury.eternalstarlight.common.util.ESTags;
import cn.leolezury.eternalstarlight.common.vfx.ScreenShakeVfx;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
	@Shadow
	public abstract ItemStack getItemInHand(InteractionHand interactionHand);

	@Shadow
	public abstract boolean isUsingItem();

	@Shadow
	public abstract ItemStack getUseItem();

	@Shadow
	public abstract Collection<MobEffectInstance> getActiveEffects();

	@Shadow
	public abstract boolean hasEffect(Holder<MobEffect> holder);

	@Shadow
	public abstract boolean removeEffect(Holder<MobEffect> holder);

	@Shadow
	@Nullable
	protected ItemStack autoSpinAttackItemStack;

	@Shadow
	@NotNull
	public abstract ItemStack getWeaponItem();

	@Inject(method = "swing(Lnet/minecraft/world/InteractionHand;Z)V", at = @At("HEAD"))
	private void swing(InteractionHand interactionHand, boolean bl, CallbackInfo ci) {
		if (this.getItemInHand(interactionHand).getItem() instanceof Swingable swingable) {
			swingable.swing(this.getItemInHand(interactionHand), (LivingEntity) ((Object) this));
		}
	}

	@Inject(method = "isBlocking", at = @At("RETURN"), cancellable = true)
	private void isBlocking(CallbackInfoReturnable<Boolean> cir) {
		if (isUsingItem() && getUseItem().is(ESTags.Items.GREATSWORDS)) {
			cir.setReturnValue(true);
		}
	}

	@Inject(method = "getKnockback", at = @At("RETURN"), cancellable = true)
	private void getKnockback(Entity target, DamageSource damageSource, CallbackInfoReturnable<Float> cir) {
		if (getWeaponItem().is(ESTags.Items.HAMMERS)) {
			cir.setReturnValue(cir.getReturnValue() + 1);
		}
	}

	@Inject(method = "createLivingAttributes", at = @At("RETURN"))
	private static void createLivingAttributes(CallbackInfoReturnable<AttributeSupplier.Builder> cir) {
		cir.getReturnValue().add(ESAttributes.THROWN_POTION_DISTANCE.asHolder()).add(ESAttributes.ETHER_RESISTANCE.asHolder());
	}

	@Inject(method = "checkAutoSpinAttack", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;setDeltaMovement(Lnet/minecraft/world/phys/Vec3;)V", shift = At.Shift.AFTER))
	private void checkAutoSpinAttack(CallbackInfo ci) {
		doCrescentSpearDamage();
	}

	@Inject(method = "checkAutoSpinAttack", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;level()Lnet/minecraft/world/level/Level;", shift = At.Shift.AFTER))
	private void checkAutoSpinAttackTail(CallbackInfo ci) {
		LivingEntity entity = (LivingEntity) (Object) this;
		if (entity.horizontalCollision) {
			doCrescentSpearDamage();
		}
	}

	@Unique
	private void doCrescentSpearDamage() {
		LivingEntity entity = (LivingEntity) (Object) this;
		if (autoSpinAttackItemStack != null && autoSpinAttackItemStack.is(ESItems.CRESCENT_SPEAR.get())) {
			if (!entity.level().isClientSide) {
				for (LivingEntity living : entity.level().getNearbyEntities(LivingEntity.class, TargetingConditions.DEFAULT, entity, entity.getBoundingBox().inflate(3))) {
					if (!living.isAlliedTo(entity) && entity instanceof Player player) {
						player.attack(living);
					}
				}
				if (entity.level() instanceof ServerLevel serverLevel) {
					for (int i = 0; i < 40; i++) {
						serverLevel.sendParticles(GlowParticleOptions.GLOW, entity.getX() + (entity.getRandom().nextDouble() - 0.5) * entity.getBbWidth() * 2, entity.getRandomY(), entity.getZ() + (entity.getRandom().nextDouble() - 0.5) * entity.getBbWidth() * 2, 3, 0.2, 0.2, 0.2, 0);
					}
					for (int i = 0; i < 10; i++) {
						Vec3 speed = new Vec3((entity.getRandom().nextFloat() - entity.getRandom().nextFloat()) * 0.1F, entity.getRandom().nextFloat() * 0.05F, (entity.getRandom().nextFloat() - entity.getRandom().nextFloat()) * 0.1F).normalize();
						Vec3 centerPos = entity.position().add(0, entity.getBbHeight() / 2, 0);
						ESPlatform.INSTANCE.sendToAllClients(serverLevel, new ParticlePacket(ExplosionShockParticleOptions.CRESCENT_SPEAR, centerPos.x + speed.x * 1.5, centerPos.y + speed.y * 1.5, centerPos.z + speed.z * 1.5, speed.x, speed.y, speed.z));
					}
					ScreenShakeVfx.createInstance(entity.level().dimension(), entity.position(), 40, 50, 0.12f, 0.24f, 3, 5.5f).send(serverLevel);
				}
			}
		}
	}

	@Inject(method = "eat(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/food/FoodProperties;)Lnet/minecraft/world/item/ItemStack;", at = @At("HEAD"))
	private void eat(Level level, ItemStack itemStack, FoodProperties foodProperties, CallbackInfoReturnable<ItemStack> cir) {
		if (itemStack.is(ESItems.LUNARIS_CACTUS_GEL.get())) {
			List<Holder<MobEffect>> effectsToRemove = new ArrayList<>();
			for (MobEffectInstance effectInstance : getActiveEffects()) {
				if (!effectInstance.getEffect().value().isBeneficial()) {
					effectsToRemove.add(effectInstance.getEffect());
				}
			}
			for (Holder<MobEffect> effect : effectsToRemove) {
				if (hasEffect(effect)) {
					removeEffect(effect);
				}
			}
		}
	}
}
