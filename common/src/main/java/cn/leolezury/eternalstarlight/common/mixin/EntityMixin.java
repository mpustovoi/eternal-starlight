package cn.leolezury.eternalstarlight.common.mixin;

import cn.leolezury.eternalstarlight.common.entity.interfaces.PersistentDataHolder;
import cn.leolezury.eternalstarlight.common.registry.ESMobEffects;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class EntityMixin implements PersistentDataHolder {
	@Unique
	private CompoundTag esPersistentData;

	@Override
	public CompoundTag getESPersistentData() {
		if (esPersistentData == null) {
			esPersistentData = new CompoundTag();
		}
		return esPersistentData;
	}

	@Inject(method = "saveWithoutId", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;addAdditionalSaveData(Lnet/minecraft/nbt/CompoundTag;)V"))
	private void save(CompoundTag compoundTag, CallbackInfoReturnable<Boolean> info) {
		if (esPersistentData != null && compoundTag != null) {
			compoundTag.put("es_data", esPersistentData.copy());
		}
	}

	@Inject(method = "load", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;readAdditionalSaveData(Lnet/minecraft/nbt/CompoundTag;)V"))
	private void load(CompoundTag compoundTag, CallbackInfo info) {
		if (compoundTag != null && compoundTag.contains("es_data", CompoundTag.TAG_COMPOUND)) {
			esPersistentData = compoundTag.getCompound("es_data");
		}
	}

	@Inject(method = "isStateClimbable", at = @At("RETURN"), cancellable = true)
	private void isStateClimbable(BlockState blockState, CallbackInfoReturnable<Boolean> cir) {
		Entity entity = (Entity) (Object) this;
		if (entity instanceof LivingEntity living && living.hasEffect(ESMobEffects.STICKY.asHolder())) {
			cir.setReturnValue(true);
		}
	}
}
