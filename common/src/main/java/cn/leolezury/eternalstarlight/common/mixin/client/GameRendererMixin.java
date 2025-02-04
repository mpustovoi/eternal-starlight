package cn.leolezury.eternalstarlight.common.mixin.client;

import cn.leolezury.eternalstarlight.common.EternalStarlight;
import cn.leolezury.eternalstarlight.common.entity.projectile.SoulitSpectator;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(GameRenderer.class)
public abstract class GameRendererMixin {
	@Shadow
	protected abstract void setPostEffect(ResourceLocation resourceLocation);

	@Inject(method = "checkEntityPostEffect", at = @At("TAIL"))
	private void checkEntityPostEffect(Entity entity, CallbackInfo ci) {
		if (entity instanceof SoulitSpectator) {
			setPostEffect(EternalStarlight.id("soulit_spectator"));
		}
	}
}
