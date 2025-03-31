package fr.skymmc.newskymcore.block;

import fr.skymmc.newskymcore.NewSkymCore;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public static class Blocks {
        public static final TagKey<Block> NEEDS_NONAME_TOOL = createTag("needs_noname_tool");
        public static final TagKey<Block> INCORRECT_FOR_NONAME_TOOL = createTag("incorrect_for_noname_tool");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(NewSkymCore.MODID, name));
        }
    }

}
