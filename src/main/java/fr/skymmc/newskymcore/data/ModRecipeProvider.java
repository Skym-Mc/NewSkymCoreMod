package fr.skymmc.newskymcore.data;

import com.google.common.collect.ImmutableList;
import fr.skymmc.newskymcore.NewSkymCore;
import fr.skymmc.newskymcore.common.register.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {

    public static final ImmutableList<ItemLike> NONAME_SMELTABLES = ImmutableList.of(ModItems.NONAME_RAW_ORE);

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider){
        super(output, lookupProvider);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput output) {
        NewSkymCore.LOGGER.debug("Debut de creation des recipe...");
        registerNonameOreRecipe(output);

        NewSkymCore.LOGGER.debug("Fin de creation des recipe");
    }

    private void registerNonameOreRecipe(RecipeOutput output){

        nineBlockStorageRecipes(output, ModItems.NONAME_BLOCK, ModItems.NONAME_INGOT);

        oreBlasting(output, ModItems.NONAME_RAW_ORE, ModItems.NONAME_INGOT, 1f, 100, "noname_ingot");
    }

    private void nineBlockStorageRecipes(RecipeOutput output, ItemLike itemPacked, ItemLike itemUnpacked){
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, itemUnpacked, 9)
                .requires(itemPacked)
                .unlockedBy(getHasName(itemPacked), has(itemPacked))
                .save(output, ResourceLocation.fromNamespaceAndPath(NewSkymCore.MODID, getItemName(itemUnpacked)));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, itemPacked)
                .define('#', itemUnpacked)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy(getHasName(itemUnpacked), has(itemUnpacked))
                .save(output, ResourceLocation.fromNamespaceAndPath(NewSkymCore.MODID, getItemName(itemPacked)));
    }

    private void oreSmelting(RecipeOutput output, ItemLike itemSource, ItemLike itemSmelted, float experience, int cookingTime, String group){
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(itemSource),
                    RecipeCategory.MISC,
                itemSmelted,
                experience,
                cookingTime)
                .unlockedBy(getHasName(itemSmelted), has(itemSmelted))
                .save(output, ResourceLocation.fromNamespaceAndPath(NewSkymCore.MODID, group + "_from_smelting"));
    }

    private void oreBlasting(RecipeOutput output, ItemLike itemSource, ItemLike itemBlasted, float experience, int cookingTime, String group){
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(itemSource),
                    RecipeCategory.MISC,
                    itemBlasted,
                    experience,
                    cookingTime
                    )
                .unlockedBy(getHasName(itemBlasted), has(itemBlasted))
                .save(output, ResourceLocation.fromNamespaceAndPath(NewSkymCore.MODID, group + "_from_blasting"));

        oreSmelting(output, itemSource, itemBlasted, experience, cookingTime * 2, group);
    }
}
