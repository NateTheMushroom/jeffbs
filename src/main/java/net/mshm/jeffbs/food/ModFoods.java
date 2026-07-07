package net.mshm.jeffbs.food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public class ModFoods {
    public static final FoodProperties FRIED_EGG = new FoodProperties.Builder().nutrition(1).saturationModifier(0.25f).build();

    public static final Consumable FRIED_EGG_CONSUMABLE = Consumables.defaultFood()
            .consumeSeconds(1.6f).onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.GLOWING, 20), 1f)).build();
}
