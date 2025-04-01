package fr.skymmc.newskymcore.worldgen;

import fr.skymmc.newskymcore.NewSkymCore;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> NONAME_ORE_PLACED_KEY = registerKey("noname_ore_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configureFeature = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, NONAME_ORE_PLACED_KEY, configureFeature.getOrThrow(ModConfiguredFeature.OVERWORLD_NONAME_ORE_KEY),
                ModOrePlacement.commonOrePlacement(1, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(20))));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(NewSkymCore.MODID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
