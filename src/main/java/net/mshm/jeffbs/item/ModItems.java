package net.mshm.jeffbs.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.mshm.jeffbs.JeffSBull;
import net.mshm.jeffbs.item.custom.DebuggerItem;

import java.util.function.Function;

public class ModItems {

    public static final Item NAUGHT_IRON_INGOT = registerItem("naught_iron_ingot", Item::new);
    public static final Item NAUGHT_RAW_IRON = registerItem("naught_raw_iron", Item::new);

        //custom items
    public static final Item DEBUGGER = registerItem("debugger", properties -> new DebuggerItem(properties.durability(404)));


    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(JeffSBull.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(JeffSBull.MOD_ID, name)))));
    }

    public static void registerModItems() {
        JeffSBull.LOGGER.info("Registering " + JeffSBull.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
            output.accept(NAUGHT_IRON_INGOT);
            output.accept(NAUGHT_RAW_IRON);
        });
    }
}
