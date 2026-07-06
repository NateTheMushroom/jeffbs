package net.mshm.jeffbs.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.mshm.jeffbs.block.ModBlocks;
import net.mshm.jeffbs.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootSubProvider {


    public ModBlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {

        dropSelf(ModBlocks.NAUGHT_IRON_BLOCK);
        dropSelf(ModBlocks.NAUGHT_RAW_IRON_BLOCK);
        /*dropWhenSilkTouch(ModBlocks.NAUGHT_DEEPSLATE_IRON_ORE);
        dropWhenSilkTouch(ModBlocks.NAUGHT_IRON_ORE);*/

        add(ModBlocks.NAUGHT_IRON_ORE, createMultiOreDrops(ModBlocks.NAUGHT_IRON_ORE, ModItems.NAUGHT_RAW_IRON, 0, 4));
        add(ModBlocks.NAUGHT_DEEPSLATE_IRON_ORE, createMultiOreDrops(ModBlocks.NAUGHT_DEEPSLATE_IRON_ORE, ModItems.NAUGHT_RAW_IRON, 0, 3));

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
