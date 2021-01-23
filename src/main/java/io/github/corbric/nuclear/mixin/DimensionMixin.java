package io.github.corbric.nuclear.mixin;

import io.github.corbric.nuclear.Nuclear;
import io.github.corbric.nuclear.world.gen.EmptyChunkProvider;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkProvider;
import net.minecraft.world.dimension.Dimension;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Dimension.class)
public class DimensionMixin {

	@Shadow protected World world;

	@Inject(method = "method_1476", at = @At("HEAD"), cancellable = true)
	private void nuclearGetChunkProvider(CallbackInfoReturnable<ChunkProvider> cir) {
		if(Nuclear.config.generateVoidWorld) {
			cir.setReturnValue(new EmptyChunkProvider(world, world.getSeed()));
		}
	}
}
