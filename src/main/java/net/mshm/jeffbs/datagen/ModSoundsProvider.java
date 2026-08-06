package net.mshm.jeffbs.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.builder.SoundTypeBuilder;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricSoundsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.mshm.jeffbs.JeffSBull;
import net.mshm.jeffbs.sound.ModSounds;

import java.util.concurrent.CompletableFuture;

public class ModSoundsProvider extends FabricSoundsProvider {
    public ModSoundsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider provider, SoundExporter soundExporter) {
        soundExporter.add(ModSounds.BUG, SoundTypeBuilder.of(ModSounds.BUG)
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(JeffSBull.MOD_ID, "bug_one")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(JeffSBull.MOD_ID, "bug_two")))
                .subtitle("sounds.jeffsbs.bug")
        );
    }

    @Override
    public String getName() {
        return "Jeff's Bull#### Sounds";
    }
}
