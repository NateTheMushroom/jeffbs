package net.mshm.jeffbs.item;

import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.mshm.jeffbs.JeffSBull;
import net.mshm.jeffbs.tags.ModTags;

public class ModArmourMaterials {
    public static final ResourceKey<? extends Registry<EquipmentAsset>>
            REGISTRY_KEY = ResourceKey.createRegistryKey(Identifier.withDefaultNamespace("equipment_asset"));

    public static final ResourceKey<EquipmentAsset>
            DENIM_KEY = ResourceKey.create(REGISTRY_KEY, Identifier.fromNamespaceAndPath(JeffSBull.MOD_ID, "denim_key"));


    public static final ArmorMaterial DENIM_ARMOUR_MATERIAL = new ArmorMaterial(
            30,
            ArmorMaterials.makeDefense(0, 5, 7, 0, 0),
            20, SoundEvents.ARMOR_UNEQUIP_NAUTILUS,
            8.0f, 0.0f,
           //^^^^^^^^^^^^^takes less damage than netherite leggings at 25 damage and onward when paired with netherite boots, chest, & helm
            ModTags.Items.NAUGHT_IRON_REPAIR,
            DENIM_KEY);
}
