package net.mshm.jeffbs.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.references.BlockIds;
import net.minecraft.references.BlockItemIds;
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
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
                        ModBlocks.getRK(ModBlocks.IRON_STAIRS),
                        ModBlocks.getRK(ModBlocks.IRON_SLAB),
                        ModBlocks.getRK(ModBlocks.IRON_FENCE),
                        ModBlocks.getRK(ModBlocks.IRON_FENCE_GATE),
                        ModBlocks.getRK(ModBlocks.IRON_WALL)
                ).add(
                        ModBlocks.getRK(ModBlocks.NAUGHT_IRON_BLOCK),
                        ModBlocks.getRK(ModBlocks.NAUGHT_RAW_IRON_BLOCK),
                        ModBlocks.getRK(ModBlocks.NAUGHT_IRON_ORE),
                        ModBlocks.getRK(ModBlocks.NAUGHT_DEEPSLATE_IRON_ORE),
                        ModBlocks.getRK(ModBlocks.NAUGHT_IRON_STAIRS),
                        ModBlocks.getRK(ModBlocks.NAUGHT_IRON_SLAB),
                        ModBlocks.getRK(ModBlocks.NAUGHT_IRON_FENCE),
                        ModBlocks.getRK(ModBlocks.NAUGHT_IRON_FENCE_GATE),
                        ModBlocks.getRK(ModBlocks.NAUGHT_IRON_WALL),
                        ModBlocks.getRK(ModBlocks.NAUGHT_IRON_DOOR),
                        ModBlocks.getRK(ModBlocks.NAUGHT_IRON_TRAPDOOR)
                ).add(
                        ModBlocks.getRK(ModBlocks.NAUGHTSQRD),
                        ModBlocks.getRK(ModBlocks.EAT_N_SPIT)
                );

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(
                        ModBlocks.getRK(ModBlocks.NAUGHT_IRON_BLOCK),
                        ModBlocks.getRK(ModBlocks.NAUGHT_RAW_IRON_BLOCK),
                        ModBlocks.getRK(ModBlocks.NAUGHT_DEEPSLATE_IRON_ORE),
                        ModBlocks.getRK(ModBlocks.EAT_N_SPIT)
                );
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(
                        ModBlocks.getRK(ModBlocks.NAUGHT_IRON_ORE)
                );

        tag(BlockTags.STAIRS)
                .add(
                        ModBlocks.getRK(ModBlocks.IRON_STAIRS),
                        ModBlocks.getRK(ModBlocks.NAUGHT_IRON_STAIRS)
                );
        tag(BlockTags.SLABS)
                .add(
                        ModBlocks.getRK(ModBlocks.IRON_SLAB)
                )
                .add(
                        ModBlocks.getRK(ModBlocks.NAUGHT_IRON_SLAB)
                );
        tag(BlockTags.BUTTONS)
                .add(
                        ModBlocks.getRK(ModBlocks.NAUGHT_IRON_BUTTON)
                );
        tag(BlockTags.PRESSURE_PLATES)
                .add(
                        ModBlocks.getRK(ModBlocks.NAUGHT_IRON_PRESSUREPLATE)
                );
        tag(BlockTags.DOORS)
                .add(
                        ModBlocks.getRK(ModBlocks.NAUGHT_IRON_DOOR)
                );
        tag(BlockTags.TRAPDOORS)
                .add(
                        ModBlocks.getRK(ModBlocks.NAUGHT_IRON_TRAPDOOR)
                );
        //fences&walls required
        tag(BlockTags.FENCES)
                .add(
                        ModBlocks.getRK(ModBlocks.IRON_FENCE),
                        ModBlocks.getRK(ModBlocks.NAUGHT_IRON_FENCE)
                );
            tag(BlockTags.WOODEN_FENCES)
                    .add(
                            ModBlocks.getRK(ModBlocks.NAUGHT_IRON_FENCE)
                    );
        tag(BlockTags.FENCE_GATES)
                .add(
                        ModBlocks.getRK(ModBlocks.IRON_FENCE_GATE),
                        ModBlocks.getRK(ModBlocks.NAUGHT_IRON_FENCE_GATE)
                );
        tag(BlockTags.WALLS)
                .add(
                        ModBlocks.getRK(ModBlocks.IRON_WALL),
                        ModBlocks.getRK(ModBlocks.NAUGHT_IRON_WALL)
                );


        //custopm tool stuff
        tag(ModTags.Blocks.NEEDS_NAUGHT_IRON_TOOL)
                .add(
                        ModBlocks.getRK(ModBlocks.NAUGHTSQRD)
                );
        tag(ModTags.Blocks.INCORRECT_FOR_NAUGHT_IRON_TOOL)
                .addTag(ModTags.Blocks.NEEDS_JEFF_LIKE_TOOL)
                .add(
                );
        tag(ModTags.Blocks.NEEDS_JEFF_LIKE_TOOL)
                .add(
                        BlockItemIds.BEDROCK.block()
                );
        tag(ModTags.Blocks.INCORRECT_FOR_JEFF_LIKE_TOOL)
                .add(
                );
        tag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL).addTag(ModTags.Blocks.NEEDS_NAUGHT_IRON_TOOL).addTag(ModTags.Blocks.NEEDS_JEFF_LIKE_TOOL);
        tag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL).addTag(ModTags.Blocks.NEEDS_NAUGHT_IRON_TOOL).addTag(ModTags.Blocks.NEEDS_JEFF_LIKE_TOOL);
        tag(BlockTags.INCORRECT_FOR_IRON_TOOL).addTag(ModTags.Blocks.NEEDS_NAUGHT_IRON_TOOL).addTag(ModTags.Blocks.NEEDS_JEFF_LIKE_TOOL);
        tag(BlockTags.INCORRECT_FOR_COPPER_TOOL).addTag(ModTags.Blocks.NEEDS_NAUGHT_IRON_TOOL).addTag(ModTags.Blocks.NEEDS_JEFF_LIKE_TOOL);
        tag(BlockTags.INCORRECT_FOR_STONE_TOOL).addTag(ModTags.Blocks.NEEDS_NAUGHT_IRON_TOOL).addTag(ModTags.Blocks.NEEDS_JEFF_LIKE_TOOL);
        tag(BlockTags.INCORRECT_FOR_GOLD_TOOL).addTag(ModTags.Blocks.NEEDS_NAUGHT_IRON_TOOL).addTag(ModTags.Blocks.NEEDS_JEFF_LIKE_TOOL);
        tag(BlockTags.INCORRECT_FOR_WOODEN_TOOL).addTag(ModTags.Blocks.NEEDS_NAUGHT_IRON_TOOL).addTag(ModTags.Blocks.NEEDS_JEFF_LIKE_TOOL);




    }
}
