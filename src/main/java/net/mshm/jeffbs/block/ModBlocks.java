package net.mshm.jeffbs.block;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.mshm.jeffbs.JeffSBull;
import net.mshm.jeffbs.block.custom.NaughtsqrdBlock;

import java.util.function.Function;

public class ModBlocks {
    public static final Block NAUGHT_IRON_BLOCK = registerBlock("naught_iron_block",
            properties -> new Block(properties
                    .mapColor(MapColor.COLOR_MAGENTA)
                    .strength(50f, 0.1f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.SUSPICIOUS_GRAVEL)));
    public static final Block NAUGHT_RAW_IRON_BLOCK = registerBlock("naught_raw_iron_block",
            properties -> new Block(properties
                    .mapColor(MapColor.COLOR_MAGENTA)
                    .strength(50f, 0.1f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.SUSPICIOUS_SAND)));

    public static final Block NAUGHT_IRON_ORE = registerBlock("naught_iron_ore",
            properties -> new Block(properties
                    .mapColor(MapColor.STONE)
                    .strength(4.5f, 404f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.GRASS)));
    public static final Block NAUGHT_DEEPSLATE_IRON_ORE = registerBlock("naught_deepslate_iron_ore",
            properties -> new Block(properties
                    .mapColor(MapColor.STONE)
                    .strength(3f, 404f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.MOSS)));

    public static final Block IRON_STAIRS = registerBlock("iron_stairs",
            properties -> new StairBlock(Blocks.IRON_BLOCK.defaultBlockState(),properties
                    .mapColor(MapColor.METAL)
                    .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .requiresCorrectToolForDrops()
                    .strength(5.0F, 6.0F)
                    .sound(SoundType.IRON)
                    /*.strength(5.0f, 6.0f).requiresCorrectToolForDrops().sound(SoundType.IRON)*/));
    public static final Block IRON_SLAB = registerBlock("iron_slab",
            properties -> new SlabBlock(properties
                    .mapColor(MapColor.METAL)
                    .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .requiresCorrectToolForDrops()
                    .strength(5.0F, 6.0F)
                    .sound(SoundType.IRON)));

    public static final Block NAUGHT_IRON_STAIRS = registerBlock("naught_iron_stairs",
            properties -> new StairBlock(Blocks.IRON_BLOCK.defaultBlockState(),properties
                    .mapColor(MapColor.COLOR_MAGENTA)
                    .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .requiresCorrectToolForDrops()
                    .strength(5.0F, 6.0F)
                    .sound(SoundType.WEEPING_VINES)
                    /*.strength(5.0f, 6.0f).requiresCorrectToolForDrops().sound(SoundType.IRON)*/));
    public static final Block NAUGHT_IRON_SLAB = registerBlock("naught_iron_slab",
            properties -> new SlabBlock(properties
                    .mapColor(MapColor.COLOR_MAGENTA)
                    .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .requiresCorrectToolForDrops()
                    .strength(5.0F, 6.0F)
                    .sound(SoundType.NETHER_WOOD)));




    //custom
    public static final Block NAUGHTSQRD = registerBlock("naughtsqrd",
                properties -> new NaughtsqrdBlock(properties.strength(0.1f, 404f)
                        .sound(SoundType.GLASS)));


    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(JeffSBull.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(JeffSBull.MOD_ID, name), toRegister);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(JeffSBull.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(JeffSBull.MOD_ID, name)))));
    }

    public  static void registerModBlocks() {
        JeffSBull.LOGGER.info("Registering " + JeffSBull.MOD_ID + "blocks");
    }
}
