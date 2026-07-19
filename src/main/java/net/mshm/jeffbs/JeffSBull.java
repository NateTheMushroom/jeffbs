package net.mshm.jeffbs;

import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import net.mshm.jeffbs.block.ModBlocks;
import net.mshm.jeffbs.creativemodetab.ModCreativeModeTabs;
import net.mshm.jeffbs.data.ModDataComponents;
import net.mshm.jeffbs.item.ModItems;
import net.mshm.jeffbs.registries.ModFuels;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JeffSBull implements ModInitializer {
	public static final String MOD_ID = "jeffbs";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModCreativeModeTabs.registerModCreativeModeTabs();

        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModFuels.registerFuels();
        ModDataComponents.registerDataComponents();

	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}