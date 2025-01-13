package net.noritei.moremeat.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.noritei.moremeat.block.custom.cooker;
import net.noritei.moremeat.item.modItems;
import net.noritei.moremeat.moremeat;

import java.util.function.Supplier;

public class modBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(moremeat.modId);

    public static final DeferredBlock<Block> CREEPER_MEAT_BLOCK = registerBlock("creeper_meat_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1f, 0f)
                    .sound(SoundType.NETHERRACK)
            ));

    public static final DeferredBlock<Block> MEAT_STONE = registerBlock("meat_stone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .requiresCorrectToolForDrops()
                    .strength(4f, 1f)
                    .sound(SoundType.NETHERRACK)
            ));

    public static final DeferredBlock<Block> MEAT_ORE = registerBlock("meat_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 6),
                    BlockBehaviour.Properties.of()
                    .requiresCorrectToolForDrops()
                    .strength(4f, 2f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> COOKER = registerBlock("cooker",
            () -> new cooker(BlockBehaviour.Properties.of()
                    .strength(2f)
            ));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        modItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
