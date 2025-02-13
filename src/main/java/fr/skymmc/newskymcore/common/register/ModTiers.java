package fr.skymmc.newskymcore.common.register;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModTiers {

    public static final Tier NONAME_TIER = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_NONAME_TOOL, 3451, 12.0F, 6.0F, 22, () -> Ingredient.of(ModItems.NONAME_INGOT));

}