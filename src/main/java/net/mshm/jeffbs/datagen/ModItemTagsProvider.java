package net.mshm.jeffbs.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.mshm.jeffbs.item.ModItems;
import net.mshm.jeffbs.tags.ModTags;
import org.jspecify.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends FabricTagsProvider.ItemTagsProvider {
    public ModItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        valueLookupBuilder(ModTags.Items.ERROR_IRON)
                .add(ModItems.NAUGHT_RAW_IRON)
                .add(ModItems.NAUGHT_IRON_INGOT);

        valueLookupBuilder(ItemTags.PICKAXES)
                .add(ModItems.PICKAXE_TOOL_EXE);
        valueLookupBuilder(ItemTags.AXES)
                .add(ModItems.AXE_TOOL_EXE);
        valueLookupBuilder(ItemTags.HOES)
                .add(ModItems.HOE_TOOL_EXE);
        valueLookupBuilder(ItemTags.SHOVELS)
                .add(ModItems.SHOVEL_TOOL_EXE);
        valueLookupBuilder(ItemTags.SWORDS)
                .add(ModItems.SWORD_TOOL_EXE);
        valueLookupBuilder(ItemTags.SPEARS)
                .add(ModItems.SPEAR_TOOL_EXE);

        valueLookupBuilder(ItemTags.LEG_ARMOR)
                .add(ModItems.JEANS);    }
}
