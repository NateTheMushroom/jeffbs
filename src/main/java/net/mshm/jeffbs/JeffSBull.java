package net.mshm.jeffbs;

import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import net.mshm.jeffbs.creativemodetab.ModCreativeModeTabs;
import net.mshm.jeffbs.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JeffSBull implements ModInitializer {
	public static final String MOD_ID = "jeffbs";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModCreativeModeTabs.registerModCreativeModeTabs();

        ModItems.registerModItems();

	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
//totally not test comment ong fr