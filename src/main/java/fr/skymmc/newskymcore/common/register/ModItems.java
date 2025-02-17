package fr.skymmc.newskymcore.common.register;

import fr.skymmc.newskymcore.NewSkymCore;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(NewSkymCore.MODID);

    public static final DeferredItem<Item> NONAME_INGOT     = ITEMS.registerSimpleItem("noname_ingot");
    public static final DeferredItem<Item> NONAME_RAW_ORE   = ITEMS.registerSimpleItem("noname_raw_ore");


    public static final DeferredItem<BlockItem> NONAME_BLOCK        = ITEMS.registerSimpleBlockItem(ModBlocks.NONAME_BLOCK);
    public static final DeferredItem<BlockItem> NONAME_ORE_BLOCK    = ITEMS.registerSimpleBlockItem(ModBlocks.NONAME_ORE_BLOCK);

    public static final DeferredItem<PickaxeItem> NONAME_PICKAXE    = ITEMS.register("noname_pickaxe", () -> new PickaxeItem(
            ModTiers.NONAME_TIER,
            new Item.Properties().attributes(PickaxeItem.createAttributes(ModTiers.NONAME_TIER, 1.0F, -2.8F))
    ));
    public static final DeferredItem<SwordItem> NONAME_SWORD        = ITEMS.register("noname_sword", () -> new SwordItem(
            ModTiers.NONAME_TIER,
            new Item.Properties().attributes(PickaxeItem.createAttributes(ModTiers.NONAME_TIER, 3.0F, -2.4F))
    ));
    public static final DeferredItem<ShovelItem> NONAME_SHOVEL      = ITEMS.register("noname_shovel", () -> new ShovelItem(
            ModTiers.NONAME_TIER,
            new Item.Properties().attributes(PickaxeItem.createAttributes(ModTiers.NONAME_TIER, 1.5F, -3.0F))
    ));
    public static final DeferredItem<AxeItem> NONAME_AXE            = ITEMS.register("noname_axe", () -> new AxeItem(
            ModTiers.NONAME_TIER,
            new Item.Properties().attributes(PickaxeItem.createAttributes(ModTiers.NONAME_TIER, 5.0F, -3.0F))
    ));
    public static final DeferredItem<HoeItem> NONAME_HOE            = ITEMS.register("noname_hoe", () -> new HoeItem(
            ModTiers.NONAME_TIER,
            new Item.Properties().attributes(PickaxeItem.createAttributes(ModTiers.NONAME_TIER, -6.0F, 0.0F))
    ));
}
