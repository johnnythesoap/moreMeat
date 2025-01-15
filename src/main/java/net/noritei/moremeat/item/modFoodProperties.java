package net.noritei.moremeat.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;

public class modFoodProperties {
    public static final FoodProperties COOKED_CREEPER_MEAT = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.2f)
            .usingConvertsTo(Items.BONE)
            .build();

    public static final FoodProperties CREEPER_MEAT = new FoodProperties.Builder()
            .nutrition(1)
            .saturationModifier(0.1f)
            .usingConvertsTo(Items.BONE)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 200), 0.6f)
            .effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 200, 1), 0.6f)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 200, 1), 0.6f)
            .build();

    public static final FoodProperties FLESH = new FoodProperties.Builder()
            .nutrition(1)
            .saturationModifier(0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 200), 0.6f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100), 0.3f)
            .effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 200), 0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 200), 0.3f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 200), 0.3f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200), 0.1f)
            .build();

}
