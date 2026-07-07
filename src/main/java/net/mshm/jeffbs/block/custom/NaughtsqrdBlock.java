package net.mshm.jeffbs.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.mshm.jeffbs.block.ModBlocks;
import net.mshm.jeffbs.item.ModItems;

import java.util.Map;

public class NaughtsqrdBlock extends Block {
    private static final Map<Item, Item> IRON_MAP =
            Map.of(
                    Items.IRON_INGOT, ModItems.NAUGHT_IRON_INGOT,
                    Items.RAW_IRON, ModItems.NAUGHT_RAW_IRON,
                    Items.IRON_BLOCK, ModBlocks.NAUGHT_IRON_BLOCK.asItem(),
                    Items.RAW_IRON_BLOCK, ModBlocks.NAUGHT_RAW_IRON_BLOCK.asItem(),
                    Items.IRON_ORE, ModBlocks.NAUGHT_IRON_ORE.asItem(),
                    Items.DEEPSLATE_IRON_ORE, ModBlocks.NAUGHT_DEEPSLATE_IRON_ORE.asItem()
            );

    public NaughtsqrdBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        level.addParticle(ParticleTypes.GLOW, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, 0, 1, 0);

        level.playLocalSound(pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5,
                SoundEvents.GLASS_BREAK, SoundSource.MASTER, 40.4f, 4.04f, false);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState onState, Entity entity) {
        // effect to player
        if(entity instanceof Player player) {
            player.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 1, 404));
            player.addEffect(new MobEffectInstance(MobEffects.NAUSEA, 1, 404));
        }

        // bug iron
        if(entity instanceof ItemEntity itemEntity) {
            /*if(IRON_MAP.containsKey(itemEntity.getItem())) {
                itemEntity.setItem(new ItemStack(IRON_MAP.get(itemEntity), itemEntity.getItem().getCount()));
            }*/
            if(isValidItem(itemEntity.getItem())) {
                itemEntity.setItem(new ItemStack(IRON_MAP.getOrDefault(itemEntity.getItem(), Items.DIAMOND), itemEntity.getItem().getCount()));
            }
        }

        super.stepOn(level, pos, onState, entity);
    }

    private boolean isValidItem(ItemStack item) {
        return item.is(Items.IRON_INGOT) || (item.is(Items.RAW_IRON)) || item.is(Items.IRON_BLOCK) || item.is(Items.RAW_IRON_BLOCK)
                || item.is(Items.IRON_ORE) || item.is(Items.DEEPSLATE_IRON_ORE);
    }
}
