package net.mshm.jeffbs.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.world.level.block.Blocks;
import net.mshm.jeffbs.block.ModBlocks;
import net.mshm.jeffbs.item.ModArmourMaterials;
import net.mshm.jeffbs.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        //blockModelGenerators.createTrivialCube(ModBlocks.NAUGHT_IRON_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.NAUGHT_RAW_IRON_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.NAUGHT_IRON_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.NAUGHT_DEEPSLATE_IRON_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.NAUGHTSQRD);

        blockModelGenerators.family(Blocks.IRON_BLOCK)
                .stairs(ModBlocks.IRON_STAIRS)
                .slab(ModBlocks.IRON_SLAB)
                .fence(ModBlocks.IRON_FENCE)
                .fenceGate(ModBlocks.IRON_FENCE_GATE)
                .wall(ModBlocks.IRON_WALL);
        blockModelGenerators.family(ModBlocks.NAUGHT_IRON_BLOCK)
                .stairs(ModBlocks.NAUGHT_IRON_STAIRS)
                .slab(ModBlocks.NAUGHT_IRON_SLAB)
                .button(ModBlocks.NAUGHT_IRON_BUTTON)
                .pressurePlate(ModBlocks.NAUGHT_IRON_PRESSUREPLATE)
                .fence(ModBlocks.NAUGHT_IRON_FENCE)
                .fenceGate(ModBlocks.NAUGHT_IRON_FENCE_GATE)
                .wall(ModBlocks.NAUGHT_IRON_WALL);
                blockModelGenerators.createDoor(ModBlocks.NAUGHT_IRON_DOOR);
                blockModelGenerators.createTrapdoor(ModBlocks.NAUGHT_IRON_TRAPDOOR);

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.NAUGHT_IRON_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.NAUGHT_RAW_IRON, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.FRIED_EGG, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.COLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.FOFERROR, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.DEBUGGER, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.PICKAXE_TOOL_EXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.AXE_TOOL_EXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.HOE_TOOL_EXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SHOVEL_TOOL_EXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SWORD_TOOL_EXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateSpear(ModItems.SPEAR_TOOL_EXE);

        itemModelGenerators.generateTrimmableItem(ModItems.JEANS,
                ModArmourMaterials.DENIM_KEY,
                ItemModelGenerators.TRIM_PREFIX_LEGGINGS,
                false);
    }
}
