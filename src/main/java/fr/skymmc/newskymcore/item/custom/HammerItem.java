package fr.skymmc.newskymcore.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class HammerItem extends DiggerItem {
    private int radius;

    public HammerItem(Tier tier, Properties properties, int radius) {
        super(tier, BlockTags.MINEABLE_WITH_PICKAXE, properties);
        this.radius = radius;
    }

    @Override
    public boolean mineBlock(@NotNull ItemStack stack, @NotNull Level level, @NotNull BlockState state, @NotNull BlockPos pos, @NotNull LivingEntity miningEntity) {
        if(!(miningEntity instanceof ServerPlayer)){
            return false;
        }
        ServerPlayer serverPlayer = (ServerPlayer) miningEntity;
        Tool tool = stack.get(DataComponents.TOOL);
        int damagePerBlock;

        if(tool != null){
            damagePerBlock = tool.damagePerBlock();
        } else {
            damagePerBlock = 1;
        }
        List<BlockPos> blockToMine = getBlocksToBeDestroyed(pos, serverPlayer);
        blockToMine.forEach(block -> {
            BlockState blockState = level.getBlockState(block);
            if(isCorrectToolForDrops(stack, blockState)){
                level.destroyBlock(block, true, miningEntity);
                stack.hurtAndBreak(damagePerBlock, miningEntity, EquipmentSlot.MAINHAND);
            }
        });
        return true;
    }

    protected List<BlockPos> getBlocksToBeDestroyed(BlockPos initalBlockPos, ServerPlayer player) {
        List<BlockPos> positions = new ArrayList<>();

        BlockHitResult traceResult = player.level().clip(new ClipContext(player.getEyePosition(1f),
                (player.getEyePosition(1f).add(player.getViewVector(1f).scale(6f))),
                ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));
        if(traceResult.getType() == HitResult.Type.MISS) {
            return positions;
        }

        if(traceResult.getDirection() == Direction.DOWN || traceResult.getDirection() == Direction.UP) {
            for(int x = -this.radius; x <= this.radius; x++) {
                for(int y = -this.radius; y <= this.radius; y++) {
                    positions.add(new BlockPos(initalBlockPos.getX() + x, initalBlockPos.getY(), initalBlockPos.getZ() + y));
                }
            }
        }

        if(traceResult.getDirection() == Direction.NORTH || traceResult.getDirection() == Direction.SOUTH) {
            for(int x = -this.radius; x <= this.radius; x++) {
                for(int y = -this.radius; y <= this.radius; y++) {
                    positions.add(new BlockPos(initalBlockPos.getX() + x, initalBlockPos.getY() + y, initalBlockPos.getZ()));
                }
            }
        }

        if(traceResult.getDirection() == Direction.EAST || traceResult.getDirection() == Direction.WEST) {
            for(int x = -this.radius; x <= this.radius; x++) {
                for(int y = -this.radius; y <= this.radius; y++) {
                    positions.add(new BlockPos(initalBlockPos.getX(), initalBlockPos.getY() + y, initalBlockPos.getZ() + x));
                }
            }
        }

        return positions;
    }
}
