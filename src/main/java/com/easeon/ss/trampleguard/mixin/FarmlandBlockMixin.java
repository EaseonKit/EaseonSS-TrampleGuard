package com.easeon.ss.trampleguard.mixin;

import com.easeon.ss.trampleguard.Easeon;
import net.minecraft.block.FarmlandBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FarmlandBlock.class)
public class FarmlandBlockMixin {
    @Inject(method = "onLandedUpon", at = @At("HEAD"), cancellable = true)
    private void preventFarmlandTrample(CallbackInfo ci) {
        var config = Easeon.CONFIG.isEnabled();
        // 모든 엔티티의 농지 파손을 차단
        if (config)
            ci.cancel();
    }
}