package net.mshm.jeffbs.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.mshm.jeffbs.block.ModBlocks;
import net.mshm.jeffbs.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createTrivialCube(ModBlocks.NAUGHT_IRON_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.NAUGHT_RAW_IRON_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.NAUGHT_IRON_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.NAUGHT_DEEPSLATE_IRON_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.NAUGHTSQRD);

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.NAUGHT_IRON_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.NAUGHT_RAW_IRON, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.FRIED_EGG, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.COLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.FOFERROR, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.DEBUGGER, ModelTemplates.FLAT_HANDHELD_ITEM);
    }
}
