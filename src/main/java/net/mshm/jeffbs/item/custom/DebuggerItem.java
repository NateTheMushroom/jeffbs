package net.mshm.jeffbs.item.custom;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.mshm.jeffbs.block.ModBlocks;
import net.mshm.jeffbs.data.ModDataComponents;

import java.util.Map;
import java.util.function.Consumer;

public class DebuggerItem extends Item {
    private static final Map<Block, Block> NAUGHT_MAP =
            Map.of(
                    ModBlocks.NAUGHT_IRON_BLOCK, Blocks.IRON_BLOCK,
                    ModBlocks.NAUGHT_RAW_IRON_BLOCK, Blocks.RAW_IRON_BLOCK,
                    ModBlocks.NAUGHT_IRON_ORE, Blocks.IRON_ORE,
                    ModBlocks.NAUGHT_DEEPSLATE_IRON_ORE, Blocks.DEEPSLATE_IRON_ORE
            );

    public DebuggerItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {

        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();/*vvv'!' means negate, so this sets it to the server only*/
        if(NAUGHT_MAP.containsKey(clickedBlock) && /*                                 */!level.isClientSide()) {
            level.setBlockAndUpdate(context.getClickedPos(), NAUGHT_MAP.get(clickedBlock).defaultBlockState());
            context.getItemInHand().hurtAndBreak(1, context.getPlayer(), context.getHand());

            context.getItemInHand().set(ModDataComponents.COORDINATES, context.getClickedPos());

        }


        return InteractionResult.SUCCESS;
    }

    private static final MutableComponent LITERAL_TOOLTIP = Component.translatable("tooltip.jeffbs.debugger.shift_down");

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
        builder.accept(Component.translatable("tooltip.jeffbs.debugger.a"));
        if (Minecraft.getInstance().hasShiftDown()) {
            if(itemStack.has(ModDataComponents.COORDINATES)) {
                //builder.accept(Component.literal(Component.translatable("tooltip.jeffbs.debugger.shift_down") + " " + itemStack.get(ModDataComponents.COORDINATES)));
                builder.accept(Component.literal("Debugged @ coords: " + itemStack.get(ModDataComponents.COORDINATES)));
            } else {
                builder.accept(Component.translatable("tooltip.jeffbs.debugger.b"));
            }
        } else {
            builder.accept(Component.translatable("tooltip.jeffbs.debugger.shift_up"));
            }
        }

    @Override
    public boolean isFoil(ItemStack itemStack) {
        return super.isFoil(itemStack);
    }
}
