package com.rdvdev2.dynamicregistries;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.event.server.FMLServerAboutToStartEvent;
import net.minecraftforge.fml.event.server.FMLServerStoppingEvent;
import net.minecraftforge.registries.ForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@net.minecraftforge.fml.common.Mod(Mod.MODID)
public class Mod {

    public static final String MODID = "dynamicregistries";
    public static final Logger LOGGER = LogManager.getLogger();

    private Block testinjection = new Block(Block.Properties.create(Material.ROCK)).setRegistryName(MODID, "testinjection");

    public Mod() {
        MinecraftForge.EVENT_BUS.addListener(this::serverAboutToStart);
        MinecraftForge.EVENT_BUS.addListener(this::serverStoping);
    }

    /*
        This is a testing on the fly registry injection.
        We work on the frozen registries, so we must lock and unlock them by ourselves to keep it working.
        We need to duplicate this logic on missing mappings, giving us an easy way to differenciate between generating and loading.
        We also need to cleanup.
     */
    public void serverAboutToStart(FMLServerAboutToStartEvent event) {
        ForgeRegistries.BLOCKS.get().unfreeze();
        ForgeRegistries.ITEMS.get().unfreeze();

        ForgeRegistries.BLOCKS.get().register(testinjection);
        ForgeRegistries.ITEMS.get().register(new BlockItem(testinjection, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(testinjection.getRegistryName()));

        ForgeRegistries.BLOCKS.get().freeze();
        ForgeRegistries.ITEMS.get().freeze();
    }

    public void serverStoping(FMLServerStoppingEvent event) {
        ForgeRegistries.BLOCKS.get().unfreeze();
        ForgeRegistries.ITEMS.get().unfreeze();

        ForgeRegistries.BLOCKS.get().remove(testinjection.getRegistryName());
        ForgeRegistries.ITEMS.get().remove(testinjection.getRegistryName());

        ForgeRegistries.BLOCKS.get().freeze();
        ForgeRegistries.ITEMS.get().freeze();
    }
}
