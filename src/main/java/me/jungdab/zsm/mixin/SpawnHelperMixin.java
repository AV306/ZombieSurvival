package me.jungdab.zsm.mixin;

import me.jungdab.zsm.registry.ModEntities;
import me.jungdab.zsm.world.gen.EntityGeneration;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.SpawnHelper;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SpawnHelper.class)
public abstract class SpawnHelperMixin {

    @Inject(at = @At("HEAD"), cancellable = true, method = "canSpawn")
    private static void canSpawn(ServerWorld world, SpawnGroup group, StructureAccessor structureAccessor, ChunkGenerator chunkGenerator, SpawnSettings.SpawnEntry spawnEntry, BlockPos.Mutable pos, double squaredDistance, CallbackInfoReturnable<Boolean> cir) {
        if(!EntityGeneration.canSpawn(spawnEntry.type, world.getTimeOfDay())) {
            cir.setReturnValue(false);
            cir.cancel();
        }

        if(spawnEntry.type != ModEntities.BASIC_ZOMBIE)
            if(pos.getY() < world.getTopPosition(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, pos).getY()) {
                cir.setReturnValue(false);
                cir.cancel();
            };
    }
}
