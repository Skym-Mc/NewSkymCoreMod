package fr.skymmc.newskymcore.datagen;

import fr.skymmc.newskymcore.block.ModBlocks;
import fr.skymmc.newskymcore.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.NONAME_BLOCK.get());

        add(ModBlocks.NONAME_ORE_BLOCK.get(),
                block -> createOreDrop(ModBlocks.NONAME_ORE_BLOCK.get(), ModItems.NONAME_RAW_ORE.get()));
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
