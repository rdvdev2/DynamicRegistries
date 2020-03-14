package com.rdvdev2.dynamicregistries;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.brain.memory.MemoryModuleType;
import net.minecraft.entity.ai.brain.schedule.Activity;
import net.minecraft.entity.ai.brain.schedule.Schedule;
import net.minecraft.entity.ai.brain.sensor.SensorType;
import net.minecraft.entity.item.PaintingType;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.fluid.Fluid;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.particles.ParticleType;
import net.minecraft.potion.Effect;
import net.minecraft.potion.Potion;
import net.minecraft.stats.StatType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.registry.Bootstrap;
import net.minecraft.village.PointOfInterestType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProviderType;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.gen.ChunkGeneratorType;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.registries.DataSerializerEntry;
import net.minecraftforge.registries.ForgeRegistry;
import net.minecraftforge.registries.GameData;

import java.util.function.Supplier;

/**
 * This class is a copy of {@link net.minecraftforge.registries.ForgeRegistries} that gives a reference to the registry that corresponds to the actual state of the game.
 * Suppliers are used as a dynamic variable
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public class ForgeRegistries {

    static { init(); } // This must be above the fields so we guarantee it's run before findRegistry is called. Yay static inializers

    // Game objects
    public static final Supplier<ForgeRegistry<Block>> BLOCKS = () -> RegistryManager.getRegistry(Block.class);
    public static final Supplier<ForgeRegistry<Fluid>> FLUIDS = () -> RegistryManager.getRegistry(Fluid.class);
    public static final Supplier<ForgeRegistry<Item>> ITEMS = () -> RegistryManager.getRegistry(Item.class);
    public static final Supplier<ForgeRegistry<Effect>> POTIONS = () -> RegistryManager.getRegistry(Effect.class);
    public static final Supplier<ForgeRegistry<Biome>> BIOMES = () -> RegistryManager.getRegistry(Biome.class);
    public static final Supplier<ForgeRegistry<SoundEvent>> SOUND_EVENTS = () -> RegistryManager.getRegistry(SoundEvent.class);
    public static final Supplier<ForgeRegistry<Potion>> POTION_TYPES = () -> RegistryManager.getRegistry(Potion.class);
    public static final Supplier<ForgeRegistry<Enchantment>> ENCHANTMENTS = () -> RegistryManager.getRegistry(Enchantment.class);
    public static final Supplier<ForgeRegistry<EntityType<?>>> ENTITIES = () -> (ForgeRegistry) RegistryManager.getRegistry(EntityType.class);
    public static final Supplier<ForgeRegistry<TileEntityType<?>>> TILE_ENTITIES = () -> (ForgeRegistry) RegistryManager.getRegistry(TileEntityType.class);
    public static final Supplier<ForgeRegistry<ParticleType<?>>> PARTICLE_TYPES = () -> (ForgeRegistry) RegistryManager.getRegistry(ParticleType.class);
    public static final Supplier<ForgeRegistry<ContainerType<?>>> CONTAINERS = () -> (ForgeRegistry) RegistryManager.getRegistry(ContainerType.class);
    public static final Supplier<ForgeRegistry<PaintingType>> PAINTING_TYPES = () -> RegistryManager.getRegistry(PaintingType.class);
    public static final Supplier<ForgeRegistry<IRecipeSerializer<?>>> RECIPE_SERIALIZERS = () -> (ForgeRegistry) RegistryManager.getRegistry(IRecipeSerializer.class);
    public static final Supplier<ForgeRegistry<StatType<?>>> STAT_TYPES = () -> (ForgeRegistry) RegistryManager.getRegistry(StatType.class);

    // Villages
    public static final Supplier<ForgeRegistry<VillagerProfession>> PROFESSIONS = () -> RegistryManager.getRegistry(VillagerProfession.class);
    public static final Supplier<ForgeRegistry<PointOfInterestType>> POI_TYPES = () -> RegistryManager.getRegistry(PointOfInterestType.class);
    public static final Supplier<ForgeRegistry<MemoryModuleType<?>>> MEMORY_MODULE_TYPES = () -> (ForgeRegistry) RegistryManager.getRegistry(MemoryModuleType.class);
    public static final Supplier<ForgeRegistry<SensorType<?>>> SENSOR_TYPES = () -> (ForgeRegistry) RegistryManager.getRegistry(SensorType.class);
    public static final Supplier<ForgeRegistry<Schedule>> SCHEDULES = () -> RegistryManager.getRegistry(Schedule.class);
    public static final Supplier<ForgeRegistry<Activity>> ACTIVITIES = () -> RegistryManager.getRegistry(Activity.class);

    // Worldgen
    public static final Supplier<ForgeRegistry<WorldCarver<?>>> WORLD_CARVERS = () -> (ForgeRegistry) RegistryManager.getRegistry(WorldCarver.class);
    public static final Supplier<ForgeRegistry<SurfaceBuilder<?>>> SURFACE_BUILDERS = () -> (ForgeRegistry) RegistryManager.getRegistry(SurfaceBuilder.class);
    public static final Supplier<ForgeRegistry<Feature<?>>> FEATURES = () -> (ForgeRegistry) RegistryManager.getRegistry(Feature.class);
    public static final Supplier<ForgeRegistry<Placement<?>>> DECORATORS = () -> (ForgeRegistry) RegistryManager.getRegistry(Placement.class);
    public static final Supplier<ForgeRegistry<BiomeProviderType<?, ?>>> BIOME_PROVIDER_TYPES = () -> (ForgeRegistry) RegistryManager.getRegistry(BiomeProviderType.class);
    public static final Supplier<ForgeRegistry<ChunkGeneratorType<?, ?>>> CHUNK_GENERATOR_TYPES = () -> (ForgeRegistry) RegistryManager.getRegistry(ChunkGeneratorType.class);
    public static final Supplier<ForgeRegistry<ChunkStatus>> CHUNK_STATUS = () -> RegistryManager.getRegistry(ChunkStatus.class);

    // Custom forge registries
    public static final Supplier<ForgeRegistry<ModDimension>> MOD_DIMENSIONS = () -> RegistryManager.getRegistry(ModDimension.class);
    public static final Supplier<ForgeRegistry<DataSerializerEntry>> DATA_SERIALIZERS = () -> RegistryManager.getRegistry(DataSerializerEntry.class);

    /**
     * This function is just to make sure static inializers in other classes have run and setup their registries before we query them.
     */
    private static void init()
    {
        GameData.init();
        Bootstrap.register();
    }
}
