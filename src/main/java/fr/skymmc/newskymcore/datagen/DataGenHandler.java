package fr.skymmc.newskymcore.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

public class DataGenHandler {

    public static void onGatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(
          event.includeServer(),
          new ModRecipeProvider(output, lookupProvider)
        );

        generator.addProvider(
                event.includeServer(),
                new ModDatapackProvider(output, lookupProvider)
        );
    }

}
