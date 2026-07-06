package net.mshm.jeffbs.block;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.mshm.jeffbs.JeffSBull;

import java.util.function.Function;

public class ModBlocks {
    public static final Block NAUGHT_IRON_BLOCK = registerBlock("naught_iron_block",
            properties -> new Block(properties.strength(50f, 0.1f)
                    .requiresCorrectToolForDrops().sound(SoundType.SUSPICIOUS_GRAVEL)));
    public static final Block NAUGHT_RAW_IRON_BLOCK = registerBlock("naught_raw_iron_block",
            properties -> new Block(properties.strength(50f, 0.1f)
                    .requiresCorrectToolForDrops().sound(SoundType.SUSPICIOUS_SAND)));
    public static final Block NAUGHT_IRON_ORE = registerBlock("naught_iron_ore",
            properties -> new Block(properties.strength(4.5f, 404f)
                    .requiresCorrectToolForDrops().sound(SoundType.GRASS)));
    public static final Block NAUGHT_DEEPSLATE_IRON_ORE = registerBlock("naught_deepslate_iron_ore",
            properties -> new Block(properties.strength(3f, 404f)
                    .requiresCorrectToolForDrops().sound(SoundType.MOSS)));


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
