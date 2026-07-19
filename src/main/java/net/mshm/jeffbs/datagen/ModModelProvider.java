package net.mshm.jeffbs.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.client.renderer.block.dispatch.Variant;
import net.minecraft.client.renderer.item.ClientItem;
import net.minecraft.client.renderer.item.ConditionalItemModel;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.properties.conditional.HasComponent;
import net.minecraft.client.resources.model.cuboid.ItemModelGenerator;
import net.minecraft.resources.Identifier;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.Blocks;
import net.mshm.jeffbs.block.ModBlocks;
import net.mshm.jeffbs.block.custom.NaughtsqrdBlock;
import net.mshm.jeffbs.data.ModDataComponents;
import net.mshm.jeffbs.item.ModArmourMaterials;
import net.mshm.jeffbs.item.ModItems;

import java.util.Optional;

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


        //blockModelGenerators.createTrivialCube(ModBlocks.NAUGHTSQRD);
        Identifier lampOffIdentifier =
                TexturedModel.CUBE.create(
                        ModBlocks.NAUGHTSQRD,
                        blockModelGenerators.modelOutput
                );
        Identifier lampOnIdentifier =
                blockModelGenerators.createSuffixedVariant(
                        ModBlocks.NAUGHTSQRD,
                        "_on",
                        ModelTemplates.CUBE_ALL,
                        TextureMapping::cube
                );

        blockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(ModBlocks.NAUGHTSQRD)
                .with(BlockModelGenerators.createBooleanModelDispatch(NaughtsqrdBlock.CLICKED,
                        new MultiVariant(WeightedList.<Variant>builder().add(new Variant(lampOnIdentifier)).build()),
                        new MultiVariant(WeightedList.<Variant>builder().add(new Variant(lampOffIdentifier)).build())
                )));



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


        //itemModelGenerators.generateFlatItem(ModItems.DEBUGGER, ModelTemplates.FLAT_HANDHELD_ITEM);
        ItemModel.Unbaked unbakedDebugger =
                ItemModelUtils.plainModel(
                        itemModelGenerators.createFlatItemModel(
                                ModItems.DEBUGGER,
                                ModelTemplates.FLAT_HANDHELD_ITEM));
        ItemModel.Unbaked unbakedEmptyDebugger =
                ItemModelUtils.plainModel(
                        itemModelGenerators.createFlatItemModel(
                                ModItems.DEBUGGER,
                                "_empty",
                                ModelTemplates.FLAT_HANDHELD_ITEM));

        itemModelGenerators.itemModelOutput.accept(ModItems.DEBUGGER,
                new ClientItem(new ConditionalItemModel.Unbaked(
                        Optional.empty(),
                        new HasComponent(ModDataComponents.COORDINATES, false),
                        unbakedEmptyDebugger, unbakedDebugger),
                        new ClientItem.Properties(
                                false,
                                false,
                                1f))
                        .model()
        );



        itemModelGenerators.generateFlatItem(ModItems.PICKAXE_TOOL_EXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.AXE_TOOL_EXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.HOE_TOOL_EXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SHOVEL_TOOL_EXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SWORD_TOOL_EXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateSpear(ModItems.SPEAR_TOOL_EXE);

        itemModelGenerators.createFlatItemModel(ModItems.CATAPULT, ModelTemplates.BOW);
        itemModelGenerators.generateBow(ModItems.CATAPULT);

        itemModelGenerators.generateTrimmableItem(ModItems.JEANS,
                ModArmourMaterials.DENIM_KEY,
                ItemModelGenerators.TRIM_PREFIX_LEGGINGS,
                false);

        itemModelGenerators.generateFlatItem(ModItems.HORSE_JEANS, ModelTemplates.FLAT_ITEM);
    }
}
