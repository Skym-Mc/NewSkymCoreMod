package fr.skymmc.newskymcore.data;

import fr.skymmc.newskymcore.NewSkymCore;
import fr.skymmc.newskymcore.common.register.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider){
        super(output, lookupProvider);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput output) {
        registerNonameOreRecipe(output);
    }

    private static void registerNonameOreRecipe(RecipeOutput output){
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.NONAME_BLOCK, 1)
                .requires(ModItems.NONAME_INGOT, 9)
                .unlockedBy("has_noname_ingot", has(ModItems.NONAME_INGOT))
                .save(output, ResourceLocation.fromNamespaceAndPath(NewSkymCore.MODID, "noname_block_from_ingot"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.NONAME_INGOT, 9)
                .requires(ModItems.NONAME_BLOCK, 1)
                .unlockedBy("has_noname_block", has(ModItems.NONAME_BLOCK))
                .save(output, ResourceLocation.fromNamespaceAndPath(NewSkymCore.MODID, "noname_ingot_from_block"));
    }

}
