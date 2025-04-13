package fr.skymmc.newskymcore.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {

    public static final FoodProperties SUSHI_FOOD = new FoodProperties.Builder()
            .nutrition(6)
            .saturationModifier(1.5f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 500), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 500), 1f)
            .build();

}
