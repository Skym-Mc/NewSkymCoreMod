package fr.skymmc.newskymcore.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class DataGenHandler {

    public static void onGatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(
          event.includeServer(),
          new ModRecipeProvider(output, lookupProvider)
        );

        generator.addProvider(
                event.includeServer(),
                new ModDatapackProvider(output, lookupProvider)
        );

        generator.addProvider(
                event.includeServer(),
                new LootTableProvider(output, Collections.emptySet(),
                        List.of(new LootTableProvider.SubProviderEntry(ModBlockLootTableProvider::new, LootContextParamSets.BLOCK)), lookupProvider)
        );

        generator.addProvider(
                event.includeClient(),
                new ModItemModelProvider(output, existingFileHelper)
        );

        generator.addProvider(
                event.includeClient(),
                new ModBlockStateProvider(output, existingFileHelper)
        );
    }

}
