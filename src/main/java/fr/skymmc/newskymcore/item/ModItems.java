package fr.skymmc.newskymcore.item;

import fr.skymmc.newskymcore.NewSkymCore;
import fr.skymmc.newskymcore.block.ModBlocks;
import fr.skymmc.newskymcore.item.custom.HammerItem;
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
            new Item.Properties().attributes(SwordItem.createAttributes(ModTiers.NONAME_TIER, 3.0F, -2.4F))
    ));
    public static final DeferredItem<ShovelItem> NONAME_SHOVEL      = ITEMS.register("noname_shovel", () -> new ShovelItem(
            ModTiers.NONAME_TIER,
            new Item.Properties().attributes(ShovelItem.createAttributes(ModTiers.NONAME_TIER, 1.5F, -3.0F))
    ));
    public static final DeferredItem<AxeItem> NONAME_AXE            = ITEMS.register("noname_axe", () -> new AxeItem(
            ModTiers.NONAME_TIER,
            new Item.Properties().attributes(AxeItem.createAttributes(ModTiers.NONAME_TIER, 5.0F, -3.0F))
    ));
    public static final DeferredItem<HoeItem> NONAME_HOE            = ITEMS.register("noname_hoe", () -> new HoeItem(
            ModTiers.NONAME_TIER,
            new Item.Properties().attributes(HoeItem.createAttributes(ModTiers.NONAME_TIER, -6.0F, 0.0F))
    ));

    public static final DeferredItem<ArmorItem> NONAME_HELMET       = ITEMS.register("noname_helmet", () -> new ArmorItem(
            ModArmorMaterials.NONAME_ARMOR_MATERIAL,
            ArmorItem.Type.HELMET,
            new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(63))
    ));
    public static final DeferredItem<ArmorItem> NONAME_CHESTPLATE   = ITEMS.register("noname_chestplate", () -> new ArmorItem(
            ModArmorMaterials.NONAME_ARMOR_MATERIAL,
            ArmorItem.Type.CHESTPLATE,
            new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(63))
    ));
    public static final DeferredItem<ArmorItem> NONAME_LEGGINGS = ITEMS.register("noname_leggings", () -> new ArmorItem(
            ModArmorMaterials.NONAME_ARMOR_MATERIAL,
            ArmorItem.Type.LEGGINGS,
            new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(63))
    ));
    public static final DeferredItem<ArmorItem> NONAME_BOOTS        = ITEMS.register("noname_boots", () -> new ArmorItem(
            ModArmorMaterials.NONAME_ARMOR_MATERIAL,
            ArmorItem.Type.BOOTS,
            new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(63))
    ));

    public static final DeferredItem<HammerItem> NONAME_HAMMER_ITEM = ITEMS.register("noname_hammer", () -> new HammerItem(
            ModTiers.NONAME_TIER,
            new Item.Properties().attributes(PickaxeItem.createAttributes(ModTiers.NONAME_TIER, 4.0F, -3.0F)),
            2
    ));
    public static final DeferredItem<HammerItem> IRON_HAMMER_ITEM = ITEMS.register("iron_hammer", () -> new HammerItem(
            Tiers.IRON,
            new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.IRON, 4.0F, -3.0F)),
            1
    ));
    public static final DeferredItem<HammerItem> GOLD_HAMMER_ITEM = ITEMS.register("gold_hammer", () -> new HammerItem(
            Tiers.GOLD,
            new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.GOLD, 4.0F, -3.0F)),
            1
    ));
    public static final DeferredItem<HammerItem> DIAMOND_HAMMER_ITEM = ITEMS.register("diamond_hammer", () -> new HammerItem(
            Tiers.DIAMOND,
            new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.DIAMOND, 4.0F, -3.0F)),
            1
    ));
    public static final DeferredItem<HammerItem> NETHERITE_HAMMER_ITEM = ITEMS.register("netherite_hammer", () -> new HammerItem(
            Tiers.NETHERITE,
            new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.NETHERITE, 4.0F, -3.0F)),
            1
    ));

    public static final DeferredItem<Item> SUSHI = ITEMS.registerSimpleItem("sushi", new Item.Properties().food(ModFoods.SUSHI_FOOD));
}
