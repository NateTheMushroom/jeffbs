package net.mshm.jeffbs.creativemodetab;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.mshm.jeffbs.JeffSBull;
import net.mshm.jeffbs.block.ModBlocks;
import net.mshm.jeffbs.item.ModItems;

public class ModCreativeModeTabs {
    public static final CreativeModeTab JEFFS_BS_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(JeffSBull.MOD_ID, "jeffs_bs_tab"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModItems.NAUGHT_RAW_IRON))
                    .title(Component.translatable("creativemodetab.jeffsbs.jeffs_bs_tab"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.NAUGHT_RAW_IRON);
                        output.accept(ModItems.NAUGHT_IRON_INGOT);
                        output.accept(ModItems.FOFERROR);
                        output.accept(ModItems.DEBUGGER);
                        output.accept(ModItems.FRIED_EGG);
                        output.accept(ModItems.COLE);

                        output.accept(ModItems.PICKAXE_TOOL_EXE);
                        output.accept(ModItems.AXE_TOOL_EXE);
                        output.accept(ModItems.HOE_TOOL_EXE);
                        output.accept(ModItems.SHOVEL_TOOL_EXE);
                        output.accept(ModItems.SWORD_TOOL_EXE);
                        output.accept(ModItems.SPEAR_TOOL_EXE);

                        output.accept(ModBlocks.NAUGHT_IRON_BLOCK);
                        output.accept(ModBlocks.NAUGHT_RAW_IRON_BLOCK);
                        output.accept(ModBlocks.NAUGHT_IRON_ORE);
                        output.accept(ModBlocks.NAUGHT_DEEPSLATE_IRON_ORE);
                        output.accept(ModBlocks.NAUGHTSQRD);
                        output.accept(ModBlocks.NAUGHT_IRON_STAIRS);
                        output.accept(ModBlocks.NAUGHT_IRON_SLAB);
                        output.accept(ModBlocks.NAUGHT_IRON_BUTTON);
                        output.accept(ModBlocks.NAUGHT_IRON_PRESSUREPLATE);
                        output.accept(ModBlocks.NAUGHT_IRON_FENCE);
                        output.accept(ModBlocks.NAUGHT_IRON_FENCE_GATE);
                        output.accept(ModBlocks.NAUGHT_IRON_WALL);
                        output.accept(ModBlocks.NAUGHT_IRON_DOOR);
                        output.accept(ModBlocks.NAUGHT_IRON_TRAPDOOR);


                    }).build());
    public static final CreativeModeTab JEFFS_EXTRA = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(JeffSBull.MOD_ID, "jeffs_extra"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.IRON_STAIRS))
                    .title(Component.translatable("creativemodetab.jeffsbs.jeffs_extra"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.IRON_STAIRS);
                        output.accept(ModBlocks.IRON_SLAB);
                        output.accept(ModBlocks.IRON_FENCE);
                        output.accept(ModBlocks.IRON_FENCE_GATE);
                        output.accept(ModBlocks.IRON_WALL);
                    }).build());

    public static void registerModCreativeModeTabs() {
        JeffSBull.LOGGER.info("Registering Creative mode tabs for " + JeffSBull.MOD_ID);
    }
}
