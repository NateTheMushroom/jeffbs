package net.mshm.jeffbs.stat;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.stats.Stat;
import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.Stats;
import net.mshm.jeffbs.JeffSBull;

public class ModStats {
    //public static final Stat<?> UHDSJND = makeCustomStat("hbfsdchjbncv");


    private static Stat<?> makeCustomStat(String key) {
        Identifier identifier = Identifier.fromNamespaceAndPath(JeffSBull.MOD_ID, key);
        Identifier newStat = Registry.register(BuiltInRegistries.CUSTOM_STAT, key, identifier);
        return Stats.CUSTOM.get(newStat, StatFormatter.DEFAULT);
    }

    public static void registerStats() {
        JeffSBull.LOGGER.info("Registering " + JeffSBull.MOD_ID + "Stats");
    }
}
