package net.mshm.jeffbs.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.advancements.predicates.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.mshm.jeffbs.block.ModBlocks;
import net.mshm.jeffbs.block.custom.BananaBushBlock;
import net.mshm.jeffbs.block.custom.NetherRootCropBlock;
import net.mshm.jeffbs.block.custom.SteelCropBlock;
import net.mshm.jeffbs.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootSubProvider {


    public ModBlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
        var enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

        dropSelf(ModBlocks.IRON_STAIRS);
        dropSelf(ModBlocks.IRON_FENCE);
        dropSelf(ModBlocks.IRON_FENCE_GATE);
        dropSelf(ModBlocks.IRON_WALL);
        dropSelf(ModBlocks.NAUGHT_IRON_BLOCK);
        dropSelf(ModBlocks.NAUGHT_RAW_IRON_BLOCK);
        dropSelf(ModBlocks.NAUGHT_IRON_STAIRS);
        dropSelf(ModBlocks.NAUGHT_IRON_BUTTON);
        dropSelf(ModBlocks.NAUGHT_IRON_PRESSUREPLATE);
        dropSelf(ModBlocks.NAUGHT_IRON_FENCE);
        dropSelf(ModBlocks.NAUGHT_IRON_FENCE_GATE);
        dropSelf(ModBlocks.NAUGHT_IRON_WALL);
        dropSelf(ModBlocks.NAUGHT_IRON_TRAPDOOR);
        dropSelf(ModBlocks.NAUGHTSQRD);
        dropSelf(ModBlocks.EAT_N_SPIT);

        add(ModBlocks.IRON_SLAB, this::createSlabItemTable);
        add(ModBlocks.NAUGHT_IRON_SLAB, this::createSlabItemTable);
        add(ModBlocks.NAUGHT_IRON_DOOR, this::createDoorTable);

        add(ModBlocks.NAUGHT_IRON_ORE, createMultiOreDrops(ModBlocks.NAUGHT_IRON_ORE, ModItems.NAUGHT_RAW_IRON, 0, 4));
        add(ModBlocks.NAUGHT_DEEPSLATE_IRON_ORE, createMultiOreDrops(ModBlocks.NAUGHT_DEEPSLATE_IRON_ORE, ModItems.NAUGHT_RAW_IRON, 0, 3));

        this.add(ModBlocks.STEEL_CROP, this.createCropDrops(ModBlocks.STEEL_CROP, ModItems.STEEL, ModItems.STEEL_OFFSPRING,
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.STEEL_CROP)
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SteelCropBlock.AGE, SteelCropBlock.MAX_AGE))));
        this.add(ModBlocks.NETHER_ROOT_CROP, this.createCropDrops(ModBlocks.NETHER_ROOT_CROP, ModItems.NETHER_ROOT, ModItems.NETHER_ROOT_SEEDS,
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.NETHER_ROOT_CROP)
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(NetherRootCropBlock.AGE, NetherRootCropBlock.MAX_AGE))));
        dropSelf(ModBlocks.NETHER_ROOT);

        this.add(ModBlocks.BANANA_BUSH, block -> this.applyExplosionDecay(block,
                LootTable.lootTable().withPool(
                        LootPool.lootPool()
                                .when(LootItemBlockStatePropertyCondition
                                        .hasBlockStateProperties(ModBlocks.BANANA_BUSH)
                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                        .hasProperty(
                                                                BananaBushBlock.AGE, 3)
                                                )
                                )
                                .add(LootItem.lootTableItem(ModItems.BANANA))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE)))
                ).withPool(
                        LootPool.lootPool()
                                .when(LootItemBlockStatePropertyCondition
                                        .hasBlockStateProperties(ModBlocks.BANANA_BUSH)
                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                        .hasProperty(
                                                                BananaBushBlock.AGE, 2)
                                                )
                                )
                                .add(LootItem.lootTableItem(ModItems.BANANA))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE)))
                )
        ));

    }

    public LootTable.Builder createMultiOreDrops(final Block block, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(block, this.applyExplosionDecay(
                block, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }
}
