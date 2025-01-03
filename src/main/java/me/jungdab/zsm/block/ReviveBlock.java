package me.jungdab.zsm.block;

import com.mojang.serialization.MapCodec;
import me.jungdab.zsm.block.entity.ReviveBlockEntity;
import me.jungdab.zsm.registry.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ReviveBlock extends BlockWithEntity {

    public ReviveBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(0f, 0f, 0f, 1f, 0.5f, 1f);
    }

    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return createCodec(ReviveBlock::new);
    }

    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ReviveBlockEntity(pos, state);
    }

    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    public static void createReviveBlock(ServerPlayerEntity player) {
        BlockPos pos = player.getBlockPos();
        World world = player.getWorld();

        world.setBlockState(pos, ModBlocks.REVIVE_BLOCK.getDefaultState());

        BlockEntity blockEntity = world.getBlockEntity(pos);
        if(blockEntity instanceof ReviveBlockEntity entity) {
            entity.setUuid(player.getUuid());
        }
    }
}
