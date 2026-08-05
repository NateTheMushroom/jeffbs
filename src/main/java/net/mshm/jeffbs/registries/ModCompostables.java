package net.mshm.jeffbs.registries;

import net.fabricmc.fabric.api.registry.CompostableRegistry;
import net.mshm.jeffbs.item.ModItems;

public class ModCompostables {
    public static void registerCompostables() {
        CompostableRegistry.INSTANCE.add(ModItems.STEEL_OFFSPRING, 0.6f);
    }
}
