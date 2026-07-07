package net.mshm.jeffbs.registries;

import net.fabricmc.fabric.api.registry.FuelValueEvents;
import net.mshm.jeffbs.item.ModItems;

public class ModFuels {
    public static void registerFuels() {
        FuelValueEvents.BUILD.register((builder, context) -> {
            builder.add(ModItems.COLE, 3015);
        });
    }
}
