package fr.skymmc.newskymcore;

import fr.skymmc.newskymcore.common.register.ModBlocks;
import fr.skymmc.newskymcore.common.register.ModItems;
import fr.skymmc.newskymcore.common.register.ModCreativeTabs;
import fr.skymmc.newskymcore.data.DataGenHandler;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(NewSkymCore.MODID)
public class NewSkymCore
{
    public static final String MODID = "newskymcore";
    private static final Logger LOGGER = LogUtils.getLogger();


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
