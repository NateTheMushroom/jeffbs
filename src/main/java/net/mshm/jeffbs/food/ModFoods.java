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


    public static final FoodProperties BANANA = new FoodProperties.Builder().nutrition(4).saturationModifier(0.25f).build();

    public static final FoodProperties SOUR_DOUGH = new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).build();
    public static final Consumable SOUR_DOUGH_CONSUMABLE = Consumables.defaultFood()
            .consumeSeconds(1.6f)
            .onConsume(new ApplyStatusEffectsConsumeEffect(new
                    MobEffectInstance(MobEffects.SATURATION, 600/*30s*/), 1f))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new
                    MobEffectInstance(MobEffects.FIRE_RESISTANCE, 2400/*2m*/), 1f))
            .build();
}
