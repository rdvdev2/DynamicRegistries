package com.rdvdev2.dynamicregistries;

import net.minecraftforge.registries.ForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class RegistryManager {

    // This value will be adjusted via events to ensure we're always pointing to the correct registries
    private static boolean frozenRegistries = true;

    public static <T extends IForgeRegistryEntry<T>> ForgeRegistry<T> getRegistry(Class<T> clazz) {
        if (frozenRegistries) return (ForgeRegistry<T>) net.minecraftforge.registries.RegistryManager.FROZEN.getRegistry(clazz);
        else                  return (ForgeRegistry<T>) net.minecraftforge.registries.RegistryManager.ACTIVE.getRegistry(clazz);
    }
}
