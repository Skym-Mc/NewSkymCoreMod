package fr.skymmc.newskymcore.datagen;

import fr.skymmc.newskymcore.NewSkymCore;
import fr.skymmc.newskymcore.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModItemModelProvider extends ItemModelProvider {
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

        handhelItem(ModItems.NONAME_HELMET);
        handhelItem(ModItems.NONAME_CHESTPLATE);
        handhelItem(ModItems.NONAME_LEGGINGS);
        handhelItem(ModItems.NONAME_BOOTS);
    }

    private void handhelItem(DeferredItem<?> item){
        withExistingParent(item.getRegisteredName(), mcLoc("item/handheld")).texture("layer0", getTextureName(item));
    }

    private String getTextureName(DeferredItem<?> item){
        String itemName = item.getRegisteredName().split(":")[1];
        return "item/" + itemName;
    }
}
