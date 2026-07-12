package net.mshm.jeffbs.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.mshm.jeffbs.JeffSBull;
import net.mshm.jeffbs.food.ModFoods;
import net.mshm.jeffbs.item.custom.DebuggerItem;

import java.util.function.Consumer;
import java.util.function.Function;

public class ModItems {

    public static final Item NAUGHT_IRON_INGOT = registerItem("naught_iron_ingot", Item::new);
    public static final Item NAUGHT_RAW_IRON = registerItem("naught_raw_iron", Item::new);
    public static final Item FOFERROR = registerItem("404error", Item::new);

        //custom items
    public static final Item DEBUGGER = registerItem("debugger", properties -> new DebuggerItem(properties.durability(404)));

    public static  final Item FRIED_EGG = registerItem("fried_egg", properties -> new Item(properties
            .food(ModFoods.FRIED_EGG, ModFoods.FRIED_EGG_CONSUMABLE).stacksTo(1)));

    public static final Item COLE = registerItem("cole", properties ->  new Item(properties){
        @Override
        public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
            builder.accept(Component.translatable("tooltip.jeffbs.cole"));
            super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
        }
    });



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
