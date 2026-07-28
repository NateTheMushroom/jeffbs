package net.mshm.jeffbs.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.references.BlockItemIds;
import net.minecraft.references.BlockItemIds;
import net.minecraft.references.ItemIds;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Blocks;
import net.mshm.jeffbs.item.ModItems;
import net.mshm.jeffbs.tags.ModTags;

import java.util.concurrent.CompletableFuture;


public class ModItemTagsProvider extends FabricTagsProvider.ItemTagsProvider {
    public ModItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(ModTags.Items.ERROR_IRON)
                .add(ModItems.getRK(ModItems.NAUGHT_RAW_IRON))
                .add(ModItems.getRK(ModItems.NAUGHT_IRON_INGOT));

        tag(ItemTags.PICKAXES)
                .add(ModItems.getRK(ModItems.PICKAXE_TOOL_EXE));
        tag(ItemTags.AXES)
                .add(ModItems.getRK(ModItems.AXE_TOOL_EXE));
        tag(ItemTags.HOES)
                .add(ModItems.getRK(ModItems.HOE_TOOL_EXE));
        tag(ItemTags.SHOVELS)
                .add(ModItems.getRK(ModItems.SHOVEL_TOOL_EXE));
        tag(ItemTags.SWORDS)
                .add(
                        ModItems.getRK(ModItems.SWORD_TOOL_EXE),
                        ModItems.getRK(ModItems.STEFF_OF_JAFF)
                );
        tag(ItemTags.SPEARS)
                .add(
                        ModItems.getRK(ModItems.SPEAR_TOOL_EXE.asItem()),
                        ModItems.getRK(ModItems.STEFF_OF_JAFF)
                );
        tag(ItemTags.BOW_ENCHANTABLE)
                .add(ModItems.getRK(ModItems.CATAPULT));

        tag(ItemTags.LEG_ARMOR)
                .add(ModItems.getRK(ModItems.JEANS));


        tag(ModTags.Items.CATAPULTABLE)
                .forceAddTag(ItemTags.STONE_TOOL_MATERIALS)
                .forceAddTag(ItemTags.DIRT)
                .forceAddTag(ItemTags.SAND)
                .add(
                        BlockItemIds.STONE.item(),
                        BlockItemIds.GRANITE.item(),
                        BlockItemIds.ANDESITE.item(),
                        BlockItemIds.DIORITE.item(),
                        BlockItemIds.TUFF.item(),
                        BlockItemIds.SMOOTH_BASALT.item(),
                        BlockItemIds.DEEPSLATE.item(),
                        BlockItemIds.NETHERRACK.item(),
                        BlockItemIds.BASALT.item(),
                        BlockItemIds.TNT.item()

                );

    }
}
