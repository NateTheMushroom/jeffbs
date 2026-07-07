package net.mshm.jeffbs;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.mshm.jeffbs.datagen.ModBlockLootTableProvider;
import net.mshm.jeffbs.datagen.ModBlockTagsProvider;
import net.mshm.jeffbs.datagen.ModModelProvider;
import net.mshm.jeffbs.datagen.ModRecipeProvider;

public class JeffSBullDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        var pack = fabricDataGenerator.createPack();

        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModBlockTagsProvider::new);
        pack.addProvider(ModBlockLootTableProvider::new);
        pack.addProvider(ModRecipeProvider::new);

	}
}
