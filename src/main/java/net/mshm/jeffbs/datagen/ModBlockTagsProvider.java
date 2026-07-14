package net.mshm.jeffbs.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.mshm.jeffbs.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {
    public ModBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.IRON_STAIRS)
                .add(ModBlocks.IRON_SLAB)
                .add(ModBlocks.IRON_FENCE)
                .add(ModBlocks.IRON_FENCE_GATE)
                .add(ModBlocks.IRON_WALL)
                .add(ModBlocks.NAUGHT_IRON_BLOCK)
                .add(ModBlocks.NAUGHT_RAW_IRON_BLOCK)
                .add(ModBlocks.NAUGHT_IRON_ORE)
                .add(ModBlocks.NAUGHT_DEEPSLATE_IRON_ORE)
                .add(ModBlocks.NAUGHT_IRON_STAIRS)
                .add(ModBlocks.NAUGHT_IRON_SLAB)
                .add(ModBlocks.NAUGHT_IRON_FENCE)
                .add(ModBlocks.NAUGHT_IRON_FENCE_GATE)
                .add(ModBlocks.NAUGHT_IRON_WALL);

        valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.NAUGHT_IRON_BLOCK)
                .add(ModBlocks.NAUGHT_RAW_IRON_BLOCK)
                .add(ModBlocks.NAUGHT_DEEPSLATE_IRON_ORE);
        valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.NAUGHT_IRON_ORE);

        valueLookupBuilder(BlockTags.STAIRS)
                .add(ModBlocks.IRON_STAIRS)
                .add(ModBlocks.NAUGHT_IRON_STAIRS);
        valueLookupBuilder(BlockTags.SLABS)
                .add(ModBlocks.IRON_SLAB)
                .add(ModBlocks.NAUGHT_IRON_SLAB);
        valueLookupBuilder(BlockTags.BUTTONS)
                .add(ModBlocks.NAUGHT_IRON_BUTTON);
        valueLookupBuilder(BlockTags.PRESSURE_PLATES)
                .add(ModBlocks.NAUGHT_IRON_PRESSUREPLATE);
        //fences&walls required
        valueLookupBuilder(BlockTags.FENCES)
                .add(ModBlocks.IRON_FENCE)
                .add(ModBlocks.NAUGHT_IRON_FENCE);
            valueLookupBuilder(BlockTags.WOODEN_FENCES)
                    .add(ModBlocks.NAUGHT_IRON_FENCE);
        valueLookupBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.IRON_FENCE_GATE)
                .add(ModBlocks.NAUGHT_IRON_FENCE_GATE);
        valueLookupBuilder(BlockTags.WALLS)
                .add(ModBlocks.IRON_WALL)
                .add(ModBlocks.NAUGHT_IRON_WALL);
    }
}
