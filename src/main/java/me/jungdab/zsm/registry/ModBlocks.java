package me.jungdab.zsm.registry;

import me.jungdab.zsm.ZSM;
import me.jungdab.zsm.block.Fence;
import me.jungdab.zsm.block.ReviveBlock;
import me.jungdab.zsm.block.TemperedBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final ReviveBlock REVIVE_BLOCK = register(
            "revive_block",
            new ReviveBlock(
                    AbstractBlock.Settings.create()
                            .nonOpaque()
                            .strength(0.6F)
            )
    );
    public static final Block ZOMBIE_INGOT_BLOCK = register(
            "zombie_ingot_block",
            new Block(
                    AbstractBlock.Settings.create()
                        .mapColor(MapColor.IRON_GRAY)
                        .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                        .requiresTool()
                        .strength(1.0F, 6.0F)
                        .sounds(BlockSoundGroup.METAL)
            )
    );

    public static final Block FENCE = register(
            "fence",
            new Fence(
                    AbstractBlock.Settings.create()
                            .requiresTool()
                            .strength(1.0f, 6.0f)
                            .sounds(BlockSoundGroup.METAL)
                            .nonOpaque()
            )
    );

    public static final Block CHIPPED_FENCE = register(
            "chipped_fence",
            new Fence(
                    AbstractBlock.Settings.create()
                            .requiresTool()
                            .strength(1.0f, 6.0f)
                            .sounds(BlockSoundGroup.METAL)
                            .nonOpaque()
            )
    );

    public static final Block DAMAGED_FENCE = register(
            "damaged_fence",
            new Fence(
                    AbstractBlock.Settings.create()
                            .requiresTool()
                            .strength(1.0f, 6.0f)
                            .sounds(BlockSoundGroup.METAL)
                            .nonOpaque()
            )
    );

    public static final Block TEMPERED_BLOCK = register(
            "tempered_block",
            new TemperedBlock(
                    AbstractBlock.Settings.create()
                            .requiresTool()
                            .strength(1.0f, 6.0f)
                            .sounds(BlockSoundGroup.METAL)
            )
    );

    public static final Block CHIPPED_TEMPERED_BLOCK = register(
            "chipped_tempered_block",
            new TemperedBlock(
                    AbstractBlock.Settings.create()
                            .requiresTool()
                            .strength(1.0f, 6.0f)
                            .sounds(BlockSoundGroup.METAL)
            )
    );

    public static final Block DAMAGED_TEMPERED_BLOCK = register(
            "damaged_tempered_block",
            new TemperedBlock(
                    AbstractBlock.Settings.create()
                            .requiresTool()
                            .strength(1.0f, 6.0f)
                            .sounds(BlockSoundGroup.METAL)
            )
    );

    private static <T extends Block> T register(String path, T block) {
        Registry.register(Registries.BLOCK, Identifier.of(ZSM.MOD_ID, path), block);
        Registry.register(Registries.ITEM, Identifier.of(ZSM.MOD_ID, path), new BlockItem(block, new Item.Settings()));

        return block;
    }

    public static void init() {}
}
