package io.github.corbric.nuclear.mixin;

import io.github.corbric.nuclear.Nuclear;
import io.github.corbric.nuclear.api.entity.NeedsAi;
import net.minecraft.entity.EntityMotionHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MobEntity.class)
public abstract class MobEntityMixin extends LivingEntity {

	@Shadow protected EntityMotionHelper entityMotionHelper;

	@Shadow protected abstract void checkDespawn();

	public MobEntityMixin(World world) {
		super(world);
	}

	@Inject(method = "tickNewAi", at = @At("HEAD"), cancellable = true)
	private void nuclearTickNewAi(CallbackInfo ci) {
		if(Nuclear.config.minimalTickMobAi && this instanceof NeedsAi) {
			++this.field_7451;
			this.world.profiler.push("checkDespawn");
			this.checkDespawn();
			this.world.profiler.pop();
			this.world.profiler.push("move");
			this.entityMotionHelper.updateMovement();
			this.world.profiler.pop();
			ci.cancel();
		}
	}
}
