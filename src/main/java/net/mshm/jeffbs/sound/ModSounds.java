package net.mshm.jeffbs.sound;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.mshm.jeffbs.JeffSBull;

public class ModSounds {
    public static final SoundEvent BUG = registerSoundEvent("bug");


    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.fromNamespaceAndPath(JeffSBull.MOD_ID, name);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
    }

    public static void registerSounds() {
        JeffSBull.LOGGER.info("Registering " + JeffSBull.MOD_ID + "sounds");
    }
}
