package fr.skymmc.newskymcore.item;

import fr.skymmc.newskymcore.NewSkymCore;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NewSkymCore.MODID);

    public static final Supplier<CreativeModeTab> SKYMMC_TAB = CREATIVE_MODE_TABS.register("skymmc", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + NewSkymCore.MODID + ".skymmc"))
            .icon(() -> new ItemStack(ModItems.NONAME_INGOT.get()))
            .displayItems((params, output) -> {
                output.accept(ModItems.NONAME_INGOT);
                output.accept(ModItems.NONAME_RAW_ORE);
                output.accept(ModItems.NONAME_BLOCK);
                output.accept(ModItems.NONAME_ORE_BLOCK);
                output.accept(ModItems.NONAME_PICKAXE);
                output.accept(ModItems.NONAME_SWORD);
                output.accept(ModItems.NONAME_SHOVEL);
                output.accept(ModItems.NONAME_AXE);
                output.accept(ModItems.NONAME_HOE);
                output.accept(ModItems.NONAME_HAMMER_ITEM);
                output.accept(ModItems.NONAME_HELMET);
                output.accept(ModItems.NONAME_CHESTPLATE);
                output.accept(ModItems.NONAME_LEGGINGS);
                output.accept(ModItems.NONAME_BOOTS);
            })
            .build()
    );
}
