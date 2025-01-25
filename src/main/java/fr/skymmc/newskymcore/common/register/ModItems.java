package fr.skymmc.newskymcore.common.register;

import fr.skymmc.newskymcore.NewSkymCore;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(NewSkymCore.MODID);

    public static final DeferredItem<Item> NONAME_INGOT     = ITEMS.registerSimpleItem("noname_ingot");
    public static final DeferredItem<Item> NONAME_RAW_ORE   = ITEMS.registerSimpleItem("noname_raw_ore");


    public static final DeferredItem<BlockItem> NONAME_BLOCK        = ITEMS.registerSimpleBlockItem(ModBlocks.NONAME_BLOCK);
    public static final DeferredItem<BlockItem> NONAME_ORE_BLOCK    = ITEMS.registerSimpleBlockItem(ModBlocks.NONAME_ORE_BLOCK);
}
