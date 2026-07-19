package net.mshm.jeffbs.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.mshm.jeffbs.JeffSBull;


public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_NAUGHT_IRON_TOOL = createTag("needs_naught_iron_tool");
        public static final TagKey<Block> INCORRECT_FOR_NAUGHT_IRON_TOOL = createTag("incorrect_for_naught_iron_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(JeffSBull.MOD_ID, name));
        }
    }

  public static class Items {
        public static final TagKey<Item> ERROR_IRON = createTag("error_iron");

        public static final TagKey<Item> NAUGHT_IRON_REPAIR = createTag("naught_iron_repair");

      public static final TagKey<Item> CATAPULTABLE = createTag("catapultable");

        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(JeffSBull.MOD_ID, name));
        }
    }
}
