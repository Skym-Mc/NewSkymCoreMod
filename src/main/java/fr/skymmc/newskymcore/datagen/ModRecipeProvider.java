package fr.skymmc.newskymcore.datagen;

import com.google.common.collect.ImmutableList;
import fr.skymmc.newskymcore.NewSkymCore;
import fr.skymmc.newskymcore.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
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
        registerNonameOreRecipe(output);
    }

    private void registerNonameOreRecipe(RecipeOutput output){

        nineBlockStorageRecipes(output, ModItems.NONAME_BLOCK, ModItems.NONAME_INGOT);

        oreBlasting(output, ModItems.NONAME_RAW_ORE, ModItems.NONAME_INGOT, 1f, 100, "noname_ingot");
        oreBlasting(output, ModItems.NONAME_ORE_BLOCK, ModItems.NONAME_INGOT, 2f, 100, "noname_ingot_from_ore");

        pickaxeCrafting(output, ModItems.NONAME_INGOT, ModItems.NONAME_PICKAXE, "noname");
        swordCrafting(output, ModItems.NONAME_INGOT, ModItems.NONAME_SWORD, "noname");
        shovelCrafting(output, ModItems.NONAME_INGOT, ModItems.NONAME_SHOVEL, "noname");
        axeCrafting(output, ModItems.NONAME_INGOT, ModItems.NONAME_AXE, "noname");
        hoeCrafting(output, ModItems.NONAME_INGOT, ModItems.NONAME_AXE, "noname");

        hammerCrafting(output, Items.IRON_INGOT, ModItems.IRON_HAMMER_ITEM, "iron");
        hammerCrafting(output, Items.GOLD_INGOT, ModItems.GOLD_HAMMER_ITEM, "gold");
        hammerCrafting(output, Items.DIAMOND, ModItems.DIAMOND_HAMMER_ITEM, "diamond");
        hammerCrafting(output, Items.NETHERITE_INGOT, ModItems.NETHERITE_HAMMER_ITEM, "netherite");
        hammerCrafting(output, ModItems.NONAME_INGOT, ModItems.NONAME_HAMMER_ITEM, "noname");

        helmetCrafting(output, ModItems.NONAME_INGOT, ModItems.NONAME_HELMET, "noname");
        chestplateCrafting(output, ModItems.NONAME_INGOT, ModItems.NONAME_CHESTPLATE, "noname");
        legginsCrafting(output, ModItems.NONAME_INGOT, ModItems.NONAME_LEGGINGS, "noname");
        bootsCrafting(output, ModItems.NONAME_INGOT, ModItems.NONAME_BOOTS, "noname");
    }


    /* -------------------- Méthode utilitaire pour la création de recette -------------------- */

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

    private void swordCrafting(RecipeOutput output, ItemLike itemSource, ItemLike itemOutput, String materialName){
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, itemOutput)
                .define('#', itemSource)
                .define('|', Items.STICK)
                .pattern("#")
                .pattern("#")
                .pattern("|")
                .unlockedBy(getHasName(itemSource), has(itemSource))
                .save(output, ResourceLocation.fromNamespaceAndPath(NewSkymCore.MODID, materialName + "_sword"));
    }

    private void pickaxeCrafting(RecipeOutput output, ItemLike itemSource, ItemLike itemOutput, String materialName){
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, itemOutput)
                .define('#', itemSource)
                .define('|', Items.STICK)
                .pattern("###")
                .pattern(" | ")
                .pattern(" | ")
                .unlockedBy(getHasName(itemSource), has(itemSource))
                .save(output, ResourceLocation.fromNamespaceAndPath(NewSkymCore.MODID, materialName + "_pickaxe"));
    }

    private void axeCrafting(RecipeOutput output, ItemLike itemSource, ItemLike itemOutput, String materialName){
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, itemOutput)
                .define('#', itemSource)
                .define('|', Items.STICK)
                .pattern("##")
                .pattern("#|")
                .pattern(" |")
                .unlockedBy(getHasName(itemSource), has(itemSource))
                .save(output, ResourceLocation.fromNamespaceAndPath(NewSkymCore.MODID, materialName + "_axe_left"));


        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, itemOutput)
                .define('#', itemSource)
                .define('|', Items.STICK)
                .pattern("##")
                .pattern("|#")
                .pattern("| ")
                .unlockedBy(getHasName(itemSource), has(itemSource))
                .save(output, ResourceLocation.fromNamespaceAndPath(NewSkymCore.MODID, materialName + "_axe_right"));
    }

    private void shovelCrafting(RecipeOutput output, ItemLike itemSource, ItemLike itemOutput, String materialName){
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, itemOutput)
                .define('#', itemSource)
                .define('|', Items.STICK)
                .pattern("#")
                .pattern("|")
                .pattern("|")
                .unlockedBy(getHasName(itemSource), has(itemSource))
                .save(output, ResourceLocation.fromNamespaceAndPath(NewSkymCore.MODID, materialName + "_shovel"));
    }

    private void hoeCrafting(RecipeOutput output, ItemLike itemSource, ItemLike itemOutput, String materialName){
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, itemOutput)
                .define('#', itemSource)
                .define('|', Items.STICK)
                .pattern("##")
                .pattern(" |")
                .pattern(" |")
                .unlockedBy(getHasName(itemSource), has(itemSource))
                .save(output, ResourceLocation.fromNamespaceAndPath(NewSkymCore.MODID, materialName + "_hoe_left"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, itemOutput)
                .define('#', itemSource)
                .define('|', Items.STICK)
                .pattern("##")
                .pattern("| ")
                .pattern("| ")
                .unlockedBy(getHasName(itemSource), has(itemSource))
                .save(output, ResourceLocation.fromNamespaceAndPath(NewSkymCore.MODID, materialName + "_hoe_right"));
    }

    private void hammerCrafting(RecipeOutput output, ItemLike itemSource, ItemLike itemOutput, String materialName){
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, itemOutput)
                .define('#', itemSource)
                .define('|', Items.STICK)
                .pattern("###")
                .pattern("###")
                .pattern(" | ")
                .unlockedBy(getHasName(itemSource), has(itemSource))
                .save(output, ResourceLocation.fromNamespaceAndPath(NewSkymCore.MODID, materialName + "_hammer"));
    }

    private void helmetCrafting(RecipeOutput output, ItemLike itemSource, ItemLike itemOutput, String materialName){
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, itemOutput)
                .define('#', itemSource)
                .pattern("###")
                .pattern("# #")
                .unlockedBy(getHasName(itemSource), has(itemSource))
                .save(output, ResourceLocation.fromNamespaceAndPath(NewSkymCore.MODID, materialName + "_helmet"));
    }

    private void chestplateCrafting(RecipeOutput output, ItemLike itemSource, ItemLike itemOutput, String materialName){
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, itemOutput)
                .define('#', itemSource)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .unlockedBy(getHasName(itemSource), has(itemSource))
                .save(output, ResourceLocation.fromNamespaceAndPath(NewSkymCore.MODID, materialName + "_chestplate"));
    }

    private void legginsCrafting(RecipeOutput output, ItemLike itemSource, ItemLike itemOutput, String materialName){
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, itemOutput)
                .define('#', itemSource)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .unlockedBy(getHasName(itemSource), has(itemSource))
                .save(output, ResourceLocation.fromNamespaceAndPath(NewSkymCore.MODID, materialName + "_leggins"));
    }

    private void bootsCrafting(RecipeOutput output, ItemLike itemSource, ItemLike itemOutput, String materialName){
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, itemOutput)
                .define('#', itemSource)
                .pattern("# #")
                .pattern("# #")
                .unlockedBy(getHasName(itemSource), has(itemSource))
                .save(output, ResourceLocation.fromNamespaceAndPath(NewSkymCore.MODID, materialName + "_boots"));
    }
}
