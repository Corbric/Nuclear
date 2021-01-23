package io.github.corbric.nuclear.mixin;

import io.github.corbric.nuclear.Nuclear;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(World.class)
public class WorldMixin {

	@Inject(method = "getBiomeAt", at = @At("HEAD"), cancellable = true)
	private void nuclearGetBiomeAt(BlockPos pos, CallbackInfoReturnable<Biome> cir) {
		if(Nuclear.config.generateVoidWorld) {
			cir.setReturnValue(Biome.PLAINS);
		}
	}
}
