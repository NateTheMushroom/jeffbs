package net.mshm.jeffbs.item.custom;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.mshm.jeffbs.block.ModBlocks;

import java.util.Map;

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
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();
        if(NAUGHT_MAP.containsKey(clickedBlock) && /*'!' means negate, so this sets it to the server only*/!level.isClientSide()) {
            level.setBlockAndUpdate(context.getClickedPos(), NAUGHT_MAP.get(clickedBlock).defaultBlockState());
            context.getItemInHand().hurtAndBreak(1, context.getPlayer(), context.getHand());
        }


        return InteractionResult.SUCCESS;
    }

    @Override
    public boolean isFoil(ItemStack itemStack) {
        return super.isFoil(itemStack);
    }
}
