package fr.skymmc.newskymcore;

import fr.skymmc.newskymcore.block.ModBlocks;
import fr.skymmc.newskymcore.item.ModItems;
import fr.skymmc.newskymcore.item.ModCreativeTabs;
import fr.skymmc.newskymcore.datagen.DataGenHandler;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(NewSkymCore.MODID)
public class NewSkymCore
{
    public static final String MODID = "newskymcore";
    public static final Logger LOGGER = LogUtils.getLogger();


    public NewSkymCore(IEventBus modEventBus, ModContainer modContainer) {

        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);

        registerDataGen(modEventBus);
    }

    private static void registerDataGen(IEventBus modEventBus){
        modEventBus.addListener(DataGenHandler::onGatherData);
    }
}
