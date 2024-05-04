package cn.leolezury.eternalstarlight.fabric.mixins;

import cn.leolezury.eternalstarlight.common.handler.CommonHandlers;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.server.PlayerAdvancements;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerAdvancements.class)
public abstract class PlayerAdvancementsMixin {
    @Shadow public abstract AdvancementProgress getOrStartProgress(AdvancementHolder advancementHolder);

    @Shadow private ServerPlayer player;

    @Inject(at = @At(value = "TAIL"), method = "award")
    private void es_award(AdvancementHolder advancementHolder, String string, CallbackInfoReturnable<Boolean> cir) {
        if (getOrStartProgress(advancementHolder).isDone()) {
            CommonHandlers.onCompleteAdvancement(player, advancementHolder);
        }
    }
}
