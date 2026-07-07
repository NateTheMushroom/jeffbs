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
                        output.accept(ModItems.DEBUGGER);
                        output.accept(ModItems.FRIED_EGG);
                        output.accept(ModItems.COLE);

                        output.accept(ModBlocks.NAUGHT_IRON_BLOCK);
                        output.accept(ModBlocks.NAUGHT_RAW_IRON_BLOCK);
                        output.accept(ModBlocks.NAUGHT_IRON_ORE);
                        output.accept(ModBlocks.NAUGHT_DEEPSLATE_IRON_ORE);
                        output.accept(ModBlocks.NAUGHTSQRD);


                    }).build());

    public static void registerModCreativeModeTabs() {
        JeffSBull.LOGGER.info("Registering Creative mode tabs for " + JeffSBull.MOD_ID);
    }
}
