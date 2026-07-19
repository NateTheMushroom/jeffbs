package net.mshm.jeffbs.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.mshm.jeffbs.block.ModBlocks;
import net.mshm.jeffbs.tags.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {
    public ModBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
                        ModBlocks.IRON_STAIRS,
                        ModBlocks.IRON_SLAB,
                        ModBlocks.IRON_FENCE,
                        ModBlocks.IRON_FENCE_GATE,
                        ModBlocks.IRON_WALL
                ).add(
                        ModBlocks.NAUGHT_IRON_BLOCK,
                        ModBlocks.NAUGHT_RAW_IRON_BLOCK,
                        ModBlocks.NAUGHT_IRON_ORE,
                        ModBlocks.NAUGHT_DEEPSLATE_IRON_ORE,
                        ModBlocks.NAUGHT_IRON_STAIRS,
                        ModBlocks.NAUGHT_IRON_SLAB,
                        ModBlocks.NAUGHT_IRON_FENCE,
                        ModBlocks.NAUGHT_IRON_FENCE_GATE,
                        ModBlocks.NAUGHT_IRON_WALL,
                        ModBlocks.NAUGHT_IRON_DOOR,
                        ModBlocks.NAUGHT_IRON_TRAPDOOR
                ).add(
                        ModBlocks.NAUGHTSQRD
                );

        valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(
                        ModBlocks.NAUGHT_IRON_BLOCK,
                        ModBlocks.NAUGHT_RAW_IRON_BLOCK,
                        ModBlocks.NAUGHT_DEEPSLATE_IRON_ORE
                );
        valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(
                        ModBlocks.NAUGHT_IRON_ORE
                );

        valueLookupBuilder(BlockTags.STAIRS)
                .add(
                        ModBlocks.IRON_STAIRS,
                        ModBlocks.NAUGHT_IRON_STAIRS
                );
        valueLookupBuilder(BlockTags.SLABS)
                .add(
                        ModBlocks.IRON_SLAB)
                .add(ModBlocks.NAUGHT_IRON_SLAB
                );
        valueLookupBuilder(BlockTags.BUTTONS)
                .add(
                        ModBlocks.NAUGHT_IRON_BUTTON
                );
        valueLookupBuilder(BlockTags.PRESSURE_PLATES)
                .add(
                        ModBlocks.NAUGHT_IRON_PRESSUREPLATE
                );
        valueLookupBuilder(BlockTags.DOORS)
                .add(
                        ModBlocks.NAUGHT_IRON_DOOR
                );
        valueLookupBuilder(BlockTags.TRAPDOORS)
                .add(
                        ModBlocks.NAUGHT_IRON_TRAPDOOR
                );
        //fences&walls required
        valueLookupBuilder(BlockTags.FENCES)
                .add(
                        ModBlocks.IRON_FENCE,
                        ModBlocks.NAUGHT_IRON_FENCE
                );
            valueLookupBuilder(BlockTags.WOODEN_FENCES)
                    .add(
                            ModBlocks.NAUGHT_IRON_FENCE
                    );
        valueLookupBuilder(BlockTags.FENCE_GATES)
                .add(
                        ModBlocks.IRON_FENCE_GATE,
                        ModBlocks.NAUGHT_IRON_FENCE_GATE
                );
        valueLookupBuilder(BlockTags.WALLS)
                .add(
                        ModBlocks.IRON_WALL,
                        ModBlocks.NAUGHT_IRON_WALL
                );


        //custopm tool stuff
        valueLookupBuilder(ModTags.Blocks.NEEDS_NAUGHT_IRON_TOOL)
                .add(
                        ModBlocks.NAUGHTSQRD,
                        Blocks.BEDROCK
                );
        valueLookupBuilder(ModTags.Blocks.INCORRECT_FOR_NAUGHT_IRON_TOOL)
                /*.add(blablabla)*/;
        valueLookupBuilder(BlockTags.INCORRECT_FOR_NETHERITE_TOOL).addTag(ModTags.Blocks.NEEDS_NAUGHT_IRON_TOOL);
        valueLookupBuilder(BlockTags.INCORRECT_FOR_DIAMOND_TOOL).addTag(ModTags.Blocks.NEEDS_NAUGHT_IRON_TOOL);
        valueLookupBuilder(BlockTags.INCORRECT_FOR_IRON_TOOL).addTag(ModTags.Blocks.NEEDS_NAUGHT_IRON_TOOL);
        valueLookupBuilder(BlockTags.INCORRECT_FOR_COPPER_TOOL).addTag(ModTags.Blocks.NEEDS_NAUGHT_IRON_TOOL);
        valueLookupBuilder(BlockTags.INCORRECT_FOR_STONE_TOOL).addTag(ModTags.Blocks.NEEDS_NAUGHT_IRON_TOOL);
        valueLookupBuilder(BlockTags.INCORRECT_FOR_GOLD_TOOL).addTag(ModTags.Blocks.NEEDS_NAUGHT_IRON_TOOL);
        valueLookupBuilder(BlockTags.INCORRECT_FOR_WOODEN_TOOL).addTag(ModTags.Blocks.NEEDS_NAUGHT_IRON_TOOL);




    }
}
