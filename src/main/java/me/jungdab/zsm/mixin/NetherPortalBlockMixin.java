package me.jungdab.zsm.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.NetherPortalBlock;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(NetherPortalBlock.class)
public abstract class NetherPortalBlockMixin {
    /**
     * @author Jungdab
     * @reason block to enter nether
     */
    @Overwrite
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
    }
}
