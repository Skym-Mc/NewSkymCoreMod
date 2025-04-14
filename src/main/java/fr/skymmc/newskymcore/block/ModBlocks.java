package fr.skymmc.newskymcore.block;

import fr.skymmc.newskymcore.NewSkymCore;
import fr.skymmc.newskymcore.block.custom.StatueBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(NewSkymCore.MODID);

    public static final DeferredBlock<Block> NONAME_BLOCK = BLOCKS.registerSimpleBlock(
            "noname_block",
            BlockBehaviour.Properties.of()
            .requiresCorrectToolForDrops()
            .strength(5.0F, 6.0F)
            .sound(SoundType.METAL)
    );

    public static final DeferredBlock<Block> NONAME_ORE_BLOCK = BLOCKS.registerSimpleBlock(
            "noname_ore_block",
            BlockBehaviour.Properties.of()
                    .requiresCorrectToolForDrops()
                    .strength(5.0F, 3.0F)
    );

    public static final DeferredBlock<StatueBlock> SKYM_STATUE = BLOCKS.register("skym_statue", () -> new StatueBlock(
            BlockBehaviour.Properties.of().noOcclusion()
    ));
}
