package fr.skymmc.newskymcore.datagen;

import fr.skymmc.newskymcore.NewSkymCore;
import fr.skymmc.newskymcore.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
    private static final LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, NewSkymCore.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.NONAME_INGOT.get());
        basicItem(ModItems.NONAME_RAW_ORE.get());

        handhelItem(ModItems.NONAME_PICKAXE);
        handhelItem(ModItems.NONAME_SWORD);
        handhelItem(ModItems.NONAME_SHOVEL);
        handhelItem(ModItems.NONAME_AXE);
        handhelItem(ModItems.NONAME_HOE);

        handhelItem(ModItems.IRON_HAMMER_ITEM);
        handhelItem(ModItems.GOLD_HAMMER_ITEM);
        handhelItem(ModItems.DIAMOND_HAMMER_ITEM);
        handhelItem(ModItems.NETHERITE_HAMMER_ITEM);
        handhelItem(ModItems.NONAME_HAMMER_ITEM);

        handhelItem(ModItems.NONAME_HELMET);
        handhelItem(ModItems.NONAME_CHESTPLATE);
        handhelItem(ModItems.NONAME_LEGGINGS);
        handhelItem(ModItems.NONAME_BOOTS);
        trimmedArmorItem(ModItems.NONAME_HELMET);
        trimmedArmorItem(ModItems.NONAME_CHESTPLATE);
        trimmedArmorItem(ModItems.NONAME_LEGGINGS);
        trimmedArmorItem(ModItems.NONAME_BOOTS);
    }

    private void handhelItem(DeferredItem<?> item){
        withExistingParent(item.getRegisteredName(), mcLoc("item/handheld")).texture("layer0", getTextureName(item));
    }

    // Shoutout to El_Redstoniano for making this
    private void trimmedArmorItem(DeferredItem<ArmorItem> itemDeferredItem) {
        final String MOD_ID = NewSkymCore.MODID;

        ArmorItem armorItem = itemDeferredItem.get();
        trimMaterials.forEach((trimMaterial, value) -> {
            float trimValue = value;

            String armorType = switch (armorItem.getEquipmentSlot()) {
                case HEAD -> "helmet";
                case CHEST -> "chestplate";
                case LEGS -> "leggings";
                case FEET -> "boots";
                default -> "";
            };

            String armorItemPath = armorItem.toString();
            String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
            String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
            ResourceLocation armorItemResLoc = ResourceLocation.parse(armorItemPath);
            ResourceLocation trimResLoc = ResourceLocation.parse(trimPath); // minecraft namespace
            ResourceLocation trimNameResLoc = ResourceLocation.parse(currentTrimName);

            // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
            // avoid an IllegalArgumentException
            existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

            // Trimmed armorItem files
            getBuilder(currentTrimName)
                    .parent(new ModelFile.UncheckedModelFile("item/generated"))
                    .texture("layer0", armorItemResLoc.getNamespace() + ":item/" + armorItemResLoc.getPath())
                    .texture("layer1", trimResLoc);

            // Non-trimmed armorItem file (normal variant)
            this.withExistingParent(itemDeferredItem.getId().getPath(),
                            mcLoc("item/generated"))
                    .override()
                    .model(new ModelFile.UncheckedModelFile(trimNameResLoc.getNamespace() + ":item/" + trimNameResLoc.getPath()))
                    .predicate(mcLoc("trim_type"), trimValue).end()
                    .texture("layer0",
                            ResourceLocation.fromNamespaceAndPath(MOD_ID,
                                    "item/" + itemDeferredItem.getId().getPath()));
        });
    }

    private String getTextureName(DeferredItem<?> item){
        String itemName = item.getRegisteredName().split(":")[1];
        return "item/" + itemName;
    }
}
