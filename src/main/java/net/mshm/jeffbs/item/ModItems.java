package net.mshm.jeffbs.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.block.Block;
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

//tools to combine into a multitool when I learn how
        public static final Item PICKAXE_TOOL_EXE = registerItem("pickaxe_tool_exe", properties ->  new Item(properties
                .pickaxe(
                        ModToolMaterials.NAUGHT_IRON,
                        5.0f,
                        -2f)){
        });
        public static final Item AXE_TOOL_EXE = registerItem("axe_tool_exe", properties ->  new AxeItem(
                        ModToolMaterials.NAUGHT_IRON,
                        5.0f,
                        -2f,
                        properties){
        });
        public static final Item HOE_TOOL_EXE = registerItem("hoe_tool_exe", properties ->  new HoeItem(
                        ModToolMaterials.NAUGHT_IRON,
                        5.0f,
                        -2f,
                        properties){
        });
        public static final Item SHOVEL_TOOL_EXE = registerItem("shovel_tool_exe", properties ->  new ShovelItem(
                        ModToolMaterials.NAUGHT_IRON,
                        5.0f,
                        -2f,
                        properties){
        });
        public static final Item SWORD_TOOL_EXE = registerItem("sword_tool_exe", properties ->  new Item(properties
                .sword(
                        ModToolMaterials.NAUGHT_IRON,
                        5.0f,
                        -2f)){
        });
        public static final Item SPEAR_TOOL_EXE = registerItem("spear_tool_exe", properties ->  new Item(properties
                .spear(
                        ModToolMaterials.NAUGHT_IRON,
                        1.25f,
                        1.404f,
                        0.404f,
                        2f,
                        8f,
                        4.04f,
                        5.1f,
                        8f,
                        4.6f)){
        });
//above are tools for combining into a multitool somehow



    public static final Item JEANS = registerItem("jeans", properties ->  new Item(properties
            .humanoidArmor(
                    ModArmourMaterials.DENIM_ARMOUR_MATERIAL,
                    ArmorType.LEGGINGS)){
        @Override
        public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
            builder.accept(Component.translatable("tooltip.jeffbs.jeans"));
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
