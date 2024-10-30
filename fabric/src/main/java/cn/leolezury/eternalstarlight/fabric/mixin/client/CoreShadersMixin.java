package cn.leolezury.eternalstarlight.fabric.mixin.client;

import cn.leolezury.eternalstarlight.common.client.handler.ClientSetupHandlers;
import net.minecraft.client.renderer.CoreShaders;
import net.minecraft.client.renderer.ShaderProgram;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(CoreShaders.class)
public abstract class CoreShadersMixin {
	@Shadow
	@Final
	private static List<ShaderProgram> PROGRAMS;

	@Inject(method = "<clinit>", at = @At(value = "RETURN"))
	private static void init(CallbackInfo ci) {
		ClientSetupHandlers.registerShaders(PROGRAMS::add);
	}
}
