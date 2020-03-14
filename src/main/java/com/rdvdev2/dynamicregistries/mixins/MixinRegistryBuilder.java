package com.rdvdev2.dynamicregistries.mixins;

import net.minecraftforge.registries.RegistryBuilder;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(RegistryBuilder.class)
public abstract class MixinRegistryBuilder { // TODO: Extend from target class

    public boolean getAllowModifications() {
        return true;
    }
}
